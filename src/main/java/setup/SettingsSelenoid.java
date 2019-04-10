package setup;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsSelenoid {

    private static WebDriver driver = null;

    private static ResourceBundle url = ResourceBundle.getBundle("url");

    public static void setupSelenoid(String URL){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("72.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        try {
            driver = new RemoteWebDriver(new URL(url.getString("remoteURL")), capabilities);
            WebDriverRunner.setWebDriver(driver);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(URL);
    }

    public static void closeBrowser(){
        driver.close();
    }


}
