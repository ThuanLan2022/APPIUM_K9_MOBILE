package tes_follows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lab_16.models.pages.LoginScreen;

public class BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void gotoLoginScreen() {
        new LoginScreen(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }
}
