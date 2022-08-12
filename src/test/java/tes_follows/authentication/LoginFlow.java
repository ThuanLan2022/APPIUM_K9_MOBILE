package tes_follows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import tes_follows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private String username;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.username = username;
        this.password = password;
    }

    public void login() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComponent = loginScreen.loginFormComp();
        if (!username.isEmpty()) {
            loginFormComponent.inputUsername(username);
        }

        if (!password.isEmpty()) {
            loginFormComponent.inputUsername(password);
        }

        loginFormComponent.clickOnLoginBtn();
    }
}
