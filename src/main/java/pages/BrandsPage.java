package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrandsPage extends AnyPage {
    private WebDriver driver;

    public BrandsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String BRANDS_SELECT_MENU = "//div[@role=\"button\" and contains(@class, \"select-summary\")]";
    private static final String BRAND_ALPHABET_CHAR_LIST = "//section/ul/li/a";
    private static final String BRAND_ALPHABET_NAME_LIST = "//div[@data-test=\"brands-list\"]//a";
    private static final String SELECT_CATEGORY = "//div[@data-test=\"brands-menu-mobile\"]/a";
    private static final String CHAR_BRAND_SECTION = "//div[@data-test=\"brands-list\"]/div/div";

    @FindBy(xpath = BRANDS_SELECT_MENU)
    private WebElement elBRandSelectMenu;
    @FindBy(xpath = BRAND_ALPHABET_CHAR_LIST)
    private List<WebElement> elBrandAlphabetCharList;
    @FindBy(xpath = BRAND_ALPHABET_NAME_LIST)
    private List<WebElement> elBrandAlphabetNameList;
    @FindBy(xpath = SELECT_CATEGORY)
    private List<WebElement> elSelectCategory;
    @FindBy(xpath = CHAR_BRAND_SECTION)
    private List<WebElement> elCharBrandSection;

    @Step("I check elements on brand page")
    public BrandsPage waitForVisibleBrandPageBlocks() {
        waitForLoad(driver);
        sleep(1000);
        waitElementVisible(driver, elBRandSelectMenu);
        waitElementVisible(driver, elBrandAlphabetCharList);
        waitElementVisible(driver, elBrandAlphabetNameList);
        return this;
    }

    @Step("I select some category from select")
    public BrandsPage selectClothesCategory() {
        waitForLoad(driver);
        sleep(1000);
        waitElementVisible(driver, driver.findElement(By.xpath("//h1")));
        waitElementVisible(driver, elBRandSelectMenu);
        waitElementClickable(driver, elBRandSelectMenu).click();
        waitElementVisible(driver, elSelectCategory.get(elSelectCategory.size() - 1));
        waitElementClickable(driver, elSelectCategory.get(1)).click();
        return this;
    }

    @Step("I get name of brand")
    public String getBrandName() {
        sleep(500);
        return elBrandAlphabetNameList.get(0).getText().toLowerCase();
    }

    @Step("I select {name} and click on it")
    public BrandsPage clickBrandName() {
        waitElementClickable(driver, elBrandAlphabetNameList.get(0)).click();
        return this;
    }


}
