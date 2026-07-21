package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    private String generateUniqueEmail() {
        return "aitstudent" + System.currentTimeMillis() + "@gmail.com";
    }

    @Test
    public void registrationWithoutCaptchaNegativeTest() {
        String uniqueEmail = generateUniqueEmail();

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail()
                .fillEmail(uniqueEmail)
                .fillPassword("AitWebsiteCohort82!!")
                .clickSignUpButton();

        String actualMessage = app.getRegistrationPage()
                .getCaptchaErrorMessage();

        Assert.assertEquals(
                actualMessage,
                "Captcha is required to verify that you're a human."
        );
    }

    @Test
    public void registrationWithInvalidEmailNegativeTest() {

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail()
                .fillEmail("usergmail.com")
                .fillPassword("AitWebsiteCohort82!!")
                .clickSignUpButton();

        String actualMessage = app.getRegistrationPage()
                .getInvalidEmailMessage();

        Assert.assertEquals(actualMessage,"Double check your email and try again.");
    }

    @Test
    public void registrationWithEmptyEmailNegativeTest() {

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail()
                .fillPassword("AitWebsiteCohort82!!")
                .clickSignUpButton();

        String actualMessage = app.getRegistrationPage()
                .getEmptyEmailMessage();

        Assert.assertEquals(actualMessage, "Email cannot be blank");
    }

    @Test
    public void registrationWithEmptyPasswordNegativeTest() {
        String uniqueEmail = generateUniqueEmail();

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail()
                .fillEmail(uniqueEmail)
                .fillPassword("")
                .clickSignUpButton();

        String actualMessage = app.getRegistrationPage()
                .getEmptyPasswordMessage();

        Assert.assertEquals(actualMessage, "Make sure you enter a password.");
    }

    @Test
    public void registrationPageElementsAreDisplayedPositiveTest() {

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail();

        Assert.assertTrue(app.getRegistrationPage().isEmailFieldDisplayed());

        Assert.assertTrue(app.getRegistrationPage().isPasswordFieldDisplayed());

        Assert.assertTrue(app.getRegistrationPage().isSignUpButtonDisplayed());

        Assert.assertTrue(app.getRegistrationPage().isLogInLinkDisplayed());
    }


    @Test
    public void registrationWithGeneratedEmailPositiveTest() {
        String uniqueEmail = generateUniqueEmail();

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail()
                .fillEmail(uniqueEmail)
                .fillPassword("AitWebsiteCohort82!!");

        Assert.assertEquals(
                app.getRegistrationPage().getEmailValue(),
                uniqueEmail
        );

        Assert.assertTrue(
                app.getRegistrationPage().isPasswordFilled()
        );

        Assert.assertTrue(
                app.getRegistrationPage().isSignUpButtonEnabled()
        );
    }



}