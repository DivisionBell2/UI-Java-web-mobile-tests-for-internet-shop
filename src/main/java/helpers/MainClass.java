package helpers;

import com.alibaba.fastjson.JSONObject;
import com.jayway.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class MainClass extends WebDriverSettings {
    protected void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected Optional<String> getEnv(String envName) {
        return Optional.ofNullable(System.getenv("bamboo_" + envName));
    }

    // WAITING METHODS

    protected void waitForLoad(WebDriver driver) {
        int tryCount = 0;
        int maxTimeout = 20;

        String state = getPageLoadState(driver);
        while (!state.equals("complete")) {
            if (tryCount > maxTimeout) {
                throw new AssertionError("Страница не была окончательно загружена за " + maxTimeout + " секунды");
            }
            state = getPageLoadState(driver);
            sleep(1000);
            tryCount++;
        }
    }

    private String getPageLoadState(WebDriver driver) {
        String state;
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            state = jse.executeScript("return document.readyState").toString();
        } catch (Exception e) {
            state = "unknown";
        }
        return state;
    }

    protected WebElement waitElementClickable(WebDriver driver, String xPath) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    protected WebElement waitElementClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected boolean waitElementInvisible(WebDriver driver, String element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
    }

    protected WebElement waitElementVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected List<WebElement> waitElementVisible(WebDriver driver, List<WebElement> element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    //GENERATING METHODS

    protected String generatePhone() {
        String s = String.valueOf(System.currentTimeMillis()).substring(4);
        MaskFormatter mf;
        try {
            mf = new MaskFormatter("+7(9AA)AAA-AA-AA");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    protected String generateMail() {
        return UUID.randomUUID().toString() + "@test.test";
    }

    protected JSONObject generateUser() {
        return RestAssured
                .given()
                .baseUri(getEnv("URL").orElse(ConfigParse.getProp("url")))
                .basePath("/api/register")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("_token", "EB6YOFPZGpAMxXBEHZDPYV68bP2Bkr87Sq8Wrqwe")
                .formParam("subscribe", 1)
                .formParam("sex", 2)
                .formParam("password", "123456789")
                .formParam("phone", generatePhone())
                .formParam("email", generateMail())
                .formParam("name_entered", "Test User")
                .post()
                .andReturn().as(JSONObject.class).getJSONObject("user");
    }

    //FILTERING METHODS

    protected WebElement filterListByAttribute(List<WebElement> elements, String attribute, String attrValue) {
        return elements.stream()
                .filter(WebElement -> WebElement.getAttribute(attribute).toLowerCase().equals(attrValue.toLowerCase()))
                .findFirst()
                .orElseThrow(AssertionError::new);
    }

    protected WebElement filterListByText(List<WebElement> elements, String text) {
        return elements
                .stream()
                .filter(WebElement -> WebElement.getText()
                                                .toLowerCase()
                                                .contains(text.toLowerCase()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
        ;
    }

    protected WebElement filterListByTextStrong(List<WebElement> elements, String text) {
        return elements
                .stream()
                .filter(WebElement -> WebElement.getText()
                        .toLowerCase()
                        .equals(text.toLowerCase()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                ;
    }

    protected int getRandomElementFromList(List elements) {
        return new Random().nextInt(elements.size());
    }

    private int randRange(List<WebElement> max) {
        return ThreadLocalRandom.current().nextInt(max.size());
    }

    protected WebElement getRandomVisibleElementFromList(List<WebElement> elements) {
        List sortedList = elements
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
        return (WebElement) sortedList.get(randRange(sortedList));
    }

    protected List<WebElement> getListByVisibleElements(List<WebElement> elements) {
        return elements
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }

    //PARSING METHODS

    protected int getInt(WebElement element) {
        return Integer.parseInt(element.getText().replaceAll("[\\D]", ""));
    }

    //CHECKING METHODS

    protected MainClass isTextExist(WebDriver driver, WebElement element, String message) {
        assert waitElementVisible(driver, element)
                .getText()
                .toLowerCase()
                .contains(message.toLowerCase());
        return this;
    }

    protected MainClass compareWebelementsText(WebElement expectedElement, WebElement actualElement) {
        assert expectedElement
                .getText()
                .toLowerCase()
                .replaceAll("\\s+","")
                .contains(actualElement
                        .getText()
                        .toLowerCase()
                        .replaceAll("\\s+",""));
        return this;
    }

    protected MainClass isWebElementsOfListContainText(List <WebElement> elements, String text) {
        elements
                .stream()
                .forEach(WebElement -> {
                    assert WebElement
                            .getText()
                            .toLowerCase()
                            .contains(text.toLowerCase())
                            : String.format("actual: %s, expected: %s", WebElement.getText(), text);
                });
        return this;
    }

    public MainClass isDisplayedWebElementsOfListContainText(List<WebElement> element, String text) {
        element
                .stream()
                .filter(WebElement -> WebElement.isDisplayed())
                .filter(WebElement -> WebElement.getText()
                        .toLowerCase()
                        .contains(text.toLowerCase()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        return this;
    }

    protected MainClass compareTextInWebElement(WebDriver driver, WebElement element, String text) {
        assert waitElementVisible(driver, element)
                .getText()
                .toLowerCase()
                .contains(text.toLowerCase());
        return this;
    }

    //SCROLL METHODS
    protected void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        sleep(1000);
    }

}
