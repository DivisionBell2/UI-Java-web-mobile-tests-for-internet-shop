package pages;

import helpers.MainClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AnyPage extends MainClass {
    private WebDriver driver;
    String windowHandler;

    public AnyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //OVERALL
    private static final String INPUTS = "//input";

    //MAIN MENU
    private static final String MAIN_MENU = "//span[@data-test=\"mobile-header-menu\"]/*[name()=\"svg\" and @stroke-linecap=\"round\"]/*[name()='line'][2]";
    private static final String USER_LOGIN_MENU = "//span[@role=\"button\" and contains(., \"Войти\")]";
    private static final String USER_EXIT = "//div[contains(@class, \"mobile-menu-new\")]//span[contains(.,\"Выход\")]";
    private static final String CATALOG_MENU = "//div[@data-test=\"main-menu\"]";
    private static final String All_SUBCATEGORIES = "//a[@data-test=\"mobile-submenu\"]";
    private static final String USER_ICON = "//span[@data-bind=\"mobile-user-menu\"]";
    private static final String MAIN_PAGE_LINK = "//a[contains(.,\"Главная страница\")]";
    private static final String BRANDS = "//div[@data-test=\"main-menu\"]";
    private static final String ALL_BRANDS = "//a[contains(., \"Все бренды\")]";
    private static final String INSTASHOP = "//a[@data-test=\"main-menu\" and contains(., \"InstaShop\")]";
    private static final String AUTH_USER_MENU = "//a[@data-test=\"mobile-user-menu-button\"]";

    //SOCIAL NETWORKS
    private static final String SOCIAL_LOGIN_INPUT = "//input[@type=\"text\" or @type=\"email\"]";
    private static final String SOCIAL_PASSWORD_INPUT = "//input[@type=\"password\"]";
    private static final String SOCIAL_FB_ENTER_BTN = "//button[@name=\"login\"]";
    private static final String SOCIAL_INSTAGRAM_ENTER_BTN = "//button[@type=\"submit\"]";
    private static final String SOCIAL_APPLY_VK_BUTTON = "//button[@id=\"install_allow\"]";
    private static final String SOCIAL_CONFIRM_VK_BUTTON = "//button[@onclick=\"return allow(this);\"]";
    private static final String SOCIAL_VK_LOGIN_INPUT = "//input[@name=\"email\"]";
    private static final String SOCIAL_VI_PASSWORD_INPUT = "//input[@name=\"pass\"]";
    private static final String SOCIAL_OK_LOGIN_INPUT = "//input[@id=\"field_email\"]";
    private static final String SOCIAL_OK_PASSWORD_INPUT = "//input[@id=\"field_password\"]";
    private static final String SOCIAL_OK_ENTER_BTN = "//input[@type=\"submit\"]";
    private static final String SOCIAL_OK_APPLY_BTN = "//button[@name=\"button_accept_request\"]";
    private static final String SOCIAL_INSTAGRAM_MENUITEM_BTN = "//div[@role=\"menuitem\"]";
    private static final String SOCIAL_INSTAGRAM_ENTER_LIST_ELEMENT = "//a[@href=\"/accounts/login/?source=mobile_nav_menu\"]";
    private static final String SOCIAL_INSTAGRAM_FACEBOOK_BTN = "//button[contains(., \"Facebook\")]";
    private static final String SOCIAL_INSTAGRAM_CONFIRM_BTN = "//button[ @data-sigil=\"touchable\"][1]";

    //REGISTRATION AND AUTHORISATION
    private static final String REGISTRATION_BUTTON = "//span[contains(.,\"Регистрация\")]";
    private static final String VK_BTN = "//a[contains(@href, \"vkontakte\")]";
    private static final String OK_BTN = "//a[contains(@href,\"odnoklassniki\")]";
    private static final String FB_BTN = "//a[contains(@href,\"facebook\")]";
    private static final String INSTAGRAM_BTN = "//a[@href=\"/api/login/instagram\"]";
    private static final String REGISTRATION_CONFIRM_BUTTON = "//button[@class=\"bt-button-dark\"]";
    private static final String AUTH_BUTTON = "//button[contains(.,\"Войти\")]";
    private static final String WELCOME_MESSAGE = "//div[@class=\"text-center weight-bold text-uppercase\"]";
    private static final String CLOSE_POPUP_BUTTON = "//div[@class=\"flex-1 row-end-center not-sm-hide\"]/span[@role=\"button\"]";
    private static final String AUTH_POPUP_HEADER = "//div[@class=\"row-start-stretch sm-gaps-2-h sm-padding-2x5-l text-ellipsis edge-in-black-40-b\"]";
    private static final String GO_TO_RECOVERY_PASSWORD_BUTTON = "//form//span[@role=\"button\"]";
    private static final String RECOVERY_PASSWORD_POPUP_TITLE = "//h1";
    private static final String RECOVERY_PASSWORD_POPUP_TEXT = "//form//p";
    private static final String RECOVERY_PASSWORD_INPUT = "//form//input[@data-test=\"popup-email\"]";
    private static final String RECOVERY_PASSWORD_SEND_BUTTON = "//form//button[contains(.,\"Отправить\")]";

    // HEADER
    private static final String CART_ICON = "//a[@data-test=\"mobile-header-cart\"]";
    private static final String FAVORITE_BUTTON = "//a[@data-test=\"mobile-header-favorite\"]";
    private static final String ABOUT_STORE = "//div[@data-test=\"footer-menu\"]//a[@href=\"/about\"]";

    // FOOTER
    private static final String ABOUT_STORE_FOOTER_LINK = "//div[@data-test=\"footer-menu\"]/a[contains(., \"Универмаг\")]";
    private static final String SIZES_PAGE_FOOTER_LINK = "//div[@data-test=\"footer-menu\"][2]/a[contains(., \"Таблица размеров\")]";
    private static final String FOOTER_CERTIFICATES_LINK = "//a[@href=\"/page/certificates\"]";
    private static final String FOOTER_CLUB_SYSTEM_LINK = "//div[@data-test=\"footer-menu\"]/a[@href=\"/page/clubcard\"]";
    private static final String FOOTER_HELPFUL_INFO_LINK = "//div[@data-test=\"footer-menu\"]/a[@href=\"/page/helpful-info\"]";
    private static final String FOOTER_CONTACTS_LINK = "//a[text()=\"Контакты\"]";

    //OVERALL
    @FindBy(xpath = INPUTS)
    private List<WebElement> elInputs;

    //MAIN MENU
    @FindBy(xpath =  MAIN_MENU)
    private WebElement elMainMenuBtn;
    @FindBy(xpath = USER_LOGIN_MENU)
    private WebElement elLoginUserMenu;
    @FindBy(xpath = USER_EXIT)
    private WebElement elUserExit;
    @FindBy(xpath = CATALOG_MENU)
    private List<WebElement> elCatalogMenu;
    @FindBy(xpath = All_SUBCATEGORIES)
    private List<WebElement> elAllSubcategories;
    @FindBy (xpath = USER_ICON)
    private WebElement elUserIcon;
    @FindBy(xpath = MAIN_PAGE_LINK)
    private WebElement elMainPageLink;
    @FindBy(xpath = BRANDS)
    private WebElement elBrands;
    @FindBy(xpath = ALL_BRANDS)
    private WebElement elAllBrands;
    @FindBy(xpath = INSTASHOP)
    private WebElement elInstashop;
    @FindBy(xpath = AUTH_USER_MENU)
    private List<WebElement> elAuthUserMenu;

    //REGISTRATION AND AUTHORISATION
    @FindBy(xpath = VK_BTN)
    private WebElement elVkBtn;
    @FindBy(xpath = OK_BTN)
    private WebElement elOKBtn;
    @FindBy(xpath = FB_BTN)
    private WebElement elFBBtn;
    @FindBy(xpath = INSTAGRAM_BTN)
    private WebElement elInstagramBtn;
    @FindBy(xpath = REGISTRATION_BUTTON)
    private WebElement elRegistrationButton;
    @FindBy(xpath = REGISTRATION_CONFIRM_BUTTON)
    private WebElement elRegConfirmButton;
    @FindBy(xpath = AUTH_BUTTON)
    private WebElement elAuthBn;
    @FindBy(xpath = WELCOME_MESSAGE)
    private WebElement elWelcomeMess;
    @FindBy(xpath = CLOSE_POPUP_BUTTON)
    private WebElement elClosePopupBtn;
    @FindBy(xpath = AUTH_POPUP_HEADER)
    private WebElement elAuthPopupHeader;
    @FindBy(xpath = GO_TO_RECOVERY_PASSWORD_BUTTON)
    private WebElement elToRecoveryPasswordButton;
    @FindBy(xpath = RECOVERY_PASSWORD_POPUP_TITLE)
    private WebElement elRecoveryPasswordPopupTitle;
    @FindBy(xpath = RECOVERY_PASSWORD_POPUP_TEXT)
    private WebElement elRecoveryPasswordPopupText;
    @FindBy(xpath = RECOVERY_PASSWORD_INPUT)
    private WebElement elRecoveryPasswordInput;
    @FindBy(xpath = RECOVERY_PASSWORD_SEND_BUTTON)
    private WebElement elRecoveryPasswordSendButton;

    //SOCIAL NETWORKS
    @FindBy(xpath = SOCIAL_LOGIN_INPUT)
    private WebElement elSocialInput;
    @FindBy(xpath = SOCIAL_PASSWORD_INPUT)
    private WebElement elSocialPassword;
    @FindBy(xpath = SOCIAL_APPLY_VK_BUTTON)
    private WebElement elSocialApplyVKButton;
    @FindBy(xpath = SOCIAL_CONFIRM_VK_BUTTON)
    private WebElement elSocialConfirmVKButton;
    @FindBy(xpath = SOCIAL_FB_ENTER_BTN)
    private WebElement elSocialFBEnterBtn;
    @FindBy(xpath = SOCIAL_INSTAGRAM_ENTER_BTN)
    private WebElement elSocialInstagramEnterBtn;
    @FindBy(xpath = SOCIAL_VK_LOGIN_INPUT)
    private WebElement elSocialVKLoginInput;
    @FindBy(xpath = SOCIAL_VI_PASSWORD_INPUT)
    private WebElement elSocialVkPasswordInput;
    @FindBy(xpath = SOCIAL_OK_LOGIN_INPUT)
    private WebElement elSocialOKLoginInput;
    @FindBy(xpath = SOCIAL_OK_PASSWORD_INPUT)
    private WebElement elSocialOKPasswordInput;
    @FindBy(xpath = SOCIAL_OK_ENTER_BTN)
    private WebElement elSocialOKEnterButton;
    @FindBy(xpath = SOCIAL_OK_APPLY_BTN)
    private WebElement elSocialOKApplyButton;
    @FindBy(xpath = SOCIAL_INSTAGRAM_MENUITEM_BTN)
    private WebElement elSocialInstagramMenuitemButton;
    @FindBy(xpath = SOCIAL_INSTAGRAM_ENTER_LIST_ELEMENT)
    private WebElement elSocialInstEnterListElem;
    @FindBy(xpath = SOCIAL_INSTAGRAM_FACEBOOK_BTN)
    private WebElement elSocialInstFBBTN;
    @FindBy(xpath = SOCIAL_INSTAGRAM_CONFIRM_BTN)
    private WebElement elSocialInstConfirmBtn;

    // HEADER
    @FindBy(xpath = CART_ICON)
    private WebElement elCartIcon;
    @FindBy(xpath = FAVORITE_BUTTON)
    private WebElement elFavoriteButton;
    @FindBy(xpath = ABOUT_STORE)
    private WebElement elAboutStore;

    //FOOTER
    @FindBy(xpath = ABOUT_STORE_FOOTER_LINK)
    private WebElement elAboutStoreFooterLink;
    @FindBy(xpath = SIZES_PAGE_FOOTER_LINK)
    private WebElement elSizesPageFooterLink;
    @FindBy(xpath = FOOTER_CERTIFICATES_LINK)
    WebElement elCertificatesLink;
    @FindBy(xpath = FOOTER_CLUB_SYSTEM_LINK)
    private WebElement elFooterClubSystemLink;
    @FindBy(xpath = FOOTER_HELPFUL_INFO_LINK)
    private WebElement elHelpfulInfoLink;
    @FindBy(xpath = FOOTER_CONTACTS_LINK)
    private WebElement elFooterContactsLink;

    //OVERALL METHODS

    public AnyPage filInput(String attribute, String attrValue, String text) {
        filterListByAttribute(elInputs, attribute, attrValue).clear();
        filterListByAttribute(elInputs, attribute, attrValue).sendKeys(text);
        return this;
    }

    public AnyPage refreshPage() {
        driver.navigate().refresh();
        return this;
    }

    public AnyPage clickAuthUserMenuElementWithText(String elementMenuText) {
        filterListByText(elAuthUserMenu, elementMenuText).click();
        return this;
    }

    public AnyPage checkTextInInput(String attribute, String attrValue, String text) {
        assert filterListByAttribute(elInputs, attribute, attrValue).getAttribute("value").equals(text);
        return this;
    }

    //MAIN MENU METHODS

    public AnyPage clickMainMenu() {
        waitForLoad(driver);
        Actions action = new Actions(driver);
        action.click(elMainMenuBtn).build().perform();
        return this;
    }

    public AnyPage clickUserEnterButton() {
        waitForLoad(driver);
        waitElementVisible(driver, elLoginUserMenu);
        waitForLoad(driver);
        waitElementClickable(driver, elLoginUserMenu).click();
        return this;
    }

    public AnyPage checkUserMenuContainsListElement() {
        waitElementVisible(driver, elCatalogMenu.get(elCatalogMenu.size() - 1));
        waitElementVisible(driver, elUserExit);
        return this;
    }

    public AnyPage clickMenuCategoryByName(String name) {
        waitForLoad(driver);
        waitElementVisible(driver, elCatalogMenu.get(elCatalogMenu.size() - 1));
        waitElementClickable(driver, filterListByText(elCatalogMenu, name)).click();
        return this;
    }

    public AnyPage clickMenuSubcategory(String name) {
        waitForLoad(driver);
        waitElementVisible(driver, elAllSubcategories.get(elAllSubcategories.size() - 1));
        waitElementClickable(driver, filterListByTextStrong(elAllSubcategories, name)).click();
        return this;
    }

    public AnyPage checkUserEnterButton() {
        waitElementVisible(driver, elLoginUserMenu);
        return this;
    }

    public AnyPage checkMainPageLink() {
        waitElementVisible(driver, elAboutStoreFooterLink);
        return this;
    }

    public AnyPage clickSubcategory() {
        waitForLoad(driver);
        waitElementVisible(driver, elAllSubcategories.get(elAllSubcategories.size() - 1));
        elAllSubcategories.get(0).click();
        return this;
    }

    public AnyPage clickUserExitButton() {
        waitElementClickable(driver, elUserExit).click();
        return this;
    }

    public AnyPage clickInstashopButton() {
        waitElementClickable(driver, elInstashop).click();
        return this;
    }

    //REGISTRATION AND AUTHORISATION FORM METHODS

    public AnyPage clickRegBtn() {
        elRegistrationButton.click();
        return this;
    }

    public AnyPage clickVkBtn() {
        elVkBtn.click();
        return this;
    }

    public AnyPage clickOKBtn() {
        elOKBtn.click();
        return this;
    }

    public AnyPage clickFBBtn() {
        elFBBtn.click();
        return this;
    }

    public AnyPage clickInstagramBtn() {
        elInstagramBtn.click();
        return this;
    }

    public AnyPage clickRegConfirmBtn() {
        elRegConfirmButton.click();
        return this;
    }

    public AnyPage clickAuthBtn() {
        elAuthBn.click();
        return this;
    }

    public AnyPage checkWelcomeMessage(String text) {
        assert waitElementVisible(driver, elWelcomeMess)
                .getText()
                .toLowerCase()
                .contains(text.toLowerCase());
        return this;
    }

    public AnyPage checkAuthPopupClosed() {
        waitForLoad(driver);
        assert waitElementInvisible(driver, AUTH_POPUP_HEADER);
        driver.manage().addCookie(new Cookie("new-header", "true")); //temporary, while new-header cookie is exist
        driver.navigate().refresh(); //temporary, while new-header cookie is exist
        return this;
    }

    public AnyPage clickCloseRegPopupButton() {
        elClosePopupBtn.click();
        return this;
    }

    public AnyPage checkEmptyInputIsRed(String attribute, String attrValue, String rgb) {
        WebElement input = filterListByAttribute(elInputs, attribute, attrValue);
        System.out.println(input.getAttribute("value"));
        assert new WebDriverWait(driver, 3)
                .until(WebDriver -> input.getCssValue("box-shadow")
                        .equals(rgb));
        return this;
    }

    public AnyPage clickRecoveryPasswordButton() {
        waitElementClickable(driver, elToRecoveryPasswordButton).click();
        return this;
    }

    public AnyPage checkRecoveryPasswordTitle(String content) {
        compareTextInWebElement(driver, elRecoveryPasswordPopupTitle, content);
        return this;
    }

    public AnyPage checkRecoveryPasswordPopupText(String content) {
        compareTextInWebElement(driver, elRecoveryPasswordPopupText, content);
        return this;
    }

    public AnyPage checkRecoveryPasswordPopupInput() {
        waitElementVisible(driver, elRecoveryPasswordInput);
        return this;
    }

    public AnyPage checkRecoveryPasswordPopupButton() {
        waitElementVisible(driver, elRecoveryPasswordSendButton);
        return this;
    }

    //SOCIAL NETWORKS METHODS

    public AnyPage fillVKData(String user, String password) {
        waitElementClickable(driver, elSocialVKLoginInput).sendKeys(user);
        waitElementClickable(driver, elSocialVkPasswordInput).sendKeys(password);
        waitElementClickable(driver, elSocialApplyVKButton).click();
        return this;
    }

    public AnyPage fillFBData(String user, String password) {
        waitElementClickable(driver, elSocialInput).sendKeys(user);
        waitElementClickable(driver, elSocialPassword).sendKeys(password);
        waitElementClickable(driver, elSocialFBEnterBtn).click();
        return this;
    }

    public AnyPage fillInstagramData(String user, String password) {
        waitElementClickable(driver, elSocialInput).sendKeys(user);
        waitElementClickable(driver, elSocialPassword).sendKeys(password);
        waitElementClickable(driver, elSocialInstagramEnterBtn).click();
        return this;
    }

    public AnyPage fillOKData(String user, String password) {
        waitElementClickable(driver, elSocialOKLoginInput).sendKeys(user);
        waitElementClickable(driver, elSocialOKPasswordInput).sendKeys(password);
        waitElementClickable(driver, elSocialOKEnterButton).click();
        return this;
    }

    public AnyPage clickConfirmVKButton() {
        try {
            elSocialConfirmVKButton.isEnabled();
            elSocialConfirmVKButton.click();
        } catch (Exception e) {
            return null;
        }
        return this;

    }

    public AnyPage clickApplyOKButton() {
        try {
            elSocialOKApplyButton.isEnabled();
            elSocialOKApplyButton.click();
        } catch (Exception e) {
            return null;
        }
        return this;
    }

    //SWITCHED WINDOWS METHODS

    public AnyPage switchToNewWindow() {
        windowHandler = driver.getWindowHandle();
        for (String windows : driver.getWindowHandles()) {
            sleep(1000);
            driver.switchTo().window(windows);
        }
        return this;
    }

    public AnyPage switchToOldWindow() {
        driver.switchTo().window(windowHandler);
        return this;
    }

    //HEADER METHODS

    public AnyPage clickCartIcon() {
        elCartIcon.click();
        return this;
    }

    public AnyPage clickFavoriteButton() {
        elFavoriteButton.click();
        return this;
    }

    //FOOTER METHODS

    public AnyPage clickAboutStore() {
        waitForLoad(driver);
        checkMainPageLink();
        waitElementClickable(driver, elAboutStore).click();
        return this;
    }

    public AnyPage clickSizesPage() {
        waitForLoad(driver);
        checkMainPageLink();
        waitElementVisible(driver, elSizesPageFooterLink);
        waitElementClickable(driver, elSizesPageFooterLink).click();
        return this;
    }

    public AnyPage clickFooterSertificates() {
        waitForLoad(driver);
        waitElementVisible(driver, elCertificatesLink);
        waitElementClickable(driver, elCertificatesLink).click();
        return this;
    }

    public AnyPage clickFooterClubcardPage() {
        waitForLoad(driver);
        waitElementVisible(driver, elFooterClubSystemLink).click();
        return this;
    }

    public AnyPage clickHelpfulInfoPage() {
        waitForLoad(driver);
        waitElementVisible(driver, elHelpfulInfoLink).click();
        return this;
    }

    public AnyPage clickContactsPage() {
        waitForLoad(driver);
        waitElementVisible(driver, elFooterContactsLink).click();
        return this;
    }
}

