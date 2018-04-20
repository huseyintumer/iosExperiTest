package common;

import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class OptiimDriverListener implements AppiumWebDriverEventListener {

    @Attachment(value = "Device screenshot", type = "image/jpeg")
    public byte[] takeScreenshot(WebDriver webDriver) {
        byte[] bytes = new byte[]{};
        try {
            bytes = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            System.out.println("Error takeScreenshot:" + e.getMessage());
        }
        return bytes;
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        takeScreenshot(webDriver);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        takeScreenshot(webDriver);
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Step("Before click element")
    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        takeScreenshot(webDriver);
    }

    @Step("After click element")
    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        takeScreenshot(webDriver);
    }

    @Step("Before change element value")
    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        takeScreenshot(webDriver);
    }

    @Step("After change element value")
    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        takeScreenshot(webDriver);
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        takeScreenshot(webDriver);
    }
}
