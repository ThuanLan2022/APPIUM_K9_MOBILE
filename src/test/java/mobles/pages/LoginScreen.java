package mobles.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mobles.components.global.BottomNavComponent;
import mobles.components.login.LoginFormComponent;

public class LoginScreen {


    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent loginFormComp() {
        return new LoginFormComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }
}
