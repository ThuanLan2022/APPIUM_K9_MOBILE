package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {

    //Implicit wait, Explicit wait
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {

            //Navigator to Form screen
            MobileElement navFormScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormScreen.click();

            // Wait until user is on Form screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

            // Get Mobile window Size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 0;
            int yEndPoint = 50 * screenHeight / 100;

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
            Thread.sleep(2000);
            List<MobileElement> notificationEls =
                    appiumDriver.findElements(MobileBy.id("android:id/notification_main_column"));

            // Can chung minh notifycation co ton tai
            Map<String, String> notificationContents = new HashMap<>();
            for (MobileElement notificationEl : notificationEls) {

//                MobileElement titleEl_ = notificationEl.findElements(MobileBy.id("android:id/title")).get(0);
//                if (titleEl_.isDisplayed()) {
//                    Assert.fail();
//                } else {
//                    throw new RuntimeException("loi roi ...");
//                }
                MobileElement titleEl = notificationEl.findElement(MobileBy.id("android:id/title"));
                MobileElement contentEl = notificationEl.findElement(MobileBy.id("android:id/text"));
                notificationContents.put(titleEl.getText().trim(),contentEl.getText().trim());

            }

            // Verification
            // App bug > always green | False negative-> App bi loi khong du lieu nhung scrip van pass -> Phai check xem list co rong khong?
            // False sensitive la scrip minh fail nhung app khong co bug

            if (notificationContents.keySet().isEmpty()) {
                throw new RuntimeException("No notification");
                //Assert.fail();
            }
            for (String title : notificationContents.keySet()) {
                System.out.println("Title: " + title);
                System.out.println("Content: " + notificationContents.get(title));
            }
            //DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
