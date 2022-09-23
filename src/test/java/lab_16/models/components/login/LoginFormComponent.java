package lab_16.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By usernameSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailSel = MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPasswordSel = MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By loginSuccessSel = MobileBy.xpath("//*[contains(@text,'Success')]");

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

    public String getInvalidEmailStr() {
        return appiumDriver.findElement(incorrectEmailSel).getText();
    }

    public void inputPassword(String passwordTxt) {
        if (!passwordTxt.isEmpty()) {
            MobileElement passwordEl = appiumDriver.findElement(passwordSel);
            passwordEl.clear();
            passwordEl.sendKeys(passwordTxt);
        }

    }

    public String getInvalidPasswordStr() {
        return appiumDriver.findElement(incorrectPasswordSel).getText();
    }

    public void clickOnLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }

   public String getSuccessStr(){
        return appiumDriver.findElement(loginSuccessSel).getText();
   }
}
