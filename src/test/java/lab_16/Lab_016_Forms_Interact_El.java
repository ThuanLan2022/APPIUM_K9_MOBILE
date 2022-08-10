package lab_16;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab_016_Forms_Interact_El {

    static AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

    //Implicit wait, Explicit wait
    public static void main(String[] args) {


        try {

            //Navigator to Form screen
            MobileElement navFormScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormScreen.click();

            // Wait until user is on Form screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

            swipeUp();

            MobileElement inputFieldTxt = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement switchBtn = appiumDriver.findElement(MobileBy.xpath("//android.widget.Switch[@content-desc=\"switch\"]"));
            MobileElement dropdownDrop = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]//android.widget.EditText"));

            // Interact to Elements
            inputFieldTxt.sendKeys("ThuanLan");
            switchBtn.click();
            dropdownDrop.click();

            Thread.sleep(500);

            List<MobileElement> options = appiumDriver.findElements(MobileBy.xpath("//android.widget.ListView/android.widget.CheckedTextView"));
            if (options.isEmpty()) {
                throw new RuntimeException("No element in list!");
            }
            for (MobileElement option : options) {
                System.out.println(option.getText());
                if (option.getText().equals("Appium is awesome")) {
                    option.click();
                    break;
                }
            }

            // Click on btn Active
            MobileElement activeBtnEl = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtnEl.click();

            MobileElement okBtnEl = appiumDriver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"OK\"]"));
            okBtnEl.click();

            //DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();


    }

    public static void swipeUp() {
        // Get Mobile window Size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Calculate touch points
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        //Convert coordinates -> PointOption
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        //Using TouchAction to swipe
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint)
                .release()
                .perform();
    }

}
