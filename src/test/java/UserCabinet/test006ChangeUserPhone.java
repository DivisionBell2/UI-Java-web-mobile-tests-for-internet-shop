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

public class test006ChangeUserPhone extends MainClass {
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
    public void test006ChangeUserPhone() {
        JSONObject user = generateUser();
        String userPhone = user.get("phone").toString();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", userPhone)
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.PERSONAL_DATA.getValue())
        ;

        userPhone = generatePhone();

        userCabinetPage.enterTextInInput("name", "phone", userPhone)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "phone", userPhone)
        ;

        userPhone = generatePhone();

        userCabinetPage.enterTextInInput("name", "phone", userPhone)
                .clickSaveButton()
                .checkSuccessChangingMessage()
                .checkTextInForm("name", "phone", userPhone)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
