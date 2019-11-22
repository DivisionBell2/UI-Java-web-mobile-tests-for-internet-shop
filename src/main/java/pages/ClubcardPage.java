package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClubcardPage extends AnyPage {
    private WebDriver driver;

    public ClubcardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String DESCRIPTION_TEXT = "//div[@id=\"top\"]/div//p";
    private static final String TERMS_LIST = "//div[@id=\"top\"]/div//p/following::ul/li";
    private static final String COST_AMOUNT = "//div[@id=\"top\"]//td[1]";
    private static final String DISCOUNT_PERCENT = "//div[@id=\"top\"]//td[2]";
    private static final String CLUBCARD_IMG = "//div[@id=\"top\"]//div[@class=\"text-center\"]/img";

    @FindBy(xpath = DESCRIPTION_TEXT)
    WebElement elDescriptionText;
    @FindBy(xpath = TERMS_LIST)
    List<WebElement> elTermsList;
    @FindBy(xpath = COST_AMOUNT)
    List<WebElement> elCostAmount;
    @FindBy(xpath = DISCOUNT_PERCENT)
    List<WebElement> elDiscountPercent;
    @FindBy(xpath = CLUBCARD_IMG)
    WebElement elClubcardImg;

    @Step("I check text block in conditions contains {content}")
    public ClubcardPage checkDescritpionText(String content) {
        compareTextInWebElement(driver, elDescriptionText, content);
        return this;
    }

    @Step("I check text block in list contains {content}")
    public ClubcardPage checkTermsText(String content) {
        filterListByText(elTermsList, content);
        return this;
    }

    @Step("I check clubcard discount table by {costAmount} and {discountPercent}")
    public ClubcardPage checkDiscountTable(String costAmount, String discountPercent) {
            int row = elCostAmount.indexOf(filterListByText(elCostAmount, costAmount));
            assert elDiscountPercent.get(row).getText().toLowerCase().contains(discountPercent.toLowerCase());
            return this;
    }

    @Step("I check clubcard image")
    public ClubcardPage checkClubcardImage() {
        elClubcardImg.isDisplayed();
        return this;
    }
}
