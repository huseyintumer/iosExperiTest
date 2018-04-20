package Tests;

import common.optiimng;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

public class firstTest extends optiimng {

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {
        setCapability("app", "/Users/huseyintumer/appiumstudio/original-apks/com.experitest.ExperiBank.LoginActivity.2.apk");
        setCapability("noReset", "true");
        //setCapability("appPackage", "com.experitest.ExperiBank");
        //setCapability("appActivity", ".LoginActivity");

        AndroidTest(udid);
    }

    @Step("a step")
    public void myStep() {
        findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");

    }
    @Test(description = "This is an android test")
    public void testUntitled() {
        myStep();
        //findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        //findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        //findElement(By.id("com.experitest.ExperiBank:id/mortageRequestButton")).click();
        //findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("huseyin");
        //findElement(By.id("com.experitest.ExperiBank:id/lastNameTextField")).sendKeys("tumer");

    }

    @AfterClass
    public void tearDown() {
        finishAndroidTest();
    }
}

