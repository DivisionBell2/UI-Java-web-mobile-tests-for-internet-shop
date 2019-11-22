package Clubcard;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ClubcardPage;
import pages.MainPage;

public class test001CheckClubcardPage extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private ClubcardPage clubcardPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        clubcardPage = new ClubcardPage(driver);
    }

    @Test(invocationCount = 5)
    public void test001CheckClubcardPage() {
        mainPage
                .clickClubcardPage()
        ;

        clubcardPage
                .checkDescritpionText("При накоплении покупок на сумму от 7 000 \u20BD вы можете получить клубную карту")
                .checkDescritpionText("в Универмаге или при доставке следующей покупки.")
                .checkTermsText("уникальные скидки на новые коллекции")
                .checkTermsText("скидки на товары, не участвующие в сезонных распродажах и акциях")
                .checkTermsText("доступ к участию в закрытых pre-sale")
                .checkTermsText("скидки на товары, не участвующие в сезонных распродажах и акциях")
                .checkTermsText("скидка предоставляется со следующей покупки")
                .checkTermsText("скидка не распространяется на товары категории SALE, на доставку и другие сервисные услуги")
                .checkTermsText("скидка не суммируется с другими скидками и акциями")
                .checkTermsText("картой можно воспользоваться в Интернет-магазине и в Универмаге BUTIK.")
                .checkDiscountTable("От 7 000 \u20BD", "5%")
                .checkDiscountTable("От 30 000 \u20BD", "10%")
                .checkDiscountTable("От 70 000 \u20BD", "15%")
                .checkDiscountTable("От 300 000 \u20BD", "20%")
                .checkClubcardImage()
        ;



    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
