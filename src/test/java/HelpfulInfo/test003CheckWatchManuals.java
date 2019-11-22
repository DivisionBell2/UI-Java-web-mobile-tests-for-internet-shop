package HelpfulInfo;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HelpfulInfoPage;
import pages.MainPage;

public class test003CheckWatchManuals extends MainClass {
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
    public void test003CheckWatchManuals() {
        mainPage
                .clickHelpfulInfoPage()
        ;

        helpfulInfoPage
                .clickSelectInfo()
                .clickInfoTheme("Инструкции к часам")
                .checkWatchInstructions()
                ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
