package utils;

import common.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setUp() {

        BrowserSetUp.setBrowser();
        BrowserSetUp.navigateToUrl(Constants.URL);
    }

    @AfterClass
    public void tearDown() {

        BrowserSetUp.tearDown();
    }

}
