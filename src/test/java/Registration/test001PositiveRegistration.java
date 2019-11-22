package Registration;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import testData.User;

public class test001PositiveRegistration extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test
    public void test001PositiveRegistration() {

        mainPage
                .openAuthPopup()
                .clickRegistrationBtn()
                .enterTextInInput("name", "name_entered", User.NAME.getValue())
                .enterTextInInput("name", "email", generateMail())
                .enterTextInInput("name", "phone", generatePhone())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickRegCompleteBtn()
                .checkWelcomeMsg("Добро пожаловать в BUTIK.")
                .clickRegistrationPopupClosed()
                .checkUserLogined()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
