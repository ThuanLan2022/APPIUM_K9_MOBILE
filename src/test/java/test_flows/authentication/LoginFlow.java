package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private String username;
    private String password;

    // Change to object attribute
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
            loginFormComponent.inputPassword(password);
        }

        loginFormComponent.clickOnLoginBtn();
    }

    public void verifyLogin() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComponent = loginScreen.loginFormComp();
        boolean isEmailValid = EmailValidator.getInstance().isValid(username);
        boolean isPasswordValil = password.length() >= 8;

        if (isEmailValid && isPasswordValil) {
            verifyCorrectLoginCreds(loginFormComponent);
        }

        if (!isEmailValid) {
            verifyIncorrectEmail(loginFormComponent);
        }
        if (!isPasswordValil) {
            verifyIncorrectPassword(loginFormComponent);
        }

    }

    // SUPPORT METHOD_ben ngoai se ko thay nhung cai verify nay
    @Step("Verify correct login credential")
    private void verifyCorrectLoginCreds(LoginFormComponent loginFormComp) {
        String actualLoginStr = loginFormComp.getSuccessStr();
        String expectedLoginStr = "Success";
        Assert.assertEquals("Success", expectedLoginStr, actualLoginStr);
//        System.out.println("actualLoginStr " + actualLoginStr);
//        System.out.println("expectedLoginStr " + expectedLoginStr);
    }

    @Step("Verify incorrect email")
    private void verifyIncorrectEmail(LoginFormComponent loginFormComp) {
        String actualInvalidEmailStr = loginFormComp.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email";
        Assert.assertEquals("[ERR] Invalid email str is not correct", expectedInvalidEmailStr, actualInvalidEmailStr);
//        System.out.println("actualInvalidEmailStr: " + actualInvalidEmailStr);
//        System.out.println("expectedInvalidEmailStr: " + expectedInvalidEmailStr);

    }

    @Step("Verify incorrect password")
    private void verifyIncorrectPassword(LoginFormComponent loginFormComp) {
        String actualInvalidPasswordStr = loginFormComp.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";
        Assert.assertEquals("[ERR] Invalid email str is not correct", expectedInvalidPasswordStr, actualInvalidPasswordStr);
//        System.out.println("actualInvalidPasswordStr: " + actualInvalidPasswordStr);
//        System.out.println("expectedInvalidPasswordStr: " + expectedInvalidPasswordStr);
    }

}
