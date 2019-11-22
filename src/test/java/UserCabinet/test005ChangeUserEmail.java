package UserCabinet;

import com.alibaba.fastjson.JSONObject;
import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.UserCabinetPage;
import testData.Categories;
import testData.User;

public class test005ChangeUserEmail extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private UserCabinetPage userCabinetPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        userCabinetPage = new UserCabinetPage(driver);
    }

    @Test
    public void test005ChangeUserEmail() {
        JSONObject user = generateUser();
        String userEmail = generateMail();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.PERSONAL_DATA.getValue())
        ;

        userCabinetPage
                .enterTextInInput("name", "email", userEmail)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "email", userEmail)
        ;

        userEmail = generateMail();

        userCabinetPage
                .enterTextInInput("name", "email", userEmail)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "email", userEmail)
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
