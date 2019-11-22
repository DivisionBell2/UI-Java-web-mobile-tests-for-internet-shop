package Auth;

import com.alibaba.fastjson.JSONObject;
import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class test008CheckPasswordRecoveryPopup extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test
    void test008CheckPasswordRecoveryPopup() {
        JSONObject user = generateUser();

        mainPage
                .openAuthPopup()
                .clickForgetPasswordButton()
                .checkElementsRecoveryPasswordPopup("Восстановление пароля", "Укажите e-mail или телефон")
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
