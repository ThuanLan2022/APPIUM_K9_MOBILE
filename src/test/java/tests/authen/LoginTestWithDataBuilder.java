package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;
import test_data.DataObjectBuilder;
import test_data.models.LoginCred;

public class LoginTestWithDataBuilder {
    @Test(dataProvider = "loginCredData")
    public static void testLogin(LoginCred loginCred) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getEmail(), loginCred.getPassword());
            loginFlow.gotoLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    @DataProvider
    public LoginCred[] loginCredData() {
       String filePath ="src/test/java/test_data/authen/LoginCreds.json";
       return DataObjectBuilder.buildDataObject(filePath, LoginCred[].class);
    }
}
