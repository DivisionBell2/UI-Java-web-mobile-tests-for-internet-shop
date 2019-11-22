package pages;

import helpers.ProductCard;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NPCPage extends AnyPage {
    private WebDriver driver;

    public NPCPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //PAGE ELEMENTS
    private static final String SIZES = "//div[contains(@class,\"size\") and @data-id]";
    private static final String ADD_TO_CART_BUTTON = "//button[@data-test=\"addToCart\"]";
    private static final String CHECK_THE_ORDER_BUTTON = "//a[@class=\"block bt-button-dark text-center width-100p\"]";
    private static final String CART_POPUP_MESSAGE = "//h4[contains(text(), 'Добавлено в корзину')]";
    private static final String CLOSE_POPUP_BUTTON = "//span[@role=\"button\"]";
    private static final String CART_POPUP = "//section[@class=\"narrow-max-width sm-max-width-100p col-start-stretch\"]/a";
    private static final String ADD_TO_FAVORITE_BUTTON = "//button[@data-test=\"addToFavorite\"]";
    private static final String SHARE_VK_BUTTON = "//a[@class=\"responsive-social-button\" and contains(@href, \"https://vk.com\")]";

    //PRODUCT_PARAMETERS
    private static final String SKU = "//span[@data-test=\"sku\"]";
    private static final String ORIGINAL_PRICE = "//div[@class=\"card-header\"]//span[@data-test=\"original-price\"]";
    private static final String DISCOUNT_PRICE = "//div[@class=\"card-header\"]//span[@data-test=\"discount-price\"]";
    private static final String PRODUCT_NAME = "//h4[@data-test=\"name\"]";
    private static final String SIZES_RUS_BUTTON = "//span[@data-size-name=\"RUS\"]";
    private static final String PRODUCT_DESCRIPTION = "//section[@data-test=\"product-card\"]//div[contains(@class, \"card-sticky\")]/div/section[2]/p";

    //PAGE ELEMENTS
    @FindBy(xpath = SIZES)
    private List<WebElement> elSizes;
    @FindBy(xpath = ADD_TO_CART_BUTTON)
    private WebElement elAddToCartBtn;
    @FindBy(xpath = CHECK_THE_ORDER_BUTTON)
    private WebElement elCheckOrderBtn;
    @FindBy(xpath = CART_POPUP_MESSAGE)
    private WebElement elCartPopupMessage;
    @FindBy(xpath = CLOSE_POPUP_BUTTON)
    private WebElement elClosePopupBtn;
    @FindBy(xpath = CART_POPUP)
    private WebElement elCartPopup;
    @FindBy(xpath = ADD_TO_FAVORITE_BUTTON)
    private WebElement elAddToFavoriteBtn;
    @FindBy(xpath = SHARE_VK_BUTTON)
    WebElement elShareVKButton;

    //PRODUCT_PARAMETERS
    @FindBy(xpath = SKU)
    private WebElement elSku;
    @FindBy(xpath = ORIGINAL_PRICE)
    private WebElement elOriginalPrice;
    @FindBy(xpath = DISCOUNT_PRICE)
    private WebElement elDiscountPrice;
    @FindBy(xpath = PRODUCT_NAME)
    private WebElement elProductName;
    @FindBy(xpath = SIZES_RUS_BUTTON)
    private WebElement elSizesRusButton;
    @FindBy(xpath = PRODUCT_DESCRIPTION)
    private WebElement elProductDescription;

    @Step("I change product size")
    public NPCPage selectSize() {
        if (elSizes.size() > 0) {
            WebElement size = elSizes.get(getRandomElementFromList(elSizes));
            size.click();
            return this;
        }

        return this;
    }

    @Step("I click the 'add-to-cart-button'")
    public NPCPage clickAddToCartBtn() {
        sleep(1500);
        waitElementClickable(driver, elAddToCartBtn).click();
        sleep(1000);
        return this;
    }

    @Step("I check cart popup")
    public NPCPage checkCartPopupMessage(String text) {
        assert waitElementVisible(driver, elCartPopupMessage)
                .getText()
                .toLowerCase()
                .contains(text.toLowerCase());
        return this;
    }

    @Step("I check the page is on the top")
    public NPCPage waitScrollComplete(WebDriver driver) {
        sleep(1500);
        new WebDriverWait(driver, 15).until((ExpectedCondition<Boolean>) val -> {
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    return parseInt(jse.executeScript("return window.pageYOffset").toString()) <= 25;
                }
        );
        return this;
    }

    @Step("I click the 'check-order' button")
    public NPCPage clickCheckOrderButton() {
        waitElementClickable(driver, elCheckOrderBtn).click();
        return this;
    }

    @Step("I close cart popup")
    public NPCPage closeCartPopup() {
        elClosePopupBtn.click();
        return this;
    }

    @Step("I check that cart popup is closed")
    public NPCPage checkCartPopupClosed() {
        waitElementInvisible(driver, CART_POPUP);
        return this;
    }

    @Step("I click the cart icon")
    public NPCPage clickCartIconInHeader() {
        clickCartIcon();
        return this;
    }

    @Step("I remember product info")
    public NPCPage rememberInfo(ProductCard card) {
        try {
            card.setDiscountPrice(getInt(elDiscountPrice));
            card.setOriginalPrice(getInt(elOriginalPrice));

        } catch (NoSuchElementException e) {
            card.setOriginalPrice(getInt(elOriginalPrice));
        }

        if (card.getDiscountPrice() > 0) {
            card.setPrice(card.getDiscountPrice());
        } else {
            card.setPrice(card.getOriginalPrice());
        }

        card.setSku(elSku.getText());
        card.setProductName(elProductName.getText());
        return this;
    }

    @Step("I click on add-to-favorite button")
    public NPCPage clickAddToFavoriteBtn() {
        waitElementClickable(driver, elAddToFavoriteBtn).click();
        return this;
    }

    @Step("I click favorite button in header")
    public NPCPage clickFavoriteButtonInHeader() {
        clickFavoriteButton();
        return this;
    }

    @Step("I check selected size on product page")
    public NPCPage checkSelectedSize(String size) {
        ArrayList<String> sizes = new ArrayList<>();
        waitElementVisible(driver, elSizes);
        for (WebElement element : elSizes) {
            sizes.add(element.getText().toLowerCase());
        }
        waitElementVisible(driver, elSizes.get(elSizes.size() - 1));
        for (WebElement element : elSizes) {
            sizes.add(element.getText().toLowerCase());
        }
        for (int i = 0; i < sizes.size(); i++) {
            System.out.print(sizes.get(i) + " ");
        }
        System.out.println(driver.getCurrentUrl());
        sizes
                .stream()
                .filter(val -> val.contains(size.toLowerCase()))
                .findFirst()
                .orElseThrow(java.util.NoSuchElementException::new);
        return this;
    }

    @Step("I click share VK button")
    public NPCPage clickShareVKButton() {
        waitElementClickable(driver, elShareVKButton).click();
        return this;
    }

    @Step("I log in VK")
    public NPCPage logVK(String user, String password) {
        switchToNewWindow();
        fillVKData(user, password);
        return this;
    }

    @Step("I check {text} in description")
    public NPCPage checkTextInProductDescription(String text) {
        isTextExist(driver, elProductDescription, text);
        return this;
    }
}
