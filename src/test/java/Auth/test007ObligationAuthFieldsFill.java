package Auth;

import com.alibaba.fastjson.JSONObject;
import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class test007ObligationAuthFieldsFill extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test
    void test007ObligationAuthFieldsFill() {
        JSONObject user = generateUser();
        String cssValueEmptyField = "rgb(215, 79, 68) 0px 0px 0px 1px inset";
        String userEmail = user.get("email").toString();

        mainPage
                .openAuthPopup()
                .clickAuthButtonNegative()
                .checkInputHasRedBorder("name", "email", cssValueEmptyField)
                .checkInputHasRedBorder("type", "password", cssValueEmptyField)
                .refreshPage()
        ;

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", userEmail)
                .clickAuthButtonNegative()
                .checkInputHasRedBorder("type", "password", cssValueEmptyField)
                .refreshPage()
        ;

        mainPage
                .openAuthPopup()
                .enterTextInInput("type", "password", userEmail)
                .clickAuthButtonNegative()
                .checkInputHasRedBorder("name", "email", cssValueEmptyField)
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
