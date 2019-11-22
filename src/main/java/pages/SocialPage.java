package pages;

import helpers.ProductCard;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialPage extends AnyPage {
    private WebDriver driver;

    public SocialPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String PUBLISH_VK_BUTTON = "//input[@class=\"button\"]";
    private static final String WATCH_PUBLISH_BUTTON = "//a[contains(@class, \"button\")]";
    private static final String VK_FIRST_WALL_ITEM_TEXT = "//div[@class=\"wall_item\"][1]//div[@class=\"pi_text\"]";
    private static final String VK_FIRST_WALL_ITEM_BUTIK_LINK = "//div[@class=\"wall_item\"][1]//a[contains(@class,\"-filler\")]";
    private static final String VK_WALL_ITEM_MENU = "//div[@class=\"wall_item\"][1]//a[@class=\"wi_actions_btn\"]/i";
    private static final String VK_WALL_ITEM_DELETE_BUTTON = "//ul[@class=\"wi_actions\"]/li/a[contains(@href, \"delete\")][1]";

    @FindBy(xpath = PUBLISH_VK_BUTTON)
    WebElement elPublishVKButton;
    @FindBy(xpath = WATCH_PUBLISH_BUTTON)
    WebElement elWatchPublishButton;
    @FindBy(xpath = VK_FIRST_WALL_ITEM_TEXT)
    WebElement elVKFirstWAllItemText;
    @FindBy(xpath = VK_FIRST_WALL_ITEM_BUTIK_LINK)
    WebElement elButikLink;
    @FindBy(xpath = VK_WALL_ITEM_MENU)
    WebElement elItemMenu;
    @FindBy(xpath = VK_WALL_ITEM_DELETE_BUTTON)
    WebElement elItemDeleteButton;

    @Step("I click on publish button in VK")
    public SocialPage clickPublishVKButton() {
        waitElementClickable(driver, elPublishVKButton).click();
        return this;
    }

    @Step("I click on watch publish button")
    public SocialPage clickWatchPublish() {
        waitElementVisible(driver, elWatchPublishButton).click();
        return this;
    }

    @Step("I compare the first wall item contains product info")
    public SocialPage compareProductInfo(ProductCard info) {
        compareTextInWebElement(driver, elVKFirstWAllItemText, info.getProductName());
        return this;
    }

    @Step("I get href from VK snippet")
    public String getSnippetHref() {
        return elButikLink.getAttribute("href");
    }

    @Step("I compare url from VK snippet")
    public SocialPage compareUrl(String url) {
        assert driver.getCurrentUrl().contains(url);
        return this;
    }

    @Step("I delete VK wall item")
    public SocialPage deleteVKWallItem() {
        waitElementClickable(driver, elItemMenu).click();
        waitElementVisible(driver, elItemDeleteButton);
        waitElementClickable(driver, elItemDeleteButton).click();
        return this;
    }

    @Step("I go to snippet url")
    public SocialPage goToSnippetURL(String url) {
        driver.get(url);
        return this;
    }








}
