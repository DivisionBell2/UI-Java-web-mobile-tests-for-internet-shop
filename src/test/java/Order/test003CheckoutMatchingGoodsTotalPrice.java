package Order;

import helpers.MainClass;
import helpers.ProductCard;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import testData.Categories;
import testData.Cities;
import testData.User;

public class test003CheckoutMatchingGoodsTotalPrice extends MainClass {
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
    void test003CheckoutMatchingGoodsTotalPrice() {
        ProductCard productCardOne = new ProductCard();
        ProductCard productCardTwo = new ProductCard();

        mainPage
                .selectMainMenuCategory(Categories.CLOTHES.getValue(), Categories.CATEGORIES.getValue())
        ;

        searchPage
                .selectFirstProduct()
        ;

        npcPage
                .selectSize()
                .rememberInfo(productCardOne)
                .clickAddToCartBtn()
                .waitScrollComplete(driver)
                .checkCartPopupMessage("Добавлено в корзину")
                .closeCartPopup()
                .checkCartPopupClosed()
        ;

        mainPage
                .selectMainMenuCategory(Categories.BAGS.getValue())
        ;

        searchPage
                .selectFirstProduct()
        ;

        npcPage
                .selectSize()
                .rememberInfo(productCardTwo)
                .clickAddToCartBtn()
                .waitScrollComplete(driver)
                .checkCartPopupMessage("Добавлено в корзину")
                .closeCartPopup()
                .checkCartPopupClosed()
                .clickCartIconInHeader()
        ;

        checkoutPage
                .checkCartPage()
                .clickClosePopupBtn()
                .checkTotalPrice(productCardOne, productCardTwo)
                .compareGoodsArticlesFromProductCardsInCart(productCardOne, productCardTwo)
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
    void tearDown() {
        driver.quit();
    }
}
