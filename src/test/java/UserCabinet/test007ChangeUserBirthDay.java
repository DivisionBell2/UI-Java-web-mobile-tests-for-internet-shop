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

public class test007ChangeUserBirthDay extends MainClass {
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
    public void test007ChangeUserBirthDay() {
        JSONObject user = generateUser();
        String userBirthDay = "15-12-2000";

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.PERSONAL_DATA.getValue())
        ;

        userCabinetPage
                .enterTextInInput("name", "dob", userBirthDay)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "dob", userBirthDay)
        ;

        userBirthDay = "14-11-1999";

        userCabinetPage.enterTextInInput("name", "dob", userBirthDay)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "dob", userBirthDay)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
