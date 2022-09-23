package lab_16.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenMod02 {

    private final AppiumDriver<MobileElement> appiumDriver;

    // DEFINE SELECTORS
    private final static By usernameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");


    public LoginScreenMod02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputUserName(String userNameTxt) {
        if (!userNameTxt.isEmpty()) {
            appiumDriver.findElement(usernameSel).sendKeys(userNameTxt);
        }
    }

    public void inputPassword(String passwordTxt) {
        if (!passwordTxt.isEmpty()) {
            appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
        }

    }

    public void clickOnLoginBtn() {

        appiumDriver.findElement(loginBtnSel).click();
    }
}
