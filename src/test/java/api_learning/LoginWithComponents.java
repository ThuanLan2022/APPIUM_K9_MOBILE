package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mobles.components.global.BottomNavComponent;
import mobles.components.login.LoginFormComponent;
import mobles.pages.LoginScreen;
import org.openqa.selenium.Platform;

public class LoginWithComponents {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            BottomNavComponent bottomNavComponent = loginScreen.bottomNavComp();
            LoginFormComponent loginFormComponent = loginScreen.loginFormComp();

            bottomNavComponent.clickOnLoginIcon();
            loginFormComponent.inputUsername("teo@sth.com");
            loginFormComponent.inputPassword("12345678");
            loginFormComponent.clickOnLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
