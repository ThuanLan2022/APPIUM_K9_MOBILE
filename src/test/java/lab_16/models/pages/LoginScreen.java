package lab_16.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lab_16.models.components.global.BottomNavComponent;
import lab_16.models.components.login.LoginFormComponent;

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
