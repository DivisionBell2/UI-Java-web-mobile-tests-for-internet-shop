package Order;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MainPage;
import pages.NPCPage;
import pages.SearchPage;
import testData.Categories;
import testData.Cities;
import testData.User;

public class test007CheckoutDelivery extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private NPCPage npcPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        npcPage = new NPCPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void test007CheckoutDelivery() {

        mainPage
                .selectMainMenuCategory(Categories.BAGS.getValue())
        ;

        searchPage
                .selectFirstProduct()
        ;

        npcPage
                .selectSize()
                .clickAddToCartBtn()
                .waitScrollComplete(driver)
                .checkCartPopupMessage("Добавлено в корзину")
                .clickCheckOrderButton()
        ;

        checkoutPage
                .checkCartPage()
                .clickClosePopupBtn()
                .enterTextInInput("name", "name", User.FULLNAME.getValue())
                .enterTextInInput("name", "phone", generatePhone())
                .enterTextInInput("name", "email", generateMail())
                .enterCityName(Cities.SAINT_PETERSBURG.getValue())
                .waitingDeliveryRadioButton()
                .enterSteetName("ул Пушкинская")
                .enterHouseNumber("д 10")
                .enterTextInInput("placeholder", "Квартира", "999")
                .clickCheckOrderBtn()
                .checkOrderNumber()
        ;
    }

    @AfterMethod
    void teraDown() {
        driver.quit();
    }
}

