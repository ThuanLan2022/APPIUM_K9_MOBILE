package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {
  @Test
    public static void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        List<LoginCred> loginCreds = new ArrayList<>();
        loginCreds.add(new LoginCred("teo@Sth", "12345678"));
        loginCreds.add(new LoginCred("teo@Sth.com", "1234567"));
        loginCreds.add(new LoginCred("teo@Sth.com", "12345678"));
        try {

            for (LoginCred loginCred : loginCreds) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getEmail(), loginCred.getPassword());
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    public  static class LoginCred{
        private String email;
        private String password;

        public LoginCred(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
