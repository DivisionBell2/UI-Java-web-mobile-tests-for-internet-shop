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

public class test001AddToWishlist extends MainClass {
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
    public void test001AddToWishlist() {
        ProductCard card = new ProductCard();

        mainPage
                .selectMainMenuCategory(Categories.CLOTHES.getValue(), Categories.CATEGORIES.getValue())
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
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
