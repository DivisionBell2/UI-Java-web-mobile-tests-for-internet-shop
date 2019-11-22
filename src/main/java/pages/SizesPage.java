package pages;

import helpers.MainClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SizesPage extends MainClass {
    private WebDriver driver;

    public SizesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String CATEGORY_SELECTOR = "//div[@role=\"button\"]/span[contains(., \"Одежда\")]";
    private static final String SIZES = "//div[@data-test=\"variation-size\"]";
    private static final String CATEGORIES = "//div[@class=\"new-dropdown select-dropdown\"]/a";
    @FindBy(xpath = CATEGORY_SELECTOR)
    List<WebElement> elCategorySelector;
    @FindBy(xpath = SIZES)
    List<WebElement> elSizes;
    @FindBy(xpath = CATEGORIES)
    List<WebElement> elCategories;

    @Step("I check main elements on page")
    public SizesPage checkMainelements() {
        waitElementVisible(driver, elCategorySelector);
        waitElementVisible(driver, elSizes.get(0));
        return this;
    }

    @Step("I check sizes in size table")
    public SizesPage checkSizesInTable() {
        waitElementVisible(driver, getRandomVisibleElementFromList(elSizes));
        return this;
    }

    @Step("I get sizes")
    public int getDimensionAmount() {
        return getListByVisibleElements(elSizes).hashCode();
    }

    @Step("I click on selector of tables")
    public SizesPage clickTablesSelector() {
        waitElementClickable(driver, CATEGORY_SELECTOR).click();
        return this;
    }

    @Step("I select category from drop menu")
    public SizesPage selectCategory() {
        waitElementClickable(driver, CATEGORIES);
        elCategories.get(ThreadLocalRandom.current().nextInt(1, elCategories.size())).click();
        return this;
    }

    @Step("I chec size table change")
    public SizesPage checkSizeTableChange(int num) {
        assert getListByVisibleElements(elSizes).hashCode() != num;
        return this;
    }
}
