package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends AnyPage {
    private WebDriver driver;

    public AboutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final String TITLE = "//h1[contains(., \"Универмаг\") and contains(., \"Интернет-магазин\")]";
    private final String ADDRESS_BLOCK = "//div[@class=\"static-about\"]//div[@class=\"static-about-address m-b-xs_2 m-b-sm_3\"]";
    private final String YANDEX_MAP = "//div[@id=\"map\"]";
    private final String ABOUT_CLUB_CARD_BLOCK = "//div[contains(@class, \"static-about-club\")]";

    @FindBy(xpath = TITLE)
    WebElement elTitle;
    @FindBy(xpath = ADDRESS_BLOCK)
    WebElement elAdressBlock;
    @FindBy(xpath = YANDEX_MAP)
    WebElement elYaMap;
    @FindBy(xpath = ABOUT_CLUB_CARD_BLOCK)
    WebElement elAboutClubCard;

    public AboutPage checkPageElements() {
        waitElementVisible(driver, elTitle);
        waitElementVisible(driver, elAdressBlock);
        waitElementVisible(driver, elYaMap);
        waitElementVisible(driver, elAboutClubCard);
        return this;
    }
}
