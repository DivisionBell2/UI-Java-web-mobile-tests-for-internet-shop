package Social;

import helpers.MainClass;
import helpers.ProductCard;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.NPCPage;
import pages.SearchPage;
import pages.SocialPage;
import testData.Categories;

import java.util.Arrays;
import java.util.List;

public class test001ShareOnVK extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private NPCPage npcPage;
    private SocialPage socialPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        npcPage = new NPCPage(driver);
        socialPage = new SocialPage(driver);
    }

    @Test
    public void test001ShareOnVK() {
        List<String> menuCategories = Arrays.asList(Categories.CLOTHES.getValue(), Categories.BAGS.getValue(), Categories.SHOES.getValue(), Categories.ACCESSORIES.getValue());
        ProductCard info = new ProductCard();
        String npcUrl;
        String snippetUrl;

        mainPage
                .selectMainMenuCategory(menuCategories.get(getRandomElementFromList(menuCategories)))
        ;

        searchPage
                .selectFirstProduct();
        ;

        npcUrl = driver.getCurrentUrl();

        npcPage
                .selectSize()
                .rememberInfo(info)
                .clickShareVKButton()
                .logVK("79254744253", "1qaz2wsx")
        ;

        socialPage
                .clickPublishVKButton()
                .clickWatchPublish()
                .compareProductInfo(info)
        ;

        snippetUrl = socialPage.getSnippetHref();

        socialPage
                .deleteVKWallItem()
                .goToSnippetURL(snippetUrl)
                .compareUrl(npcUrl)
        ;

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
