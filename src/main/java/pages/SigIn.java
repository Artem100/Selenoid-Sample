package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ResourceBundle;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class SigIn {

    private static ResourceBundle titles = ResourceBundle.getBundle("titles");
    private static ResourceBundle error = ResourceBundle.getBundle("errorMessages");

    private static By fieldUsername = By.id("userid");
    private static By fieldPassword = By.id("pass");
    private static By buttonSubmit = By.id("sgnBt");
    private static By messageFailedSignIn = By.cssSelector("p#errf");

    public static void assertSingInPage(){
        Assert.assertTrue(title().contains(titles.getString("SignIn")));
    }

    public static void enterLoginInData(String username, String password){
        assertSingInPage();
        $(fieldUsername).sendKeys(username);
        $(fieldPassword).sendKeys(password);
        $(buttonSubmit).click();
    }

    public static void errorFailedSignIn(){
        $(messageFailedSignIn).shouldHave(Condition.text(error.getString("FailedSignIn")));
    }

}
