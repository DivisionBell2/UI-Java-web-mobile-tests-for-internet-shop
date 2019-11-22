package Sale;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import testData.Categories;

public class test001CheckSalesOnSalesPage extends MainClass {
  private WebDriver driver;
  private MainPage mainPage;
  private SearchPage searchPage;

  @BeforeMethod
  void setUp(ITestResult tr) {
    driver = setupDriver(tr);
    mainPage = new MainPage(driver);
    searchPage = new SearchPage(driver);
  }

  @Test(invocationCount = 3)
  void test001CheckSalesOnSalesPage() {
    mainPage.selectMainMenuCategory(Categories.SALE.getValue(), Categories.SALE_CATEGORY.getValue(), Categories.ALL_CATEGORIES.getValue());

    searchPage.checkAllProductsHaveDiscountLabel();
  }

  @AfterMethod
  void tearDown() {
    driver.quit();
  }

}
