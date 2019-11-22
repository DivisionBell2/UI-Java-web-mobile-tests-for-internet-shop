package Search;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import testData.Categories;

public class test002CheckSearchByFullBrandName extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    void test002CheckSearchByFullBrandName() {
        mainPage
                .selectMainMenuCategory(Categories.CLOTHES.getValue(), Categories.CATEGORIES.getValue())
        ;

        searchPage
                .clickFiltersBtn()
                .clickBrandsBtn()
        ;

        String brandName = searchPage.getFirstBrandName();
        System.out.println(brandName);

        searchPage
                .enterBrandNameInSearchInput(brandName)
                .checkConformityBrandName(brandName)
                .clickFirstSearchedCheckbox()
                .clickFilterApplyBtn()
                .clickShowChosenGoodsBtn()
                .checkTextInProductList(brandName)
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
