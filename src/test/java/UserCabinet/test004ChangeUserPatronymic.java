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

public class test004ChangeUserPatronymic extends MainClass {
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
    public void test004ChangeUserPatronymic() {
        JSONObject user = generateUser();
        String userPatronymic = User.SURNAME.getValue();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.PERSONAL_DATA.getValue())
        ;

        userCabinetPage
                .enterTextInInput("name", "patronymic", userPatronymic)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "patronymic", userPatronymic)
        ;

        userPatronymic = "SecondTestPatronymic";

        userCabinetPage
                .enterTextInInput("name", "patronymic", userPatronymic)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "patronymic", userPatronymic)
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
