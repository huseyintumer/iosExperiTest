package Tests;

import common.optiimng;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class iosTwitter extends optiimng {


    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {

        setCapability("bundleId", "com.atebits.Tweetie2");
        setCapability("xcodeOrgId", "29PDGXQ299");
        setCapability("xcodeSigningId", "iPhone Developer");
        setCapability("noReset", "true");
        setCapability("waitForAppScript", "false");
        setCapability("sendKeyStrategy", "setValue");


        //setCapability("usePrebuiltWDA", "true");
        //setCapability("showIOSLog", "true");
        //setCapability("showXcodeLog", "true");

        //setCapability("useNewWDA", "true");

        IOSTest(udid);

    }

    @Test(description = "share a twit on twitter app")
    public void testUntitled() {
        int randomNumber = new Random().nextInt(10000 + 1 - 1000) + 1000;
        String newID = "benim tweet " + randomNumber;
        findElement(By.id("Timelines_tab")).click();
        findElement(By.id("NavigationBarComposeButton")).click();
        findElement(By.xpath("//XCUIElementTypeOther[@name=\"T1TweetComposeViewController\"]/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys(newID);
        findElement(By.id("ComposeSendTweetButton")).click();
        findElement(By.id("TFNTwitterAvatarImageView.2328092518")).click();
        findElement(By.id("Profil")).click();
        findElement(By.id("Tweetler ve yanıtlar")).click();
    }

    @AfterClass
    public void tearDown() {
        finishIOSTest();
    }
}

