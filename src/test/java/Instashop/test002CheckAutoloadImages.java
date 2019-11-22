package Instashop;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InstashopPage;
import pages.MainPage;

public class test002CheckAutoloadImages extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private InstashopPage instashopPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        instashopPage = new InstashopPage(driver);
    }

    @Test
    public void test002CheckAutoloadImages() {
        int ImagesAmount;

        mainPage
                .selectMainMenuInstashop()
        ;

        ImagesAmount = instashopPage.getNumberOfImages();

        instashopPage
                .movePageDown(ImagesAmount)
                .checkImagesAmount(ImagesAmount)
        ;

        ImagesAmount = instashopPage.getNumberOfImages();

        instashopPage
                .movePageDown(ImagesAmount)
                .checkImagesAmount(ImagesAmount)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
