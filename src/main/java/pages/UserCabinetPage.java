package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCabinetPage extends AnyPage {
    private WebDriver driver;

    public UserCabinetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final String SEND_MESSAGE_BUTTON = "//button[contains(., \"ОТПРАВИТЬ СООБЩЕНИЕ\")]";
    private static final String TYPE_QUESTION_SELECT = "//select[@name=\"type\"]";
    private static final String TYPE_OF_QUESTIONS_LIST = "//option[not (@disabled)]";
    private static final String QUESTION_FIELD = "//textarea[@name=\"question\"]";
    private static final String SUCCESS_MESSAGE = "//div[text()=\"Сообщение отправлено!\"]";
    private static final String SAVE_BUTTON = "//button[contains(., \"СОХРАНИТЬ\")]";
    private static final String SUCCESS_CHANGES_MESSAGE = "//div[@class=\"profile__form-messages\"]/div[contains(., \"Изменения были успешно сохранены!\")]";

    //ORDERS PAGE
    private static final String ORDER_BLOCK = "//div[contains(@class, \"profile-orders-list__row\")][1]";
    private static final String ORDER_NUMBER_LABEL = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][1]/div[contains(@class, \"profile-orders-list__label\")]";
    private static final String ORDER_DATE_LABEL = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][2]/div[contains(@class, \"profile-orders-list__label\")]";
    private static final String ORDER_USER_LABEL = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][3]/div[contains(@class, \"profile-orders-list__label\")]";
    private static final String ORDER_PRICE_LABEL = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][4]/div[contains(@class, \"profile-orders-list__label\")]";
    private static final String ORDER_STATUS_LABEL = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][5]/div[contains(@class, \"profile-orders-list__label\")]";
    private static final String ORDER_NUMBER_VALUE = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][1]/div[contains(@class, \"profile-orders-list__value\")]";
    private static final String ORDER_DATE_VALUE = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][2]/div[contains(@class, \"profile-orders-list__value\")]";
    private static final String ORDER_USER_VALUE = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][3]/div[contains(@class, \"profile-orders-list__value\")]";
    private static final String ORDER_PRICE_VALUE = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][4]/div[contains(@class, \"profile-orders-list__value\")]";
    private static final String ORDER_STATUS_VALUE = "//div[contains(@class, \"profile-orders-list__row\")][1]/div[contains(@class, \"profile-orders-list__item\")][5]/div[contains(@class, \"profile-orders-list__value\")]";
    private static final String ORDER_NUMBER = "//div[contains(@class, \"rofile__heading\")]";
    private static final String ORDER_DATE = "//div[contains(@class, \"profile-order__info\")]/div[1]/div[contains(@class, \"profile-order__d\")]";
    private static final String ORDER_PRICE = "//div[contains(@class, \"profile-order__info\")]/div[9]/div[contains(@class, \"profile-order__d\")]";
    private static final String ORDER_PRICE_SUM_BLOCK = "//div[contains(@class, \"profile-order__result\")]/div[4]/div[contains(@class, \"profile-order__d\")]";
    private static final String ORDERED_PRODUCT = "//div[contains(@class, \"profile\")]/div/div[contains(@class, \"profile-product\")][1]/a[contains(@href, \"butik.ru\")][1]";
    private static final String ORDER_PRICE_FOOTER = "//div[contains(@class, \"profile-result-footer\")]/div[@class=\"profile-order__d col-xs-5 col-sm-4 i i-rub i-big\"]";

    //CLUBCARD PAGE
    private static final String CLUBCARD_PAGE_TITLE = "//div[contains(@class, \"profile__heading\")]";
    private static final String CLUBCARD_USER_DISCOUNT_INFO_TEXT = "//div[contains(@class, \"profile-loyalty__text-wrapper\")]";
    private static final String CLUBCARD_USER_DISCOUNT_INFO = "//div[contains(@class, \"profile-loyalty__purchase-value\")]";
    private static final String CLUBCARD_DISCOUNT_COST = "//tr[@class=\"profile-loyalty__purchase-table-row\"]";
    private static final String CLUBCARD_DISCOUNT_CONDITIONS = "//li[@class=\"profile-loyalty__list-item\"]";

    @FindBy(xpath = SEND_MESSAGE_BUTTON)
    WebElement elSendMessageButton;
    @FindBy(xpath = TYPE_QUESTION_SELECT)
    WebElement elTypeQuestionSelect;
    @FindBy(xpath = TYPE_OF_QUESTIONS_LIST)
    List<WebElement> elTypeOfQuestionsList;
    @FindBy(xpath = QUESTION_FIELD)
    WebElement elQuestionField;
    @FindBy(xpath = SUCCESS_MESSAGE)
    WebElement elSuccessMessage;
    @FindBy(xpath = SAVE_BUTTON)
    WebElement elSaveButton;
    @FindBy(xpath = SUCCESS_CHANGES_MESSAGE)
    WebElement elSuccessChangesMessage;

    //ORDERS PAGE
    @FindBy(xpath = ORDER_BLOCK)
    WebElement elOrderBlock;
    @FindBy(xpath = ORDER_NUMBER_LABEL)
    WebElement elOrderNumberLabel;
    @FindBy(xpath = ORDER_DATE_LABEL)
    WebElement elOrderDateLabel;
    @FindBy(xpath = ORDER_USER_LABEL)
    WebElement elOrderUserLabel;
    @FindBy(xpath = ORDER_PRICE_LABEL)
    WebElement elOrderPriceLabel;
    @FindBy(xpath = ORDER_STATUS_LABEL)
    WebElement elOrderStatusLabel;
    @FindBy(xpath = ORDER_NUMBER_VALUE)
    WebElement elOrderNumberValue;
    @FindBy(xpath = ORDER_DATE_VALUE)
    WebElement elOrderDateValue;
    @FindBy(xpath = ORDER_USER_VALUE)
    WebElement elOrderUserValue;
    @FindBy(xpath = ORDER_PRICE_VALUE)
    WebElement elOrderPriceValue;
    @FindBy(xpath = ORDER_STATUS_VALUE)
    WebElement elOrderStatusValue;
    @FindBy(xpath = ORDER_NUMBER)
    WebElement elOrderNumber;
    @FindBy(xpath = ORDER_DATE)
    WebElement elOrderDate;
    @FindBy(xpath = ORDER_PRICE)
    WebElement elOrderPrice;
    @FindBy(xpath = ORDER_PRICE_SUM_BLOCK)
    WebElement elOrderPriceSumBlock;
    @FindBy(xpath = ORDERED_PRODUCT)
    WebElement elOrderedProduct;
    @FindBy(xpath = ORDER_PRICE_FOOTER)
    WebElement elOrderPriceFooter;

    //CLUBCARD PAGE
    @FindBy(xpath = CLUBCARD_PAGE_TITLE)
    WebElement elClubcardPageTitle;
    @FindBy(xpath = CLUBCARD_USER_DISCOUNT_INFO_TEXT)
    WebElement elClubcardUserDisocuntInfoText;
    @FindBy(xpath = CLUBCARD_USER_DISCOUNT_INFO)
    List<WebElement> elClubcardUserDiscountInfo;
    @FindBy(xpath = CLUBCARD_DISCOUNT_COST)
    List<WebElement> elClubcardDiscountCost;
    @FindBy(xpath = CLUBCARD_DISCOUNT_CONDITIONS)
    List<WebElement> elClubcardDiscountConditions;

    @Step("I enter {city} in input")
    public UserCabinetPage enterCity(String attribute, String attrValue, String city) {
        filInput(attribute, attrValue, city);
        return this;
    }

    @Step("I check the send message button")
    public UserCabinetPage checkSendMessageButton() {
        waitElementVisible(driver, elSendMessageButton);
        return this;
    }

    @Step("I click the type of question select")
    public UserCabinetPage clickQuestionSelect() {
        waitElementClickable(driver, elTypeQuestionSelect).click();
        return this;
    }

    @Step("I select type of question")
    public UserCabinetPage selectTypeOfQuestion() {
        waitElementClickable(driver, elTypeOfQuestionsList.get(elTypeOfQuestionsList.size() - 1));
        elTypeOfQuestionsList.get(1).click();
        return this;
    }

    @Step("I enter text in question field")
    public UserCabinetPage enterQuestionText(String questionText) {
        waitElementVisible(driver, elQuestionField).sendKeys(questionText);
        return this;
    }

    @Step("I click on send message button")
    public UserCabinetPage clickSendMessageButton() {
        waitElementClickable(driver, elSendMessageButton).click();
        return this;
    }

    @Step("I check send question message")
    public UserCabinetPage checkSendQuestionMessage() {
        waitElementVisible(driver, elSuccessMessage);
        return this;
    }

    @Step("I enter {text} in input {attrValue}")
    public UserCabinetPage enterTextInInput(String attribute, String attrValue, String text) {
        filInput(attribute, attrValue, text);
        return this;
    }

    @Step("I click on save button")
    public UserCabinetPage clickSaveButton() {
        waitElementClickable(driver, elSaveButton).click();
        return this;
    }

    @Step("I check the success changing message")
    public UserCabinetPage checkSuccessChangingMessage() {
        waitElementVisible(driver, elSuccessChangesMessage);
        return this;
    }

    @Step("I reload page and check the text in the input")
    public UserCabinetPage checkTextInForm(String attribute, String attrValue, String text) {
        refreshPage();
        waitElementVisible(driver, elSaveButton);
        checkTextInInput(attribute, attrValue, text);
        return this;
    }

    @Step("I check content in order block")
    public UserCabinetPage checkOrderBlock() {
        waitElementVisible(driver, elOrderBlock);
        assert elOrderNumberLabel.getText().contains("№");
        assert elOrderDateLabel.getText().contains("Дата");
        assert elOrderUserLabel.getText().contains("Получатель");
        assert elOrderPriceLabel.getText().contains("Сумма заказа");
        assert elOrderStatusLabel.getText().contains("Статус");
        assert !elOrderNumberValue.getText().isEmpty();
        assert !elOrderDateValue.getText().isEmpty();
        assert !elOrderUserValue.getText().isEmpty();
        assert !elOrderPriceValue.getText().isEmpty();
        assert !elOrderStatusValue.getText().isEmpty();
        return this;
    }

    @Step("I get number, date and price order from order page")
    public Map<String, String> getValuesFromOrder() {
        Map<String, String> values = new HashMap();
        values.put("order number", elOrderNumberValue.getText());
        values.put("order date", elOrderDateValue.getText());
        values.put("order price", elOrderPriceValue.getText());
        return values;
    }

    @Step("I click to go to order button")
    public UserCabinetPage clickOrderButton() {
        elOrderBlock.click();
        return this;
    }

    @Step("I check order info")
    public UserCabinetPage checkOrderInfo(Map<String, String> values) {
        int price = Integer.parseInt(values.get("order price").replaceAll("[\\D]", ""));

        waitElementVisible(driver, elOrderNumber);
        waitElementVisible(driver, elOrderedProduct);
        compareTextInWebElement(driver, elOrderNumber, values.get("order number"));
        compareTextInWebElement(driver, elOrderDate, values.get("order date"));
        assert getInt(elOrderPrice) == price;
        assert getInt(elOrderPriceSumBlock) == price;
        assert getInt(elOrderPriceFooter) == price;

        return this;
    }

    @Step("I check clubcard page info")
    public UserCabinetPage checkClubcardTitle() {
        waitElementVisible(driver, elClubcardPageTitle);
        return this;
    }

    @Step("I check clubcard page info")
    public UserCabinetPage checkClubcardPageUserInfo(List<String> infoText) {
        for (String info : infoText)
            compareTextInWebElement(driver, elClubcardUserDisocuntInfoText, info);

        for (WebElement stroke : elClubcardUserDiscountInfo)
            stroke.isDisplayed();

        return this;
    }

    @Step("I check the discount cost info")
    public UserCabinetPage checkDiscountCostInfo(List<String> discountCost, List<String> discountPercent) {
        for (String cost : discountCost)
            filterListByText(elClubcardDiscountCost, cost);

        for (String percent : discountPercent)
            filterListByText(elClubcardDiscountCost, percent);

        return this;
    }

    @Step("I check discount conditions info")
    public UserCabinetPage checkDiscountConditionsInfo(List<String> conditionsText) {
        for (String condition : conditionsText)
            filterListByText(elClubcardDiscountConditions, condition);

        return this;
    }
}
