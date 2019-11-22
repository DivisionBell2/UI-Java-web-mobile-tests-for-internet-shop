package pages;

import com.google.common.collect.Ordering;
import helpers.MainClass;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends MainClass {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String PRODUCT_LIST = "//div[@data-test=\"product-item\"]";
    private static final String SEARCH_BUTTON = "//span[@data-test=\"mobile-header-search\"]";
    private static final String SEARCH_INPUT = "//input[@type=\"search\"]";
    private static final String BRANDS_SEARCH_INPUT = "//input[@class=\"filter-search-input\"]";
    private static final String FILTERS_BUTTON= "//span[contains(.,\"Фильтры\")]";
    private static final String BRANDS_BUTTON = "//span[contains(.,\"Бренд\")]";
    private static final String DISCOUNT_BUTTON = "//span[contains(.,\"Скидка\")]";
    private static final String COLOR_BUTTON = "//span[contains(.,\"Цвет\")]";
    private static final String SIZES_BUTTON = "//span[contains(.,\"Размер\")]";
    private static final String BRANDS_LIST = "//div[@class=\"expandable-checkbox-container\"]/label/span";
    private static final String SIZES_LIST = "//label[@class=\"checkbox\"]/following::span[1]";
    private static final String FILTER_APPLY_BUTTON = "//a/span[contains(.,\"Применить\")]";
    private static final String SHOW_CHOSEN_GOODS_BUTTON = "//a/span[contains(.,\"Показать\")]";
    private static final String SORT_SELECT_MENU = "//a[@class=\"sm-button text-ellipsis bg-dominant-10\"][2]/span[1]";
    private static final String SORT_LIST = "//label/span[contains(.,\"По\")]";
    private static final String PRODUCT_CURRENT_PRICES = "//div[@data-test=\"product-item\"]/div[2]//span[@data-test=\"original-price\" and not (following-sibling::span[@data-test=\"discount-price\"]) or @data-test=\"discount-price\" and not (following-sibling::span[@data-test=\"original-price\"])]";
    private static final String PRODUCT_BRAND_NAME = "//div[@data-test=\"product-item\"]/div/div/h2[@data-test=\"brand-name\"]";
    private static final String PAGE_HEADLINE = "//span[@data-test=\"mobile-gender-categories\"]/span[1]";
    private static final String DISCOUNT_CHECKBOXES = "//label[@class=\"checkbox\"]/following-sibling::span";
    private static final String DISCOUNT_LABEL = "//div[@class=\"item-label discount\"]";
    private static final String DISCOUNT_PRICE = "//span[@data-test=\"discount-price\"]";
    private static final String COLOR_LIST = "//div[@class=\"expandable-checkbox-container\"]/label/span";

    @FindBy(xpath = PRODUCT_LIST)
    private List<WebElement> elProductList;
    @FindBy(xpath = SEARCH_BUTTON)
    private WebElement elSearchButton;
    @FindBy(xpath = SEARCH_INPUT)
    private WebElement elSearchInput;
    @FindBy(xpath = BRANDS_SEARCH_INPUT)
    private WebElement elBrandsSearchInput;
    @FindBy(xpath = FILTERS_BUTTON)
    private WebElement elFiltersButton;
    @FindBy(xpath = BRANDS_BUTTON)
    private WebElement elBrandsButton;
    @FindBy(xpath = DISCOUNT_BUTTON)
    private WebElement elDiscountButton;
    @FindBy(xpath = COLOR_BUTTON)
    private WebElement elColorButton;
    @FindBy(xpath = BRANDS_LIST)
    private List<WebElement> elBrandsList;
    @FindBy(xpath = FILTER_APPLY_BUTTON)
    private WebElement elFilterApplyButton;
    @FindBy(xpath = SHOW_CHOSEN_GOODS_BUTTON)
    private WebElement elShowChosenGoodsButton;
    @FindBy(xpath = SIZES_BUTTON)
    private WebElement elSizesButton;
    @FindBy (xpath = SIZES_LIST)
    private List<WebElement> elSizesList;
    @FindBy(xpath = SORT_SELECT_MENU)
    private WebElement elSortSelectMenu;
    @FindBy(xpath = SORT_LIST)
    private List<WebElement> elSortList;
    @FindBy(xpath = PRODUCT_CURRENT_PRICES)
    private List<WebElement> elProductCurrentPrices;
    @FindBy(xpath = PRODUCT_BRAND_NAME)
    private List<WebElement> elProductBrandName;
    @FindBy(xpath = PAGE_HEADLINE)
    private WebElement elPageHeadline;
    @FindBy(xpath = DISCOUNT_CHECKBOXES)
    private List<WebElement> elDiscountCheckboxes;
    @FindBy(xpath = DISCOUNT_LABEL)
    private List<WebElement> elDiscountLabel;
    @FindBy(xpath = DISCOUNT_PRICE)
    private List<WebElement> elDiscountPrice;
    @FindBy(xpath = COLOR_LIST)
    private List<WebElement> elColorList;

    @Step("I select first product item")
    public SearchPage selectFirstProduct() {
        waitElementVisible(driver, elProductList.get(elProductList.size() - 1));
        elProductList.get(0).click();
        return this;
    }

    @Step("I click on SearchButton")
    public SearchPage clickSearchButton() {
        elSearchButton.click();
        return this;
    }

    @Step("I enter {text} in search input")
    public SearchPage enterInSearchInput(String text) {
        waitElementVisible(driver, elSearchInput).sendKeys(text);
        elSearchInput.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("I check product list contains {text}")
    public SearchPage checkTextInProductList(String text) {
        filterListByText(elProductList, text);
        return this;
    }

    @Step("I click on filters button")
    public SearchPage clickFiltersBtn() {
        waitElementVisible(driver, elFiltersButton).click();
        return this;
    }

    @Step("I click on brands button")
    public SearchPage clickBrandsBtn() {
        waitElementClickable(driver, elBrandsButton).click();
        return this;
    }

    @Step("I click on discount button")
    public SearchPage clickDiscountBtn() {
        waitElementClickable(driver, elDiscountButton).click();
        return this;
    }

    @Step("I click on color button")
    public SearchPage clickColorBtn() {
        waitElementClickable(driver, elColorButton).click();
        return this;
    }

    @Step("I click on size button")
    public SearchPage clickSizeBtn() {
        waitElementClickable(driver, elSizesButton).click();
        return this;
    }

    @Step("I get brand from list")
    public String getFirstBrandName() {
        return elBrandsList.get(0).getText();
    }

    @Step("I get random size from list")
    public String getSize() {
        return elSizesList.get(1).getText();
    }

    @Step("I enter {name} in brand search input")
    public SearchPage enterBrandNameInSearchInput(String name) {
        elBrandsSearchInput.sendKeys(name);
        return this;
    }

    @Step("I check the conformity brand name to search result")
    public SearchPage checkConformityBrandName(String name) {
        isWebElementsOfListContainText(elBrandsList, name);
        return this;
    }

    @Step("I click the first searched brand checkbox")
    public SearchPage clickFirstSearchedCheckbox() {
        elBrandsList.get(0).click();
        return this;
    }

    @Step("I click the filter apply button")
    public SearchPage clickFilterApplyBtn() {
        elFilterApplyButton.click();
        return this;
    }

    @Step("I click the show chosen goods button")
    public SearchPage clickShowChosenGoodsBtn() {
        waitElementClickable(driver, elShowChosenGoodsButton).click();
        return this;
    }

    @Step("I select the {size} in filter")
    public SearchPage selectSizeInFilter(String size) {
        waitElementClickable(driver, elSizesList.get(elSizesList.size() - 1));
        filterListByText(elSizesList, size).click();
        return this;
    }

    @Step("I click sort menu")
    public SearchPage clickSortMenu() {
        waitElementClickable(driver, elSortSelectMenu).click();
        return this;
    }

    @Step("I select {parameter} in sort list")
    public SearchPage selectInSortList(String parameter) {
        WebElement category = filterListByText(elSortList, parameter);
        waitElementClickable(driver, category).click();
        return this;
    }

    @Step("I check sorted by price catalog")
    public SearchPage checkSortByPrice() {
        waitElementVisible(driver, elProductList.get(elProductList.size() - 1));
        List<Integer> priceList = elProductCurrentPrices
                .stream()
                .map(val -> getInt(val))
                .collect(Collectors.toList());
        assert Ordering.natural().isOrdered(priceList) : "list not ordered! " + priceList.toString();

        return this;
    }

    @Step("I check page headline is {name}")
    public SearchPage checkPageHeadline(String name) {
        waitForLoad(driver);
        waitElementVisible(driver, elPageHeadline);
        assert name.toLowerCase().contains(elPageHeadline.getText().toLowerCase());
        return this;
    }

    @Step("I check the products has brand name {name}")
    public SearchPage checkProductBrandNames(String name) {
        for (WebElement element : elProductBrandName) {
            assert name.toLowerCase().contains(element.getText().toLowerCase());
        }
        return this;
    }

    @Step("I click discount {discount}")
    public SearchPage clickDiscountCheckbox(String discount) {
        filterListByText(elDiscountCheckboxes, discount).click();
        return this;
    }

    @Step("I check discount products on page")
    public SearchPage checkDiscountProducts(String discountLabel) {
        assert elProductList.size() == elDiscountLabel.stream().filter(WebElement::isDisplayed).count();
        assert elProductList.size() == elDiscountPrice.stream().filter(WebElement::isDisplayed).count();
        for (WebElement label : elDiscountLabel)
            label.getText().equals(discountLabel);
        return this;
    }

    @Step("I check that all products have discount label")
    public SearchPage checkAllProductsHaveDiscountLabel() {
        assert elProductList.size() == elDiscountLabel.stream().filter(WebElement::isDisplayed).count();
        return this;
    }

    @Step("I click color {color}")
    public SearchPage clickColorCheckbox(String color) {
        sleep(1000);
        filterListByText(elColorList, color).click();
        return this;
    }
}
