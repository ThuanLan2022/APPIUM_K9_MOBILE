package api_learning;

import driver.AppPackages;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleMultipleApps {

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

//           // Put the app under test to background in a certain time | simulate pressing home button > relaunch
//            // Nhan nút home sau 3s mở lại cho tui
//            appiumDriver.runAppInBackground(Duration.ofSeconds(3));

            // Put the app under test to background till we call it back
            // Chờ cho đến khi session của nó timeout mới hết
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            // Switch into another app |  go to settings toggle Wi-Fi
            appiumDriver.activateApp(AppPackages.SETTINGS);

            // Navigate to network list
            By connectionSel = MobileBy.xpath("//*[@text='Connections']");
            appiumDriver.findElement(connectionSel).click();
            Thread.sleep(3000);
            By wifiLabelSel = MobileBy.xpath("//*[@text='Wi-Fi']");
            appiumDriver.findElement(wifiLabelSel).click();
            Thread.sleep(3000);
            // Toggle ON/OFF
            By wifiStatusSel = MobileBy.id("com.android.settings:id/switch_text");
            MobileElement wifiStatusEl = appiumDriver.findElement(wifiStatusSel);
            String wifiStatusStr = wifiStatusEl.getText().trim();
            boolean isWifiOn = wifiStatusStr.equalsIgnoreCase("ON");
            if(isWifiOn) wifiStatusEl.click();

            // Come back to the app1
            appiumDriver.activateApp(AppPackages.WEBDRIVER_IO);
            appiumDriver.findElement(MobileBy.xpath("//*[@text ='OK']")).click();
            //DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
