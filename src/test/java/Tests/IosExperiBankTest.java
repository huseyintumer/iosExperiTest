package Tests;

import common.optiimng;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

public class IosExperiBankTest extends optiimng {

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {
        File file = new File("resources/com.experitest.ExperiBank.1.ipa");
        String absolutePath = file.getAbsolutePath();
        dc.setCapability("xcodeOrgId", "29PDGXQ299");
        dc.setCapability("xcodeSigningId", "iPhone Developer");
        dc.setCapability("app", absolutePath);
        IOSTest(udid);
    }

    @Step("Set username")
    public void myNewStep1(){
        findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"usernameTextField\"])[1]")).sendKeys("company");
    }

    @Step("Set password")
    public void myNewStep2(){
        findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name=\"passwordTextField\"])[1]")).sendKeys("company");

    }

    @Step("Click Login button")
    public void myNewStep3(){
        findElement(By.id("loginButton")).click();

    }

    @Step("Click on Make Payment")
    public void myNewStep4(){
        findElement(By.id("makePaymentButton")).click();

    }

    @Step("Set Name")
    public void myNewStep5(){
        findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"nameTextField\"])[1]")).sendKeys("Huseyin");
    }

    @Test(description = "First Testcase for ios")
    public void testUntitled() {
        myNewStep1();
        myNewStep2();
        myNewStep3();
        myNewStep4();
        myNewStep5();

    }

    @AfterClass
    public void tearDown() {
        finishIOSTest();
    }
}

