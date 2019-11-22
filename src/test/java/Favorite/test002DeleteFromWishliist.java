package Favorite;

import helpers.MainClass;
import helpers.ProductCard;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FavoritePage;
import pages.MainPage;
import pages.NPCPage;
import pages.SearchPage;
import testData.Categories;

public class test002DeleteFromWishliist extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private NPCPage npcPage;
    private FavoritePage favoritePage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        npcPage = new NPCPage(driver);
        favoritePage = new FavoritePage(driver);
    }

    @Test
    public void test002DeleteFromWishlist() {
        ProductCard card = new ProductCard();

        mainPage.
                selectMainMenuCategory(Categories.BAGS.getValue())
        ;

        searchPage
                .selectFirstProduct()
        ;

        npcPage
                .selectSize()
                .rememberInfo(card)
                .clickAddToFavoriteBtn()
                .clickFavoriteButtonInHeader()
        ;

        favoritePage
                .checkProductCards()
                .clickDeleteButton()
                .checkEmptyWishlist()
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
