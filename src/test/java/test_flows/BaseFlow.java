package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lab_16.models.pages.LoginScreen;
import models.pages.HomeScreen;

public class BaseFlow {

    public final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void gotoLoginScreen() {
        new LoginScreen(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }
    public void gotoFormScreen(){
        new HomeScreen(appiumDriver).bottomNavComponent().clickOnFormsIcon();
    }
}
