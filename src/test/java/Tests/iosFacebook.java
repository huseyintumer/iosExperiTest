package Tests;

import common.optiimng;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class iosFacebook extends optiimng {


    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {
        setCapability("bundleId", "com.facebook.Facebook");
        setCapability("xcodeOrgId", "29PDGXQ299");
        setCapability("xcodeSigningId", "iPhone Developer");
        setCapability("noReset", "true");
        setCapability("waitForAppScript", "false");
        setCapability("sendKeyStrategy", "setValue");
        IOSTest(udid);
    }

    @Test(description = "Share photo on facebook app")
    public void testUntitled() {
        int randomNumber = new Random().nextInt(10000 + 1 - 1000) + 1000;
        String newID = "dememem bu " + randomNumber;
        findElement(By.id("photo")).click();
        findElement(By.id("edit-photo-button-1")).click();
        findElement(By.id("Bitti")).click();
        findElement(By.id("composer-text-view")).sendKeys(newID);
        findElement(By.id("Paylaş")).click();
        findElement(By.id("destination-picker-share-button")).click();
        waitElement(By.id(newID), 50);
    }

    @AfterClass
    public void tearDown() {
        finishIOSTest();
    }
}

