package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class optiimng {

    public EventFiringWebDriver driver;

    public AndroidDriver<WebElement> androidDriver = null;
    public IOSDriver<WebElement> iOSDriver = null;

    public AppiumDriverLocalService service;
    public DesiredCapabilities dc = new DesiredCapabilities();

    public OptiimDriverListener handler = new OptiimDriverListener();

    public AppiumDriverLocalService createAppiumService() {
        AppiumDriverLocalService service;
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .usingAnyFreePort();
        service = builder.build();
        return service;
    }

    public void IOSTest(String udid) {
        dc.setCapability("deviceName", "iOS");
        dc.setCapability("udid", udid);
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("platformName", "iOS");
        dc.setCapability("platformVersion", "11.2");
        service = createAppiumService();
        iOSDriver = new IOSDriver<WebElement>(service, dc);
        driver = new EventFiringWebDriver(iOSDriver);
        driver.register(handler);
    }

    public void AndroidTest(String udid) {
        dc.setCapability("deviceName", "Android");
        dc.setCapability("udid", udid);
        dc.setCapability("noReset", true);
        service = createAppiumService();
        androidDriver = new AndroidDriver<>(service, dc);
        driver = new EventFiringWebDriver(androidDriver);
        driver.register(handler);
    }

    public void setCapability(String capabilityName, String value){
        dc.setCapability(capabilityName, value);
    }

    public void click(By _by){
        driver.findElement(_by).click();
    }

    public WebElement findElement(By _by){

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement element = driver.findElement(_by);
        //new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitElement(By _by, int seconds){
        WebElement element = driver.findElement(_by);
        //new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public void finishIOSTest(){
        if (iOSDriver != null) {
            iOSDriver.quit();
            driver.quit();
        }
        if (service.isRunning()) {
            service.stop();
        }
    }

    public void finishAndroidTest(){
        androidDriver.quit();
        if (androidDriver != null) {
            androidDriver.quit();
            driver.quit();
        }
        if (this.service.isRunning()) {
            service.stop();
        }
    }


}
