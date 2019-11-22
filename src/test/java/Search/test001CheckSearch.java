package Search;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;

public class test001CheckSearch extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test(enabled = false)
    void test001CheckSearch() {
        String searchText = "Кроссовки";

        searchPage
                .clickSearchButton()
                .enterInSearchInput(searchText)
                .checkTextInProductList(searchText)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
