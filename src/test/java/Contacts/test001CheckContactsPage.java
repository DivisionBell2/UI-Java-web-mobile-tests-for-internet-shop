package Contacts;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.MainPage;

public class test001CheckContactsPage extends MainClass {
  private WebDriver driver;
  private MainPage mainPage;
  private ContactPage contactPage;

  @BeforeMethod
  void SetUp(ITestResult tr) {
    driver = setupDriver(tr);
    mainPage = new MainPage(driver);
    contactPage = new ContactPage(driver);
  }

  @Test
  public void test001CheckContactsPage() {
    mainPage.clickContactsPage();

    contactPage.isContentVisible();
  }

  @AfterMethod
  void tearDown() {
    driver.quit();
  }
}
