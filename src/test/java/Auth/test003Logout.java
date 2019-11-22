package Auth;

import com.alibaba.fastjson.JSONObject;
import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import testData.User;

public class test003Logout extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test
    public void test003Logout() {
        JSONObject user = generateUser();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .logoutUser()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
