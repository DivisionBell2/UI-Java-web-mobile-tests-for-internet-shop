package Brands;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrandsPage;
import pages.MainPage;
import pages.SearchPage;
import testData.Categories;

public class test002SelectSomeBrand extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private BrandsPage brandsPage;
    private SearchPage searchPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        brandsPage = new BrandsPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void test002SelectSomeBrand() {
        String name;

        mainPage
                .selectMainMenuCategory(Categories.BRANDS.getValue(), Categories.BRAND_CATEGORY.getValue(), Categories.ALL_CATEGORIES.getValue());
        ;

        brandsPage
                .selectClothesCategory()
        ;

        name = brandsPage.getBrandName();

        brandsPage
                .clickBrandName()
        ;

        searchPage
                .checkPageHeadline(name)
                .checkProductBrandNames(name)
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
