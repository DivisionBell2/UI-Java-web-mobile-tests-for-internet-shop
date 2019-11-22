package Order;

import com.alibaba.fastjson.JSONObject;
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

public class test002CheckoutAuthUser extends MainClass {
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
    void test002CheckoutAuthUser() {
        JSONObject user = generateUser();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkAuthPopupClosed()
        ;

        mainPage
                .selectMainMenuCategory(Categories.ACCESSORIES.getValue())
        ;

        searchPage
                .selectFirstProduct()
        ;

        npcPage
                .selectSize()
                .clickAddToCartBtn()
                .waitScrollComplete(driver)
                .checkCartPopupMessage("Добавлено в корзину")
                .closeCartPopup()
                .checkCartPopupClosed()
                .clickCartIconInHeader()
        ;

        checkoutPage
                .checkCartPage()
                .enterCityName(Cities.MOSCOW.getValue())
                .clickPickupButton()
                .clickCheckOrderBtn()
                .checkOrderNumber()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
