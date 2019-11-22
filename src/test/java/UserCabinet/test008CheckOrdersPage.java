package UserCabinet;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.UserCabinetPage;
import testData.Categories;

import java.util.HashMap;
import java.util.Map;

public class test008CheckOrdersPage extends MainClass {
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
    public void test008CheckOrdersPage() {

        Map<String, String> orderValues = new HashMap();

        mainPage
                .openAuthPopup()
                .enterTextInInput("name", "email", "neglavmag+52@gmail.com")
                .enterTextInInput("type", "password", "cnfylfhnysq")
                .clickAuthButton()
                .checkUserLogined()
                .clickAuthUserMenuElement(Categories.MY_ORDERS.getValue())
        ;

        userCabinetPage
                .checkOrderBlock()
        ;

        orderValues = userCabinetPage.getValuesFromOrder();

        userCabinetPage
                .clickOrderButton()
                .checkOrderInfo(orderValues)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
