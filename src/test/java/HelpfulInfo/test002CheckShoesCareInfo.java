package HelpfulInfo;

import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HelpfulInfoPage;
import pages.MainPage;

public class test002CheckShoesCareInfo extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private HelpfulInfoPage helpfulInfoPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
        helpfulInfoPage = new HelpfulInfoPage(driver);
    }

    @Test
    public void test002CheckShoesCareInfo() {
        mainPage
                .clickHelpfulInfoPage()
        ;

        helpfulInfoPage
                .clickSelectInfo()
                .clickInfoTheme("Уход за обувью")
                .checkContentBlocksTitle("Советы по уходу за обувью")
                .checkParagraphes("При эксплуатации необходимо пользоваться средствами по уходу за обувью")
                .checkParagraphes("Необходимо вовремя менять набойки.")
                .checkSectionText("Обувь из натуральной кожи")
                .checkTextInSections("Новую кожаную обувь перед началом носки необходимо обработать кремом")
                .checkSectionText("Обувь из замши и нубука")
                .checkTextInSections("Замшевая обувь, велюровая обувь и обувь из нубука требует внимания и особого ухода")
                .checkSectionText("Лакированная обувь")
                .checkTextInSections("Лакированную обувь не следует обрабатывать щеткой")
                .checkSectionText("Обувь из текстиля")
                .checkTextInSections("Обувь с текстильным верхом моют мыльной водой")
                .checkSectionText("Обувь из искусственной кожи")
                .checkTextInSections("Такую обувь необходимо протирать чистой влажной тканью.")
                .checkSectionText("Обувь из резины")
                .checkTextInSections("Чтобы резиновая обувь сохранила свой блеск, ее следует мыть теплой водой и вытирать насухо тканью.")
                .checkSectionText("Обувь из натурального каучука hunter")
                .checkTextInSections("Обувь HUNTER необходимо сушить или хранить только при комнатной температуре, в сухом, удаленном от отопительных приборов месте для сохранения покрытия, например, дополнительного блеска, матовости и т.д.")
        ;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
