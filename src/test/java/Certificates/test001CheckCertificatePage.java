package Certificates;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CertificatePage;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

public class test001CheckCertificatePage extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private CertificatePage certificatePage;

    @BeforeMethod
    void setup(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        certificatePage = new CertificatePage(driver);
    }

    @Test
    void test001CheckCertificatePage() {
        List<String> nominals = Arrays.asList("3000", "5000", "10000", "15000");

        mainPage
                .clickCertificatesPage()
        ;

        certificatePage
                .checkImage()
                .checkCertificatesNominal(nominals)
                .checkBuyButtons(nominals)
                .clickConditionButton()
                .checkConditionText("Подарочный сертификат может быть использован для полной или частичной оплаты товаров")
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
