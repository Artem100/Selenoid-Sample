import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenoidTest {

    WebDriver driver;
    String aTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
    String remoteURL = "http://172.19.0.1:4444/wd/hub/";
    String errorMessage = "Oops, that's not a match.";

    @BeforeMethod
    public void setupSelenoid(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("72.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(remoteURL), capabilities);
            WebDriverRunner.setWebDriver(driver);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void test01(){
        Assert.assertTrue(title().contains(aTitle));
        $(By.cssSelector(".gh-ug-guest > a")).click();
        $(By.id("userid")).setValue("test");
        $(By.id("pass")).setValue("test");
        $(By.id("sgnBt")).click();
        $(By.cssSelector("p#errf")).shouldHave(Condition.text(errorMessage));
    }

    @AfterMethod
    public void closeBrowser(){
        WebDriverRunner.closeWebDriver();
    }
}
