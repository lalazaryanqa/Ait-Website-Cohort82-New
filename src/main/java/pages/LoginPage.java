package pages;

import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HelperBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginWithEmail() {
        click(By.xpath("//span[contains(text(),'Log in with Email')]"));
        pause(5000);
        return this;
    }

    public LoginPage fillEmail(String email) {
        type(By.cssSelector("input[type='email'][autocomplete='email']"), email);
        pause(5000);
        return this;
    }

    public LoginPage fillPassword(String password) {
        type(By.xpath("//input[@type='password']"), password);
        pause(5000);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(By.xpath("//button[@aria-label='Log In']"));
        pause(5000);
        return this;
    }
}