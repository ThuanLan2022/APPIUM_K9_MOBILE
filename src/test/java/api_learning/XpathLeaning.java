package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class XpathLeaning {

    //Implicit wait, Explicit wait
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

// CACH1: Kiem tra mot element không ton tai thi cach 1 dung try..catch block, nhưng không nên dùng nên dung cach 2

//        Exception e = null;
//
//        try {
//            MobileElement element = appiumDriver.findElement(MobileBy.AccessibilityId("taolao"));
//
//        } catch (NoSuchElementException noSuchElementException) {
//            e= noSuchElementException;
//        }
//
//        if(e==null){
//            Assert.fail("reason ...");
//        }

// Cach2: dùng findelements
//        List<MobileElement> elements = appiumDriver.findElements(MobileBy.AccessibilityId("taolao"));
//        if(!elements.isEmpty()){ // Nếu nó khác empty thì trả về fail vì khác mong muốn của mình
//            Assert.fail("reason ...");
//        }

        try {

            //Navigator to Login screen
            MobileElement navLoginScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreen.click();

            // Find all matching elements
            List<MobileElement> credFieldEl = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credFieldEl.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credFieldEl.get(PASSWORD_INDEX).sendKeys("12345678");

            //Có thể tìm cụ thể element theo xpath: //android.widget.EditText[@content-desc="input-email"] -> Nhiều khi nó hơi dài dòng
            // Do vậy dùng UISelector vào trang chủ như sau (vào gg gõ UISelector): https://developer.android.com/reference/androidx/test/uiautomator/UiSelector

            // Find login info by UISelector
            MobileElement loginInstructionEl = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device has\")"));
            System.out.println(loginInstructionEl.getText());


            //DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
