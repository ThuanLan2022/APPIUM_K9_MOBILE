package tests.parallel;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class LoginDevice02 extends BaseTest {
    @Test
    public void testLogin() {
        System.out.println("---> Session ID: " + getDriver().getSessionId());
        //Navigator to Form screen
        MobileElement navFormScreen = getDriver().findElement(MobileBy.AccessibilityId("Forms"));
        navFormScreen.click();

        // Wait until user is on Form screen
        WebDriverWait wait = new WebDriverWait(getDriver(), 10L);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

        // Get Mobile window Size
        Dimension windowSize = getDriver().manage().window().getSize();
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
        TouchAction touchAction = new TouchAction(getDriver());
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint)
                .release()
                .perform();

        // Thiet ke theo functional programming
//            // Swipe up form 90 -> 10
//            Swipe.swipeVertically();
//
//            // Swipe up | step 10%, 5 times
//            Swipe.swipeVertically(10,5);


        // Swipe down - revert coordinates _ngon tay keo xuong
            /*
            * .press(endPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
            * -> can be replace to : longPress
            *
            * */
        touchAction
                .longPress(endPoint)
                .moveTo(startPoint)
                .release()
                .perform();

    }


}
