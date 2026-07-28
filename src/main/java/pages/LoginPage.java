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
        pause(3000);
        return this;
    }

    public LoginPage fillEmail(String email) {
        type(By.cssSelector("input[type='email'][autocomplete='email']"), email);
        pause(3000);
        return this;
    }

    public LoginPage fillPassword(String password) {
        type(By.xpath("//input[@type='password']"), password);
        pause(3000);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(By.xpath("//button[@aria-label='Log In']"));
        pause(3000);
        return this;
    }

    // №1 негативный тест
    public String getEmailValidationMessage() {
        return wd.findElement(By.xpath("//*[text()='Email cannot be blank']"))
                .getText();
    }

    public String getPasswordValidationMessage() {
        return wd.findElement(
                By.xpath("//*[text()='Make sure you enter a password.']")).getText();
    public String getPasswordValidationMessage() {
        return wd.findElement(
                By.xpath("//*[text()='Make sure you enter a password.']")
        ).getText();
    }

    // №2 негативный тест
    public String getWrongCredentialsMessage() {
        return wd.findElement(
                By.xpath("//*[text()='Wrong email or password']")).getText();
    }

    // №3 негативный тест
    public String getNonExistingEmailMessage() {
        return wd.findElement(
                By.xpath("//*[normalize-space(.)=\"This email doesn't match any account. " +
                        "Try again.\"]")
        ).getText();
    }

}