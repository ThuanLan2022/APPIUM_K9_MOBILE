package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitMoreThanOneContext implements ExpectedCondition<Boolean> {

    private  final AppiumDriver<MobileElement> appiumDriver;
    public WaitMoreThanOneContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Override
    public Boolean apply(@NullableDecl WebDriver input) {
        // Cho cho cai gi do bang cai j do xuat hien
        //return appiumDriver.findElement(MobileBy.AccessibilityId("sth")).getText().equals("sth");
        return appiumDriver.getContextHandles().size() > 1;
    }
}
