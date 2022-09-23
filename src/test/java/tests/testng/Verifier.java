package tests.testng;

import junit.framework.AssertionFailedError;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verifier {

    public static void verifyEquals(String actualResult, String expectedResult) {
        if (!actualResult.equals(expectedResult)) {
            throw new AssertionFailedError("Expected result and actual value are different!");
        }
    }

}
