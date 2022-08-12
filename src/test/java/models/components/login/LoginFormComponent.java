package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By usernameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputUsername(String usernameTxt) {
        if (!usernameTxt.isEmpty()) {
            MobileElement usernameEl = appiumDriver.findElement(usernameSel);
            usernameEl.clear();
            usernameEl.sendKeys(usernameTxt);
        }
    }

    public void inputPassword(String passwordTxt) {
        if (!passwordTxt.isEmpty()) {
            MobileElement passwordEl = appiumDriver.findElement(usernameSel);
            passwordEl.clear();
            passwordEl.sendKeys(passwordTxt);
        }

    }

    public void clickOnLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }
}
