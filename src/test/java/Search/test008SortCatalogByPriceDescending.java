package Search;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import testData.Categories;

public class test008SortCatalogByPriceDescending extends MainClass {
  private WebDriver driver;
  private MainPage mainPage;
  private SearchPage searchPage;

  @BeforeMethod
  void setup(ITestResult tr) {
    driver = setupDriver(tr);
    mainPage = new MainPage(driver);
    searchPage = new SearchPage(driver);
  }

  @Test
  void test005SortCatalogByPriceDescending() {
    mainPage
        .selectMainMenuCategory(Categories.SHOES.getValue(), Categories.CATEGORIES.getValue())
    ;

    searchPage
        .clickSortMenu()
        .selectInSortList("По убыванию цены")
    ;
  }
}
