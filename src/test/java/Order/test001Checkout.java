package Order;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import testData.Categories;
import testData.Cities;
import testData.User;

public class test001Checkout extends MainClass {
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
    void test001Checkout() {
        mainPage
                .selectMainMenuCategory(Categories.SHOES.getValue())
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
                .enterCityName(Cities.MOSCOW.getValue())
                .clickPickupButton()
                .clickCheckOrderBtn()
                .checkOrderNumber()
        ;
    }

    @AfterMethod
    void teraDown() {
        driver.quit();
    }
}

