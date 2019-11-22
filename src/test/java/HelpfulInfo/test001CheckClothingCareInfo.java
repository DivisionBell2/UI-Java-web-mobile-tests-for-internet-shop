package HelpfulInfo;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HelpfulInfoPage;
import pages.MainPage;

public class test001CheckClothingCareInfo extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private HelpfulInfoPage helpfulInfoPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        helpfulInfoPage = new HelpfulInfoPage(driver);
    }

    @Test
    public void test001CheckClothingCareInfo() {
        mainPage
                .clickHelpfulInfoPage()
        ;

        helpfulInfoPage
                .checkSelectInfoList()
                .checkContentBlocksTitle("Стирка")
                .checkContentBlocksTitle("Отбеливание")
                .checkContentBlocksTitle("Сушка")
                .checkContentBlocksTitle("Химчистка")
                .checkContentBlocksTitle("Глажка")
                .checkcontentSVG()
                .checkContentBlocksText("Можно стирать")
                .checkContentBlocksText("Не сушить. Используется вместе со знаком \"Не стирать\"")
                .checkContentBlocksText("Глажка запрещена")
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
