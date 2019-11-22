package helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings{

    protected Optional<String> getEnv(String envName) {
        return Optional.ofNullable(System.getenv("bamboo_" + envName));
    }

    private RemoteWebDriver connectToRemote(DesiredCapabilities capabilities) {
        try {
            return new RemoteWebDriver(URI.create(ConfigParse.getProp("docker")).toURL(), capabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private DesiredCapabilities getCapabilities(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        return capabilities;
    }

    public WebDriver setupDriver(ITestResult tr) {
        WebDriver driver;

        boolean startInSelenoidDocker;
        try {
            startInSelenoidDocker = !ConfigParse.getProp("docker").equals("");
        } catch (Exception e) {
            startInSelenoidDocker = false;
        }

        if (startInSelenoidDocker) {
            String browser = getEnv("BROWSER").orElse(ConfigParse.getProp("browser"));
            driver = connectToRemote(getCapabilities(browser));
        } else {
            String chromedriverPath;
            try {
                chromedriverPath = Objects.requireNonNull(this.getClass().getClassLoader()
                        .getResource("chromedriver.exe")).getPath();
            } catch (Exception e) {
                chromedriverPath = Objects.requireNonNull(this.getClass().getClassLoader()
                        .getResource("chromedriver")).getPath();
            }
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            driver = new ChromeDriver();
        }

        driver.manage().window().setSize(new Dimension(375, 812));
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get(getEnv("URL").orElse(ConfigParse.getProp("url")));
        tr.setAttribute("driver", driver);
        driver.manage().addCookie(new Cookie("do_not_report_to_analytics", "1"));
        driver.manage().addCookie(new Cookie("dy_hideDY", "1"));
        driver.manage().addCookie(new Cookie("dy_leto19", "1"));
        driver.manage().addCookie(new Cookie("butik-test", "true"));
        driver.navigate().refresh();
        return new EventFiringWebDriver(driver).register(new WebEventListener());
    }

}


