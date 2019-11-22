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

public class test006CheckPointOfIssueOrdersWindow extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private NPCPage npcPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    private void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        npcPage = new NPCPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    private void test006CheckPointOfIssueOrdersWindow() {

        mainPage
                .selectMainMenuCategory(Categories.CLOTHES.getValue(), Categories.CATEGORIES.getValue())
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
                .enterCityName("Москва")
                .clickPointOfIssueRadioButton()
                .clickPointOfIssueButton()
                .checkYandexMap()
        ;
    }

    @AfterMethod
    private void tearUp() {
        driver.quit();
    }
}
