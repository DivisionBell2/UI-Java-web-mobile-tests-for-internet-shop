package pages;

import helpers.ProductCard;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutPage extends AnyPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //OVERALL
    private static final String GO_TO_CHECK_BUTTON = "//a[@class=\"cln-xs_12 w-sm-15 fr butn-black-s\"]";
    private static final String CHECK_ORDER_BUTTON = "//div[@data-bind=\"click: sendOrder\"]";
    private static final String ORDER_NUMBER = "//span[@data-bind=\"text: orderNumber\"]";
    private static final String YANDEX_MAP = "//div[@id=\"map\"]/ymaps";
    private static final String CLOSE_POPUP_BUTTON = "//button[@class=\"dib butn-transparent-s p-x-sm_2-5 w-100 user-control\"]";

    //CHECKOUT FORM
    private static final String TOWN_LIST = "//div[@data-test=\"suggesterSelector\"]";
    private static final String PICKUP = "//span[contains(.,\"Butik самовывоз\")]";
    private static final String POINT_OF_ISSUE_RADIO_BUTTON = "//label[@class=\"cln-xs_12 inp-r-label\"][3]";
    private static final String POINT_OF_ISSUE_BUTTON = "//button[contains(., \"Выбрать пункт выдачи\")]";
    private static final String DELIVERY_RADIO_BUTTON = "//label[@class=\"cln-xs_12 inp-r-label\"][1]";
    private static final String CITY_INPUT = "//input[@id=\"citySuggester\"]";
    private static final String STREET_INPUT = "//input[@id=\"streetSuggester\"]";
    private static final String HOUSE_INPUT = "//input[@id=\"houseSuggester\"]";

    //GOODS INFO
    private static final String SKU = "//p[@data-test=\"sku\"]";
    private static final String TOTAL_PRICE = "//div[@data-bind=\"text: preparePrice(totalCost())\"]";
    private static final String BRAND_NAMES = "//p[@data-test=\"mobile-item-info\"]/span[@data-test=\"brand\"]";
    private static final String PRODUCT_NAMES = "//div[@data-test=\"cart-item\"]//p[@data-bind=\"text: name\"]";

    //AEROFLOT ELEMENTS
    private static final String AEROFLOT_BUTTON = "//div[@class=\"js-dropdown coupon pr fr-xs cln-xs_3 w-xs-4 w-sm-15 m-l-sm_0 fs-xs_0-75\"]/span[@class=\"fr-xs dib link-dashed fs-xs_0-75\"]";
    private static final String AEROFLOT_APPLY_BUTTON = "//button[@class=\"aeroflot-btn cln-xs_5 butn-black-particular\" and @data-bind=\"click: sendAndValidate, disable: disabled\"]";
    private static final String AEROFLOT_ALERT = "//span[@data-bind=\"validationMessage: field\" and contains(text(),'Карта не найдена')]";
    private static final String AEROFLOT_BONUS_MILES = "//div[@data-bind=\"text: aeroflotCoupon.valid() ? totalMilesString() : '0 миль'\"]";
    private static final String AEROFLOT_POPUP = "//div[@class=\"corner pf-xs pa-sm bg-white cln-xs_12 p-x-xs_2 p-y-xs_1-5 shd br-lgr m-center minw-sm-24 maxw-md-24 r-xs-0 b-xs-0 b-sm-2 l-lg-0 zi-3\"]/form/button[@class=\"aeroflot-btn cln-xs_5 butn-black-particular\"]";

    //OVERALL
    @FindBy(xpath = CLOSE_POPUP_BUTTON)
    private WebElement elClosePopupBtn;
    @FindBy(xpath = GO_TO_CHECK_BUTTON)
    private WebElement elGoToCheckBtn;
    @FindBy(xpath = CHECK_ORDER_BUTTON)
    private WebElement elCheckOrderButton;
    @FindBy(xpath = ORDER_NUMBER)
    private WebElement elOrderNumber;
    @FindBy(xpath = YANDEX_MAP)
    private WebElement elYandexMap;
    @FindBy(xpath = DELIVERY_RADIO_BUTTON)
    private WebElement elDeliveryRadioButton;
    @FindBy(xpath = HOUSE_INPUT)
    private WebElement elHouseInput;

    //CHECKOUT FORM
    @FindBy(xpath = TOWN_LIST)
    private List<WebElement> elTownList;
    @FindBy(xpath = PICKUP)
    private WebElement elPickUp;
    @FindBy(xpath = POINT_OF_ISSUE_RADIO_BUTTON)
    private WebElement elPointOfIssueRadBtn;
    @FindBy(xpath = POINT_OF_ISSUE_BUTTON)
    private WebElement elPointOfIssueBtn;
    @FindBy(xpath = CITY_INPUT)
    private WebElement elCityInput;
    @FindBy(xpath = STREET_INPUT)
    private WebElement elStreetInput;


    //GOODS INFO
    @FindBy(xpath = SKU)
    private List<WebElement> elSku;
    @FindBy(xpath = TOTAL_PRICE)
    private WebElement elTotalPrice;
    @FindBy(xpath = BRAND_NAMES)
    private List <WebElement> elBrandNames;
    @FindBy(xpath = PRODUCT_NAMES)
    private List <WebElement> elProductNames;

    //AEROFLOT ELEMENTS
    @FindBy(xpath = AEROFLOT_BUTTON)
    private WebElement elAeroflotButton;
    @FindBy(xpath = AEROFLOT_APPLY_BUTTON)
    private WebElement elAeroflotApplyButton;
    @FindBy(xpath = AEROFLOT_ALERT)
    private WebElement elAeroflotAlert;
    @FindBy(xpath = AEROFLOT_BONUS_MILES)
    private WebElement elAeroflotBonusMiles;
    @FindBy(xpath = AEROFLOT_POPUP)
    private WebElement elAeroflotPopup;

    //OVERALL METHODS

    @Step("I close asking authorisation popup")
    public CheckoutPage clickClosePopupBtn() {
        waitElementClickable(driver, elClosePopupBtn).click();
        return this;
    }

    @Step("I check that I am on cart page")
    public CheckoutPage checkCartPage() {
        waitForLoad(driver);
        waitElementVisible(driver, elGoToCheckBtn);
        return this;
    }

    @Step("I click check-the-order button")
    public CheckoutPage clickCheckOrderBtn() {
        elCheckOrderButton.click();
        return this;
    }

    @Step("I check the successful order by order number")
    public CheckoutPage checkOrderNumber() {
        waitElementVisible(driver, elOrderNumber).click();
        return this;
    }

    @Step("I check the yandex map widget is existing")
    public CheckoutPage checkYandexMap() {
        waitElementVisible(driver, elYandexMap);
        return this;
    }

    //OVERALL METHODS

    private CheckoutPage fillAddressInputs(WebElement element, String adress) {
        sleep(500);
        waitElementVisible(driver, element).sendKeys(adress);
        sleep(500);
        waitElementVisible(driver, element).sendKeys(Keys.ENTER);
        return this;
    }

    //CHECKOUT FORM METHODS

    @Step("I fill city input to enter {city}")
    public CheckoutPage enterCityName(String city) {
        fillAddressInputs(elCityInput, city);
        sleep(3000);
        return this;
    }

    @Step("I fill street input to enter {street}")
    public CheckoutPage enterSteetName(String street) {
        fillAddressInputs(elStreetInput, street);
        return this;
    }

    @Step("I fill house input to enter {house}")
    public CheckoutPage enterHouseNumber(String house) {
        fillAddressInputs(elHouseInput, house);
        return this;
    }

    @Step("I click the pickup radiobutton")
        public CheckoutPage clickPickupButton() {
            waitElementClickable(driver, elPickUp).click();
            return this;
    }

    @Step("I enter {text} in input {attrValue} of checkout form")
    public CheckoutPage enterTextInInput(String attribute, String attrValue, String text) {
        filInput(attribute, attrValue, text);
        return this;
    }

    @Step("I click the point of issue radiobutton")
    public CheckoutPage clickPointOfIssueRadioButton() {
        waitElementClickable(driver, elPointOfIssueRadBtn).click();
        return this;
    }

    @Step("I click the point of issue button")
    public CheckoutPage clickPointOfIssueButton() {
        waitElementClickable(driver, elPointOfIssueBtn).click();
        return this;
    }

    @Step("I click the delivery radiobutton")
    public CheckoutPage waitingDeliveryRadioButton() {
        waitElementVisible(driver, elDeliveryRadioButton).isEnabled();
        return this;
    }

    //GOODS INFO METHODS

    @Step("I check total price")
    public CheckoutPage checkTotalPrice(ProductCard... cards) {
        int totalPrice = Arrays.stream(cards).mapToInt(val -> val.getPrice()).sum();
        assert totalPrice == getInt(elTotalPrice);
        return this;
    }

    @Step("I check total price by {value}")
    public CheckoutPage checkTotalPriceByValue(String value) {
        return this;
    }

    @Step("I compare goods articles from product cards with goods articles in cart")
    public CheckoutPage compareGoodsArticlesFromProductCardsInCart(ProductCard... cards) {
        List<String> skuCards = Stream
                .of(cards)
                .map(card -> card.getSku())
                .collect(Collectors.toList());

        List<String> skuCurrent = elSku
                .stream()
                .map(val -> val.getText())
                .collect(Collectors.toList());

        skuCards.retainAll(skuCurrent);
        assert skuCards.size() == 0;
        return this;
    }

    @Step("I compare product names from product cards with product names in cart")
    public CheckoutPage compareProductNamesFromProductCardsInCard(ProductCard... cards) {
        List<String> productNames = Stream
                .of(cards)
                .map(card -> card.getProductName())
                .collect(Collectors.toList());

        List<String> productNamesCurrent = elProductNames
                .stream()
                .map(val -> val.getText())
                .collect(Collectors.toList());

        productNames.removeAll(productNamesCurrent);
        assert productNames.size() == 0;
        return this;
    }

    @Step("I check product brands from product cards with product names in cart")
    public CheckoutPage compareProductBrandsFromProductCardsInCart(ProductCard... cards) {
        List<String> productBrands = Stream
                .of(cards)
                .map(card -> card.getBrand().toLowerCase())
                .collect(Collectors.toList());

        List<String> productBrandsCurrent = elBrandNames
                .stream()
                .map(val -> val.getText().toLowerCase())
                .collect(Collectors.toList());

        productBrands.removeAll(productBrandsCurrent);
        assert productBrands.size() == 0;
        return this;
    }

    //AEROFLOT METHODS

    @Step("I click on Aeroflot bonus button")
    public CheckoutPage clickAeroflotButton() {
        elAeroflotButton.click();
        return this;
    }

    @Step("I click on Aeroflot apply button")
    public CheckoutPage clickAeroflotApplyButton() {
        elAeroflotApplyButton.click();
        return this;
    }

    @Step("I check the Aeroflot alert message")
    public CheckoutPage checkAeroflotAlertMsg(String message) {
        isTextExist(driver, elAeroflotAlert, message);
        return this;
    }

    @Step("I check the Aeroflot bonus miles")
    public CheckoutPage checkAeroflotBonusMiles() {
        assert getInt(elAeroflotBonusMiles) > 0;
        return this;
    }

    @Step("I check that Aeroflot popup closed")
    public CheckoutPage checkAeroflotPopupClosed() {
        waitElementInvisible(driver, AEROFLOT_POPUP);
        return this;
    }
}
