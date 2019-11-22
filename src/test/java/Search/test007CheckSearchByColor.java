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

public class test007CheckSearchByColor extends MainClass {
  private WebDriver driver;
  private MainPage mainPage;
  private SearchPage searchPage;
  private NPCPage npcPage;

  @BeforeMethod
  void setUp(ITestResult tr) {
    driver = setupDriver(tr);
    mainPage = new MainPage(driver);
    searchPage = new SearchPage(driver);
    npcPage = new NPCPage(driver);
  }

  @Test
  void test007CheckSearchByColor() {
    mainPage.selectMainMenuCategory(Categories.BAGS.getValue());

    searchPage.clickFiltersBtn()
              .clickColorBtn()
              .clickColorCheckbox("Белый")
              .clickFilterApplyBtn()
              .clickShowChosenGoodsBtn()
              .selectFirstProduct();

    npcPage.checkTextInProductDescription("Белый");

  }

  @AfterMethod
  void tearDown() {
    driver.quit();
  }
}
