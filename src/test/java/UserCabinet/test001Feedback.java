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
import testData.Cities;
import testData.User;

public class test001Feedback extends MainClass {
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
    public void test001Feedback() {
        JSONObject user = generateUser();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.QUESTION.getValue())
        ;

        userCabinetPage
                .checkSendMessageButton()
                .enterCity("name", "city", Cities.MOSCOW.getValue())
                .clickQuestionSelect()
                .selectTypeOfQuestion()
                .enterQuestionText("Это тестовое сообщение. Всем хорошего дня!")
                .clickSendMessageButton()
                .checkSendQuestionMessage()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
