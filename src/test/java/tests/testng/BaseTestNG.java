package tests.testng;

import org.testng.annotations.*;

public class BaseTestNG {

    //testNG Hook
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("\t--->" + this.getClass().getSimpleName() + "Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t\t--->" + this.getClass().getSimpleName() + " Before Test ");
    }

}
