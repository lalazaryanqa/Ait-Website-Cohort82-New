package pages;

import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends HelperBase {

    public RegistrationPage(WebDriver wd) {
        super(wd);
    }



//    public RegistrationPage openRegistrationPage() {
//        wd.get("https://my-ait.com/account/my-account");
//        pause(5000);
//        return this;
//    }

    public RegistrationPage clickSignUp() {
        click(By.xpath("//*[text()='Sign Up']"));
        pause(5000);
        return this;
    }

    public RegistrationPage clickSignUpWithEmail() {
        click(By.xpath("//span[contains(text(),'Sign up with email')]"));
        pause(5000);
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        type(
                By.cssSelector("input[type='email'][autocomplete='email']"),
                email
        );
        pause(5000);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        type(
                By.cssSelector("input[type='password'][autocomplete='new-password']"),
                password
        );
        pause(5000);
        return this;
    }

    public RegistrationPage clickSignUpButton() {
        click(By.xpath("//span[contains(text(),'Sign Up')]"));
        pause(5000);
        return this;
    }
}