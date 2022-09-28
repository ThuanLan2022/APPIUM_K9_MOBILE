package tests;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest
    public void innitAppiumSession() {
        appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
    }

    @AfterTest
    public void quitAppiumSession() {
        if (appiumDriver!= null) {
            appiumDriver.quit();
        }
    }
}
