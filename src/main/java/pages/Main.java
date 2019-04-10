package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ResourceBundle;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class Main {
    private static ResourceBundle titles = ResourceBundle.getBundle("titles");

    private static By buttonSignIn = By.cssSelector(".gh-ug-guest > a");

    private static void assertMainPage(){
        Assert.assertTrue(title().contains(titles.getString("MainPage")));
    }

    public static void gotoSingInPage(){
        assertMainPage();
        $(buttonSignIn).click();
    }


}
