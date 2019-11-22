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

import java.util.Arrays;
import java.util.List;

public class test009CheckClubcardPage extends MainClass {
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
    public void test009CheckClubcardPage() {

        JSONObject user = generateUser();

        List<String> infoText = Arrays.asList(
                "Ваша текущая скидка",
                "Сумма накоплений",
                "До следующей скидки"
        );

        List<String> discountCost = Arrays.asList(
                "От 7000",
                "От 30000",
                "От 70000",
                "От 300000"
        );

        List<String> discountPercent = Arrays.asList("5%", "10%", "15%", "20%");

        List<String> conditionsText = Arrays.asList(
                "Активируется только со следующей покупки",
                "Не распространяется на товары из категории SALE",
                "Не распространяется на стоимость доставки и прочие сервисные услуги",
                "Скидка по карте действует как на сайте Butik.ru, так и в Универмаге в Москве"
        );

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", user.get("email").toString())
                .enterTextInInput("type", "password", User.PASS.getValue())
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.CLUB_CARD.getValue())
        ;

        userCabinetPage
                .checkClubcardTitle()
                .checkClubcardPageUserInfo(infoText)
                .checkDiscountCostInfo(discountCost, discountPercent)
                .checkDiscountConditionsInfo(conditionsText)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
