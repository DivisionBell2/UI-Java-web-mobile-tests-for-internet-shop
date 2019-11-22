package Sizes;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SizesPage;

public class test001CheckSizesPage extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SizesPage sizesPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        sizesPage = new SizesPage(driver);
    }

    @Test
    public void test001CheckSizesPage() {
        mainPage
                .clickSizesTablesButton()
        ;

        sizesPage
                .checkMainelements()
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
