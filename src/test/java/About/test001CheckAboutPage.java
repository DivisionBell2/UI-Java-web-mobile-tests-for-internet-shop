package About;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.MainPage;

public class test001CheckAboutPage extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private AboutPage aboutPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);
    }

    @Test(enabled = false)
    public void test001CheckAboutPage() {
        mainPage
                .clickAboutButton()
        ;

        aboutPage
                .checkPageElements()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
