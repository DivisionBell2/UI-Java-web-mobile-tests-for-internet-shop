package Auth;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import testData.User;

public class test006CheckAuthInstagram extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test(enabled = false)
    public void test006CheckAuthInstagram() {
        mainPage
                .openAuthPopup()
                .enterInstagramData(User.SOCIAL_LOGIN.getValue(), User.SOCIAL_PASS.getValue())
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
