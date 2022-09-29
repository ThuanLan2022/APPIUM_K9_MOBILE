package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;
import test_data.models.LoginCred;

public class LoginTestWithDataProvider {
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


    @DataProvider()
    public LoginCred[] loginCredData() {
        LoginCred loginCred01 = new LoginCred("teo@", "12345678");
        LoginCred loginCred02 = new LoginCred("teo@Sth.com", "1234567");
        LoginCred loginCred03 = new LoginCred("teo@Sth.com", "12345678");
       return new LoginCred[]{loginCred01, loginCred02, loginCred03};
       // return new LoginCred[]{};
    }
}
