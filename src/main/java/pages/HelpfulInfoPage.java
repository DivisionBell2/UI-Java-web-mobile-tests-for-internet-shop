package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HelpfulInfoPage extends AnyPage {
    private WebDriver driver;

    public HelpfulInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String SELECT_INFO = "//div[contains(@class, \"select-summary\") and contains(., \"Уход за одеждой\")]";
    private static final String INFO_LIST = "//a[@class=\"select-option\"]";
    private static final String SVG_ICONS = "//div[@id=\"top\"]/div[2]//span[contains(@class, \"svg\")]";
    private static final String CONTENT = "//div[@id=\"top\"]/div[2]//span[contains(@class, \"svg\")]/following-sibling::span";
    private static final String CONTENT_TITLES = "//div[@id=\"top\"]/div[2]//p";
    private static final String PARAGRAPHES = "//div[@id=\"top\"]//p";
    private static final String TITLE_SECTIONS = "//section";
    private static final String TEXT_SECTIONS = "//section//ul/li/span";
    private static final String WATCH_INSTRUCTIONS = "//a[contains(@href, \"instructions\")]";
    private static final String WATCH_WORKSHOP_PHONE = "//section//p[contains(.,\"телефон\")]/a[contains(@href, \"tel:+7\")]";
    private static final String WATCH_WORKSHOP_ADDRESS = "//section//p[contains(.,\"адрес:\")]";

    @FindBy(xpath = SELECT_INFO)
    WebElement elSelectInfo;
    @FindBy(xpath = CONTENT_TITLES)
    List<WebElement> elContentTitles;
    @FindBy(xpath = SVG_ICONS)
    List<WebElement> elSVGIcons;
    @FindBy(xpath = CONTENT)
    List<WebElement> elContent;
    @FindBy(xpath = INFO_LIST)
    List<WebElement> elInfoList;
    @FindBy(xpath = PARAGRAPHES)
    List<WebElement> elParagraphes;
    @FindBy(xpath = TITLE_SECTIONS)
    List<WebElement> elTItleSections;
    @FindBy(xpath = TEXT_SECTIONS)
    List<WebElement> elTextSections;
    @FindBy(xpath = WATCH_INSTRUCTIONS)
    List<WebElement> elWatchInstructions;
    @FindBy(xpath = WATCH_WORKSHOP_PHONE)
    List<WebElement> elWatchWorkshopPhone;
    @FindBy(xpath = WATCH_WORKSHOP_ADDRESS)
    List<WebElement> elWatchWorkshopAddress;

    @Step("I check select info on page")
    public HelpfulInfoPage checkSelectInfoList() {
        waitElementVisible(driver, elSelectInfo);
        return this;
    }

    @Step("I check {title} in visible content blocks")
    public HelpfulInfoPage checkContentBlocksTitle(String title) {
        isDisplayedWebElementsOfListContainText(elContentTitles, title);
        return this;
    }

    @Step("I check {text} in visible content blocks")
    public HelpfulInfoPage checkContentBlocksText(String text) {
        isDisplayedWebElementsOfListContainText(elContent, text);
        return this;
    }

    @Step("I check content svg")
    public HelpfulInfoPage checkcontentSVG() {
        for (WebElement svg : elSVGIcons)
            assert svg.isDisplayed();
        return this;
    }

    @Step("I click select info on page")
    public HelpfulInfoPage clickSelectInfo() {
        waitElementVisible(driver, elSelectInfo).click();
        return this;
    }

    @Step("I select {infoTheme}")
    public HelpfulInfoPage clickInfoTheme(String infoTheme) {
        waitElementVisible(driver, elInfoList.get(0));
        filterListByText(elInfoList, infoTheme).click();
        return this;
    }

    @Step("I check {parag} in paragraphes")
    public HelpfulInfoPage checkParagraphes(String parag) {
        isDisplayedWebElementsOfListContainText(elParagraphes, parag);
        return this;
    }

    @Step("I click {title} in sections")
    public HelpfulInfoPage checkSectionText(String title) {
            elTItleSections
                    .stream()
                    .filter(WebElement -> WebElement.isDisplayed())
                    .filter(WebElement -> WebElement.getText()
                            .toLowerCase()
                            .contains(title.toLowerCase()))
                    .findFirst()
                    .get()
                    .click();
        return this;
    }

    @Step("I check {text} in sections")
    public HelpfulInfoPage checkTextInSections(String text) {
        isDisplayedWebElementsOfListContainText(elTextSections, text);
        return this;
    }

    @Step("I check watchInstructions")
    public HelpfulInfoPage checkWatchInstructions() {
        for (WebElement instruction : elWatchInstructions)
            assert instruction.isDisplayed();
        return this;
    }

    @Step("I check watch workshops phone info")
    public HelpfulInfoPage checkWatchWorkshopPhones() {
        elWatchWorkshopPhone
                .stream()
                .filter(WebElement -> WebElement.isDisplayed())
                .forEach(WebElement -> {
                    assert !WebElement.getText().isEmpty();
                });
        return this;
    }

    @Step("I check watch workshops addresses")
    public HelpfulInfoPage checkWatchWorkshopAddresses() {
        elWatchWorkshopAddress
                .stream()
                .filter(WebElement -> WebElement.isDisplayed());
        return this;
    }

}
