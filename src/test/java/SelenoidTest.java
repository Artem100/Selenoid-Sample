import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Main;
import pages.SigIn;
import setup.SettingsSelenoid;

import java.util.ResourceBundle;

public class SelenoidTest {

    private static ResourceBundle url = ResourceBundle.getBundle("url");
    private static ResourceBundle testdata = ResourceBundle.getBundle("testData");

    @BeforeMethod
    public void setup(){
        SettingsSelenoid.setupSelenoid(url.getString("ebayURL"));
    }

    @Test
    public void test01(){
        Main.gotoSingInPage();
        SigIn.enterLoginInData(testdata.getString("NonExistEmail"),testdata.getString("IncorrectPass"));
        SigIn.errorFailedSignIn();
    }

    @AfterMethod
    public void closeBrowser(){
        SettingsSelenoid.closeBrowser();
    }
}
