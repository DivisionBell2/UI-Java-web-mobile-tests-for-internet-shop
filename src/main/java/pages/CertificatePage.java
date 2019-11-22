package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class CertificatePage extends AnyPage {
    private WebDriver driver;

    public CertificatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String CERTIFICATE_IMAGE = "//img[contains(@src, \"/assets/images\")]";
    private static final String BUY_BUTTONS = "//span[contains(., \"Купить\")]";
    private static final String CERTIFICATE_CONDITION_TITLE = "//button[contains(.,\"Правила использования сертификатов\")]";
    private static final String CERTIFICATE_CONDITION_TEXT = "//p";

    @FindBy(xpath = CERTIFICATE_IMAGE)
    List<WebElement> elCertificateImage;
    @FindBy(xpath = BUY_BUTTONS)
    List<WebElement> elBuyButtons;
    @FindBy(xpath = CERTIFICATE_CONDITION_TITLE)
    WebElement elCertificateConditionTitle;
    @FindBy(xpath = CERTIFICATE_CONDITION_TEXT)
    WebElement elCertificateConditionText;

    @Step("I check text block in conditions contains {content}")
    public CertificatePage checkConditionText(String content) {
        compareTextInWebElement(driver, elCertificateConditionText, content);
        return this;
    }

    @Step("I check the image on page")
    public CertificatePage checkImage() {
        try {
            elCertificateImage.stream().filter(WebElement::isDisplayed).findFirst();
            return this;
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
            return null;
        }
    }

    @Step("I check certificates nominal")
    public CertificatePage checkCertificatesNominal(List<String> nominals) {
        for (String cost : nominals)
            waitElementVisible(driver, driver.findElement(By.xpath("//span[contains(.,\"" + cost + "\")]")));
        return this;
    }

    @Step("I check the buy button")
    public CertificatePage checkBuyButtons(List<String> nominals) {
        assert elBuyButtons.size() == nominals.size();
        return this;
    }

    @Step("I click condition button")
    public CertificatePage clickConditionButton() {
        elCertificateConditionTitle.click();
        return this;
    }

    @Step("I click on buy button")
    public CertificatePage clickBuyButton() {
        waitElementClickable(driver, elBuyButtons.get(0)).click();
        return this;
    }

}
