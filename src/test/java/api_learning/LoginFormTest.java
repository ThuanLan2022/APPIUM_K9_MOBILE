package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormTest {

    //Implicit wait, Explicit wait
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);


        try {

            //Navigator to Login screen
            MobileElement navLoginScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreen.click();

            //Find Login form elements
            MobileElement emailInputEl = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passInputEl = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnEl = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            //Fill the form and login
            emailInputEl.sendKeys("teo@sth.com");
            passInputEl.sendKeys("12345678");
            loginBtnEl.click();

            // Verification | Login dialog
            //ID | android:id/alertTitle
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));

            MobileElement loginDialogTitleEl = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(loginDialogTitleEl.getText());

            //DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
