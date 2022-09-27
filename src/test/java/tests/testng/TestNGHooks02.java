package tests.testng;

import org.junit.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGHooks02 extends BaseTestNG {


    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t\t--->" + this.getClass().getSimpleName() + " Before Class ");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t\t--->" + this.getClass().getSimpleName() + " Before method ");
    }

    @Test(priority = 2)
    public void testSth01() {
        //throw new RuntimeException("FAILED");
        System.out.println(this.getClass().getSimpleName() + " Test method 01");
    }

    @Test(priority = 1, dependsOnMethods = {"testSth01"})
    public void testSth02() {
        System.out.println(this.getClass().getSimpleName() + " Test method 02");
    }

    @Test
    public void testSth03() {
        System.out.println(this.getClass().getSimpleName() + " Test method 03");
        String expectedResult = "a";
        String actualResult = "b";
      // Verifier.verifyEquals(actualResult, expectedResult);
        // Hard assertion
       // Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, expectedResult);
        Assert.fail();
    }

    @Test
    public void testSth04() {
        //SoftAssert
        String expectedResult = "a";
        String actualResult = "b";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult, "[ERR] Loi roi Teo oi");
        softAssert.assertEquals(actualResult, expectedResult, "[ERR] Loi roi Ti oi");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t\t--->" + this.getClass().getSimpleName() + " After method");
    }

}
