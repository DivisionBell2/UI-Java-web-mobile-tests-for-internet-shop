package pages;

import helpers.ProductCard;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InstashopPage extends AnyPage {
    private WebDriver driver;

    public InstashopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String GALLERY_GOODS = "//li[contains(@class,\"frisbuy-gallery-post\")]";
    private static final String BUY_BUTTONS = "//div[@class=\"frisbuy-product-details\"]/div/div/button[text()=\"Купить\"]";
    private static final String PRODUCT_BRAND_NAME = "//div[@class=\"frisbuy-product-info frisbuy-mobile\"]/div/div/span";
    private static final String PRODUCT_PRICE = "//div[@class=\"frisbuy-product-info frisbuy-mobile\"]/div/div/div[@class=\"frisbuy-product-price\"]/span[1]";
    private static final String PRODUCT_NAME = "//div[@class=\"frisbuy-product-info frisbuy-mobile\"]/div/div/div[@class=\"frisbuy-mini-description\"]";
    private static final String PRODUCT_BRAND_NAME_BOTTOM = "//div[@class=\"frisbuy-scroller frisbuy-product-info\"]/div/a/span";
    private static final String PRODUCT_NAME_BOTTOM = "//div[@class=\"frisbuy-scroller frisbuy-product-info\"]/div/a/div[@class=\"frisbuy-mini-description\"]";
    private static final String PRODUCT_PRICE_BOTTOM = "//div[@class=\"frisbuy-scroller frisbuy-product-info\"]//div[@class=\"frisbuy-product-price\"]/span[1]";
    private static final String ADD_TO_CART_BUTTON = "//button[@class=\"frisbuy-add-button\"]";
    private static final String ADDED_TO_CART_MESSAGE = "//div[@class=\"frisbuy-cart-title\"]";
    private static final String SIZES = "//div[@class=\"frisbuy-modifications\"]/div[not(@disabled)]";
    private static final String TITLE = "//div[@class=\"frisbuy-header\" and contains(., \"INSTASHOP\")]";
    private static final String LOAD_MORE_BUTTON = "//button[@class=\"frisbuy-loadmore-button\"]";

    @FindBy(xpath = GALLERY_GOODS)
    private List<WebElement> elGalleryGoods;
    @FindBy(xpath = BUY_BUTTONS)
    private List<WebElement> elBuyButtons;
    @FindBy(xpath = PRODUCT_BRAND_NAME)
    private WebElement elProductBrandName;
    @FindBy(xpath = PRODUCT_PRICE)
    private WebElement elProductPrice;
    @FindBy(xpath = PRODUCT_NAME)
    private WebElement elProductName;
    @FindBy(xpath = PRODUCT_BRAND_NAME_BOTTOM)
    private WebElement elProductBrandNameBottom;
    @FindBy(xpath = PRODUCT_NAME_BOTTOM)
    private WebElement elProductNameBottom;
    @FindBy(xpath = PRODUCT_PRICE_BOTTOM)
    private WebElement elProductPriceBottom;
    @FindBy(xpath = ADD_TO_CART_BUTTON)
    private WebElement elAddToCartButton;
    @FindBy(xpath = ADDED_TO_CART_MESSAGE)
    private WebElement elAddedToCartMsg;
    @FindBy(xpath = SIZES)
    private List<WebElement> elSizes;
    @FindBy(xpath = TITLE)
    private WebElement elTitle;
    @FindBy(xpath = LOAD_MORE_BUTTON)
    private WebElement elLoadMoreButton;

    //OVERALL METHODS

    @Step("I select random goods group from gallery")
    public InstashopPage selectFirstGoodsGroupFromGallery() {
        sleep(1000);
        refreshPage();
        sleep(3000);
        waitElementVisible(driver, elTitle);
        waitElementVisible(driver, elGalleryGoods.get(0));
        getRandomVisibleElementFromList(elGalleryGoods).click();
        return this;
    }

    @Step("I select random good from list")
    public InstashopPage selectFirstGoodFromChangedGoodsImage() {
        waitForLoad(driver);
        waitElementVisible(driver, elBuyButtons.get(elBuyButtons.size() - 1));
        elBuyButtons.get(0).click();
        return this;
    }

    @Step("I compare product info on the page")
    public InstashopPage checkInfoOnProductPage() {
        compareWebelementsText(elProductBrandName, elProductBrandNameBottom);
        compareWebelementsText(elProductName, elProductNameBottom);
        assert getInt(elProductPrice) == getInt(elProductPriceBottom);
        return this;
    }

    @Step("I remember info about product")
    public InstashopPage rememberInfo(ProductCard productCard) {
        productCard.setProductName(elProductName.getText());
        productCard.setBrand(elProductBrandName.getText());
        productCard.setPrice(getInt(elProductPrice));
        return this;
    }

    @Step("I click on 'add to cart' button")
    public InstashopPage clickAddToCartButton() {
        elAddToCartButton.click();
        return this;
    }

    @Step("I click on make a purchase button")
    public InstashopPage clickMakePurchaseButton() {
        waitElementVisible(driver, elAddedToCartMsg);
        elAddToCartButton.click();
        return this;
    }

    @Step("I select size")
    public InstashopPage selectSize() {
        if (elSizes.size() > 0) {
            elSizes.get(0).click();
        }
        return this;
    }

    //SCROLLING METHODS

    public int getNumberOfImages() {
        return elGalleryGoods.size();
    }

    public InstashopPage movePageDown(int num) {
        refreshPage();
        waitForLoad(driver);
        scrollToElement(driver, elLoadMoreButton);
        return this;
    }

    public InstashopPage checkImagesAmount(int num) {
        sleep(1000);
        new WebDriverWait(driver, 10).until((t) -> elGalleryGoods.size() > num);
        return this;
    }
}
