package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .fillEmail("aitwebsitecohort82m@gmail.com")
                .fillPassword("AitWebsiteCohort82!!")
                .clickLoginButton();

        Assert.assertTrue(
                app.getHomePage().isUserMenuDisplayed(),
                "Expected authorized user menu to be displayed after login.");
    }

    //Первый негативный тест
    @Test
    public void loginWithEmptyEmailAndPasswordNegativeTest() {
        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .clickLoginButton();

        Assert.assertEquals(
                app.getLoginPage().getEmailValidationMessage(),
                "Email cannot be blank"
        );

        Assert.assertEquals(
                app.getLoginPage().getPasswordValidationMessage(),
                "Make sure you enter a password."
        );
    }

    @Test
    public void loginWithInvalidPasswordNegativeTest() {
        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .fillEmail("aitwebsitecohort82m@gmail.com")
                .fillPassword("WrongPassword123!")
                .clickLoginButton();

        Assert.assertEquals(
                app.getLoginPage().getWrongCredentialsMessage(),
                "Wrong email or password",
                "Incorrect error message for wrong email or password.");
    }

    @Test
    public void loginWithNonExistingEmailNegativeTest() {
        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .fillEmail("notregistered" + System.currentTimeMillis() + "@gmail.com")
                .fillPassword("AitWebsiteCohort82!!")
                .clickLoginButton();

        Assert.assertEquals(
                app.getLoginPage().getNonExistingEmailMessage(),
                "This email doesn't match any account. Try again.",
                "Incorrect error message for a non-existing email.");
    }

    @Test
    public void loginWithEmptyEmailNegativeTest() {
        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .fillEmail("")
                .fillPassword("AitWebsiteCohort82!!")
                .clickLoginButton();

        Assert.assertEquals(
                app.getLoginPage().getEmailValidationMessage(),
                "Email cannot be blank"
        );
    }

    @Test
    public void loginWithEmptyPasswordNegativeTest() {
        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .fillEmail("aitwebsitecohort82m@gmail.com")
                .fillPassword("")
                .clickLoginButton();

        Assert.assertEquals(
                app.getLoginPage().getPasswordValidationMessage(),
                "Make sure you enter a password."
        );
    }


}