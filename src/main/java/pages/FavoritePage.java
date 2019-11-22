package pages;

import helpers.ProductCard;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritePage extends AnyPage {
    private WebDriver driver;

    public FavoritePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String PRODUCT_NAME = "//div[@data-test=\"wishlist-item\"]/div/div/div/p";
    private static final String ORIGINAL_PRICE = "//span[@data-test=\"original-price\"]";
    private static final String DISCOUNT_PRICE = "//span[@data-test=\"discount-price\"]";
    private static final String DELETE_BUTTON = "//div/button[text()=\"Удалить\" and @class=\"busy-underdash \"]";
    private static final String EMPTY_WISHLIST_MESSAGE = "//p[text()=\"Ваш список избранного пуст.\"]";
    private static final String GO_TO_SAILS_BUTTON = "//a[text()=\"Перейти к покупкам\"]";


    @FindBy (xpath = PRODUCT_NAME)
    private List<WebElement> elProductName;
    @FindBy (xpath = ORIGINAL_PRICE)
    private List<WebElement> elOriginalPrice;
    @FindBy (xpath = DISCOUNT_PRICE)
    private List<WebElement> elDiscountPrice;
    @FindBy (xpath = DELETE_BUTTON)
    private WebElement elDeleteButton;
    @FindBy (xpath = EMPTY_WISHLIST_MESSAGE)
    private WebElement elEmptyWishlistMessage;
    @FindBy (xpath = GO_TO_SAILS_BUTTON)
    private WebElement elGoToSailsButton;

    @Step("I compare product cards from NPCPage")
    public FavoritePage checkProductCards(ProductCard ... cards) {
        for (ProductCard card : cards) {
            WebElement productCard = filterListByText(elProductName, card.getProductName());
            assert getInt(productCard.findElement(By.xpath(ORIGINAL_PRICE))) == card.getOriginalPrice();

            if (card.getDiscountPrice() != 0)
                assert getInt(productCard.findElement(By.xpath(DISCOUNT_PRICE))) == card.getDiscountPrice();
        }

        return this;
    }

    @Step("I click on delete button on product in wishlist")
    public FavoritePage clickDeleteButton() {
        sleep(1000);
        waitElementClickable(driver, elDeleteButton).click();
        return this;
    }

    @Step("I check empty wishlist (page makes message of empty wishlist and button 'go to sales'")
    public FavoritePage checkEmptyWishlist() {
        waitElementVisible(driver, elEmptyWishlistMessage);
        waitElementVisible(driver, elGoToSailsButton);
        return this;
    }
}
