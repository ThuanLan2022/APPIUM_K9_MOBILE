package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tes_follows.authentication.LoginFlow;
import test_data.DataObjectBuilder;
import test_data.models.LoginCred;
import tests.BaseTest;

public class LoginTestWithBaseTest extends BaseTest {
    @Test(dataProvider = "loginCredData")
    public static void testLogin(LoginCred loginCred) {
        LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getEmail(), loginCred.getPassword());
        loginFlow.gotoLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginCred[] loginCredData() {
        String filePath = "/src/test/java/test_data/authen/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCred[].class);
    }
}
