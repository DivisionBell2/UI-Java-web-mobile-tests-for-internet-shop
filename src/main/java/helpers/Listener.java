package helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {

    @Attachment("Screenshot error page")
    private byte[] takeScreenShot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        RemoteWebDriver driver = (RemoteWebDriver) tr.getAttribute("driver");
        String sessionId = driver.getSessionId().toString();
        Allure.addAttachment("url with error", driver.getCurrentUrl());
        System.out.println(driver.manage().getCookies().toString());
        driver.quit();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        RemoteWebDriver driver = (RemoteWebDriver) tr.getAttribute("driver");
        Allure.addAttachment("cookies", driver.manage().getCookies().toString());
        String sessionId = driver.getSessionId().toString();
        driver.quit();
    }
}
