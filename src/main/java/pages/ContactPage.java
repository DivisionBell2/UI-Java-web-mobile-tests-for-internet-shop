package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends AnyPage {
  private WebDriver driver;

  public ContactPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  private static final String MENU_SELECT = "//div[contains(@class, \"select-summary\")]";
  private static final String INTERNET_SHOP_INFO = "//p[@data-test=\"internet-shop-info\"]";
  private static final String OFFLINE_SHOP_INFO = "//p[@data-test=\"offline-shop-info\"]";
  private static final String EMAIL_INFO = "//p[@data-test=\"email-info\"]";
  private static final String REQUISITES_INFO = "//p[@data-test=\"requisites-info\"]";
  private static final String MAP = "//ymaps";

  @FindBy(xpath = MENU_SELECT)
  WebElement elMenuSelect;
  @FindBy(xpath = INTERNET_SHOP_INFO)
  WebElement elInternetShopInfo;
  @FindBy(xpath = OFFLINE_SHOP_INFO)
  WebElement elOfflineShopInfo;
  @FindBy(xpath = EMAIL_INFO)
  WebElement elEmailInfo;
  @FindBy(xpath = REQUISITES_INFO)
  WebElement elRequisitesInfo;
  @FindBy(xpath = MAP)
  List<WebElement> elMap;

  public ContactPage isContentVisible() {
    assert waitElementVisible(driver, elMenuSelect).isDisplayed();
    assert waitElementVisible(driver, elInternetShopInfo).isDisplayed();
    assert waitElementVisible(driver, elOfflineShopInfo).isDisplayed();
    assert waitElementVisible(driver, elEmailInfo).isDisplayed();
    assert waitElementVisible(driver, elRequisitesInfo).isDisplayed();
    assert waitElementVisible(driver, elMap.get(0)).isDisplayed();
    return this;
  }

}
