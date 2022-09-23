package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab_16.models.pages.LoginScreenMod02;
import org.openqa.selenium.Platform;

public class LoginWithPOMMod02 {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigator to Login screen
            MobileElement navLoginScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreen.click();

            LoginScreenMod02 loginScreen = new LoginScreenMod02(appiumDriver);
            loginScreen.inputUserName("teo@sth.com");
            loginScreen.inputPassword("12345678");
            loginScreen.clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        appiumDriver.quit();
    }
}
