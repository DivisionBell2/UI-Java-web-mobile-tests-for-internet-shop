package Instashop;

import helpers.MainClass;
import helpers.ProductCard;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.InstashopPage;
import pages.MainPage;

public class test001CheckInstashopPage extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private InstashopPage instashopPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        instashopPage = new InstashopPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void test001CheckInstashopPage() {
        ProductCard productCard = new ProductCard();

        mainPage
                .selectMainMenuInstashop()
        ;

        instashopPage
                .selectFirstGoodsGroupFromGallery()
                .selectFirstGoodFromChangedGoodsImage()
                .checkInfoOnProductPage()
                .rememberInfo(productCard)
                .selectSize()
        ;

        try {
            instashopPage
                    .clickAddToCartButton()
                    .clickMakePurchaseButton()
            ;

            checkoutPage
                    .checkCartPage()
                    .clickClosePopupBtn()
                    .checkTotalPrice(productCard)
                    .compareProductNamesFromProductCardsInCard(productCard)
                    .compareProductBrandsFromProductCardsInCart(productCard)
            ;

        } catch (Exception e) {
            System.out.println("Product is sold out");
        }
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
