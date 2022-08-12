package tests.authen;

import api_learning.LoginWithComponents;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import org.openqa.selenium.Platform;
import tes_follows.authentication.LoginFlow;

public class LoginTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            LoginFlow loginFlow = new LoginFlow(appiumDriver, "teo@sth.com","12345678");
            loginFlow.gotoLoginScreen();
            loginFlow.login();

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
