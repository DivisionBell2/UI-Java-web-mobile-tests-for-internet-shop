package Brands;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrandsPage;
import pages.MainPage;
import testData.Categories;

public class test001CheckBrandPage extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private BrandsPage brandsPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        brandsPage = new BrandsPage(driver);
    }

    @Test
    public void test001CheckBrandPage() {

        mainPage
                .selectMainMenuCategory(Categories.BRANDS.getValue(), Categories.BRAND_CATEGORY.getValue(), Categories.ALL_CATEGORIES.getValue());
        ;

        brandsPage
                .waitForVisibleBrandPageBlocks()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
