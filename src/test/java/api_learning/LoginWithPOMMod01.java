package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import mobles.pages.LoginScreenMod01;
import org.openqa.selenium.Platform;

public class LoginWithPOMMod01 {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigator to Login screen
            MobileElement navLoginScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreen.click();

            LoginScreenMod01 loginScreen = new LoginScreenMod01(appiumDriver);
            loginScreen.usernameEl().sendKeys("teo@sth.com");
            loginScreen.passwordEl().sendKeys("12345678");
            loginScreen.loginBtnEl().click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        appiumDriver.quit();
    }
}
