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
        pause(3000);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        type(
                By.cssSelector("input[type='password'][autocomplete='new-password']"),
                password
        );
        pause(3000);
        return this;
    }

    public RegistrationPage clickSignUpButton() {
        click(By.xpath("//span[contains(text(),'Sign Up')]"));
        pause(3000);
        return this;
    }
// Этот тест считаем Негативным №1 для регистрации
// ожидаемый результат — неуспешная регистрация Captcha

    public String getCaptchaErrorMessage() {
        return wd.findElement(
                By.xpath(
                        "//*[normalize-space(text())=\"Captcha is required to verify that you're a human.\"]"
                )
        ).getText();
    }

    // Этот тест считаем Негативным №2 для регистрации
    // ожидаемый результат — сайт сам валидирует email и выводит сообщение

    public String getInvalidEmailMessage() {
        return wd.findElement(
                By.xpath("//*[normalize-space(text())='Double check your email and try again.']")
        ).getText();
    }
    // Этот тест считаем Негативным №3 для регистрации
    // Ожидаемый результат по e-mail не может быть пустым

    public String getEmptyEmailMessage() {
        return wd.findElement(
                By.xpath("//*[normalize-space(text())='Email cannot be blank']")
        ).getText();
    }
    // Этот тест считаем Негативным №4 для регистрации
   // ожидаемый результат — поле password не может быть пустым и выводит сообщение об ошибке
    public String getEmptyPasswordMessage() {
        return wd.findElement(
                By.xpath("//*[normalize-space(text())='Make sure you enter a password.']")
        ).getText();
    }

// Этот тест считаем позитивным №1 для регистрации
    //Он проверяет, что после открытия страницы регистрации отображаются основные элементы интерфейса

    public boolean isEmailFieldDisplayed() {
        return wd.findElement(
                By.cssSelector("input[type='email'][autocomplete='email']")
        ).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return wd.findElement(
                By.cssSelector("input[type='password'][autocomplete='new-password']")
        ).isDisplayed();
    }

    public boolean isSignUpButtonDisplayed() {
        return wd.findElement(
                By.xpath("//button[.//span[contains(text(),'Sign Up')]]")
        ).isDisplayed();
    }

    public boolean isLogInLinkDisplayed() {
        return wd.findElement(
                By.xpath("//*[normalize-space(text())='Log In']")
        ).isDisplayed();
    }

    // Этот тест считаем позитивным №2 для регистрации
    //Он проверяет, что форма корректно принимает валидные данные до CAPTCHA


    public String getEmailValue() {
        return wd.findElement(
                By.cssSelector("input[type='email'][autocomplete='email']")
        ).getAttribute("value");
    }

    public boolean isPasswordFilled() {
        String passwordValue = wd.findElement(
                By.cssSelector("input[type='password'][autocomplete='new-password']")
        ).getAttribute("value");

        return passwordValue != null && !passwordValue.isEmpty();
    }

    public boolean isSignUpButtonEnabled() {
        return wd.findElement(
                By.xpath("//button[.//span[contains(text(),'Sign Up')]]")
        ).isEnabled();
    }


}