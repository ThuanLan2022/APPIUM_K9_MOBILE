package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenMod01 {

    private final AppiumDriver<MobileElement> appiumDriver;

    // DEFINE SELECTORS
    private final static By usernameSel =MobileBy.AccessibilityId("input-email");
    private final static By passwordSel =MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel =MobileBy.AccessibilityId("button-LOGIN");


    public LoginScreenMod01(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // MobileElement
    public MobileElement usernameEl(){
        return appiumDriver.findElement(usernameSel);
    }

    public MobileElement passwordEl(){
        return appiumDriver.findElement(usernameSel);
    }

    public MobileElement loginBtnEl(){
        return appiumDriver.findElement(usernameSel);
    }
}
