package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AnyPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //OVERALL

    @Step("I enter {text} in input {attrValue}")
    public MainPage enterTextInInput(String attribute, String attrValue, String text) {
        filInput(attribute, attrValue, text);
        return this;
    }

    //MAIN MENU METHODS

    @Step("I check the user is logined")
    public MainPage checkUserLogined() {
        clickMainMenu();
        checkUserMenuContainsListElement();
        return this;
    }

    @Step("I open main menu and click on user icon")
    public MainPage openAuthPopup() {
        clickMainMenu();
        clickUserEnterButton();
        return this;
    }

    @Step("I select {subcategory} of {categoryName} in main menu")
    public MainPage selectMainMenuCategory(String categoryName, String subcategoryName) {
        clickMainMenu();
        clickMenuCategoryByName(categoryName);
        sleep(1000);
        clickMenuCategoryByName(subcategoryName);
        clickSubcategory();
        return this;
    }

    @Step("I select subcategory of {categoryName} in main menu")
    public MainPage selectMainMenuCategory(String categoryName) {
        clickMainMenu();
        clickMenuCategoryByName(categoryName);
        sleep(500);
        clickMenuCategoryByName(categoryName);
        clickSubcategory();
        return this;
    }

    @Step("I open main menu and choose {categoryName}, {subcategoryName}, {subcategorySubmenu}")
    public MainPage selectMainMenuCategory(String categoryName, String subcategoryName, String subcategorySubmenu) {
        clickMainMenu();
        clickMenuCategoryByName(categoryName);
        clickMenuCategoryByName(subcategoryName);
        clickMenuSubcategory(subcategorySubmenu);
        return this;
    }

    @Step("I click and check user's logout")
    public MainPage logoutUser() {
        clickUserExitButton();
        checkUserEnterButton();
        return this;
    }

    @Step("I open main menu and choose Instashop page")
    public MainPage selectMainMenuInstashop() {
        clickMainMenu();
        checkMainPageLink();
        clickInstashopButton();
        return this;
    }

    @Step("I click on {name} button in main menu")
    public MainPage clickAuthUserMenuElement(String name) {
        clickAuthUserMenuElementWithText(name);
        return this;
    }

    // REGISTRATION AND AUTHORISATION METHODS

    @Step("I click authorisation button")
    public MainPage clickAuthButton() {
        clickAuthBtn();
        checkAuthPopupClosed();
        return this;
    }

    @Step("I click authorisation button (negative check)")
    public MainPage clickAuthButtonNegative() {
        clickAuthBtn();
        return this;
    }

    @Step("I check that authorisation popup closed")
    public MainPage clickRegistrationPopupClosed() {
        clickCloseRegPopupButton();
        return this;
    }

    @Step("I click registration button")
    public MainPage clickRegistrationBtn() {
        clickRegBtn();
        return this;
    }

    @Step("I click registration complete button")
    public MainPage clickRegCompleteBtn() {
        clickRegConfirmBtn();
        return this;
    }

    @Step("I check the welcome message after successful registration")
    public MainPage checkWelcomeMsg(String message) {
        checkWelcomeMessage(message);
        return this;
    }

    @Step("I log in through VKontakte")
    public MainPage enterVKData(String user, String password) {
        clickVkBtn();
        switchToNewWindow();
        fillVKData(user, password);
        clickConfirmVKButton();
        switchToOldWindow();
        checkAuthPopupClosed();
        return this;
    }

    @Step("I log in through Odnoklassniki")
    public MainPage enterOKData(String user, String password) {
        clickOKBtn();
        switchToNewWindow();
        fillOKData(user, password);
        clickApplyOKButton();
        switchToOldWindow();
        checkAuthPopupClosed();
        return this;
    }

    @Step("I log in through Facebook")
    public MainPage enterFBData(String user, String password) {
        clickFBBtn();
        switchToNewWindow();
        waitForLoad(driver);
        fillFBData(user, password);
        switchToOldWindow();
        checkAuthPopupClosed();
        return this;
    }

    @Step("I log in through Instagram")
    public MainPage enterInstagramData(String user, String password) {
        clickInstagramBtn();
        switchToNewWindow();
        fillInstagramData(user, password);
        return this;
    }

    @Step("I check the empty required to fill field {attrValue} has red border")
    public MainPage checkInputHasRedBorder(String name, String attrValue, String rgb) {
        checkEmptyInputIsRed(name, attrValue, rgb);
        return this;
    }

    @Step("I click on 'forget password?' button")
    public MainPage clickForgetPasswordButton() {
        clickRecoveryPasswordButton();
        return this;
    }

    @Step("I check elements on recovery password popup")
    public MainPage checkElementsRecoveryPasswordPopup(String titleText, String infoText) {
        checkRecoveryPasswordTitle(titleText);
        checkRecoveryPasswordPopupText(infoText);
        checkRecoveryPasswordPopupInput();
        checkRecoveryPasswordPopupButton();
        return this;
    }

    //FOOTER METHODS

    @Step("I click on 'about' button")
    public MainPage clickAboutButton() {
        clickAboutStore();
        return this;
    }

    @Step("I click on 'sizes tables' button")
    public MainPage clickSizesTablesButton() {
        clickSizesPage();
        return this;
    }

    @Step("I click certificates link in footer")
    public MainPage clickCertificatesPage() {
        waitForLoad(driver);
        clickFooterSertificates();
        return this;
    }

    @Step("I click clubcard link in footer")
    public MainPage clickClubcardPage() {
        waitForLoad(driver);
        clickFooterClubcardPage();
        return this;
    }

    @Step("I click helpful-info link in footer")
    public MainPage clickHelpfulPage() {
        waitForLoad(driver);
        clickHelpfulInfoPage();
        return this;
    }

    @Step("I click contacts link in footer")
    public MainPage clickContactsPage() {
        super.clickContactsPage();
        return this;
    }
}
