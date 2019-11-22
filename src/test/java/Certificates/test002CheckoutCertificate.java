package Certificates;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import testData.User;

public class test002CheckoutCertificate extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private CertificatePage certificatePage;
    private SearchPage searchPage;
    private NPCPage npcPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    void setup(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        certificatePage = new CertificatePage(driver);
        searchPage = new SearchPage(driver);
        npcPage = new NPCPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void test002CheckoutCertificate() {

        mainPage
                .clickCertificatesPage()
        ;

        certificatePage
                .clickBuyButton()
        ;

        npcPage
                .checkCartPopupMessage("Добавлено в корзину")
                .closeCartPopup()
                .clickCartIconInHeader()
        ;

        checkoutPage
                .checkCartPage()
                .clickClosePopupBtn()
                .checkTotalPriceByValue("3000")
                .enterTextInInput("name", "name", User.FULLNAME.getValue())
                .enterTextInInput("name", "phone", generatePhone())
                .enterTextInInput("name", "email", generateMail())
                .enterCityName("Москва")
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
