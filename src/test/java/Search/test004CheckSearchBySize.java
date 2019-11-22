package Search;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.NPCPage;
import pages.SearchPage;
import testData.Categories;

public class test004CheckSearchBySize extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private NPCPage npcPage;

    @BeforeMethod
    void setup(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        npcPage = new NPCPage(driver);
    }

    @Test(enabled = false)
    void test004CheckSearchBySize() {
        mainPage
                .selectMainMenuCategory(Categories.CLOTHES.getValue())
        ;

        searchPage
                .clickFiltersBtn()
                .clickSizeBtn()
        ;

        String size = searchPage.getSize();

        searchPage
                .selectSizeInFilter(size)
                .clickFilterApplyBtn()
                .clickShowChosenGoodsBtn()
                .selectFirstProduct()
        ;

        npcPage
                .checkSelectedSize(size)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
