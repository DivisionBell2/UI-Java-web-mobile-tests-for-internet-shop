package Registration;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import testData.User;

public class test002ObligationRegistrationFieldsFill extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test
    public void test002ObligationRegistrationFieldsFill() {
        String cssValueEmptyField = "rgb(215, 79, 68) 0px 0px 0px 1px inset";


        mainPage
                .openAuthPopup()
                .clickRegistrationBtn()
                .clickRegCompleteBtn()
                .checkInputHasRedBorder("name", "name_entered", cssValueEmptyField)
                .checkInputHasRedBorder("name", "email", cssValueEmptyField)
                .checkInputHasRedBorder("name", "phone", cssValueEmptyField)
                .checkInputHasRedBorder("type", "password", cssValueEmptyField)
                .enterTextInInput("name", "name_entered", User.NAME.getValue())
                .clickRegCompleteBtn()
                .checkInputHasRedBorder("name", "email", cssValueEmptyField)
                .checkInputHasRedBorder("name", "phone", cssValueEmptyField)
                .checkInputHasRedBorder("type", "password", cssValueEmptyField)
                .refreshPage()
        ;

        mainPage
                .openAuthPopup()
                .clickRegistrationBtn()
                .enterTextInInput("name", "phone", User.PHONE.getValue())
                .clickRegCompleteBtn()
                .checkInputHasRedBorder("name", "name_entered", cssValueEmptyField)
                .checkInputHasRedBorder("name", "email", cssValueEmptyField)
                .checkInputHasRedBorder("type", "password", cssValueEmptyField)
                .refreshPage()
        ;

        mainPage
                .openAuthPopup()
                .clickRegistrationBtn()
                .enterTextInInput("name", "email", "test@test.test")
                .clickRegCompleteBtn()
                .checkInputHasRedBorder("name", "name_entered", cssValueEmptyField)
                .checkInputHasRedBorder("name", "phone", cssValueEmptyField)
                .checkInputHasRedBorder("type", "password", cssValueEmptyField)
                .refreshPage()
        ;

        mainPage
                .openAuthPopup()
                .clickRegistrationBtn()
                .enterTextInInput("type", "password", "123456789")
                .clickRegCompleteBtn()
                .checkInputHasRedBorder("name", "name_entered", cssValueEmptyField)
                .checkInputHasRedBorder("name", "email", cssValueEmptyField)
                .checkInputHasRedBorder("name", "phone", cssValueEmptyField)
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
