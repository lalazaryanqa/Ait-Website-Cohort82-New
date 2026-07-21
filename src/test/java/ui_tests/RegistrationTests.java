package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    private String generateUniqueEmail() {
        return "aitstudent" + System.currentTimeMillis() + "@gmail.com";
    }

    @Test
    public void registrationPositiveTest() {

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getRegistrationPage()
                .clickSignUp()
                .clickSignUpWithEmail()
                .fillEmail("aitwebsitecohort82m@gmail.com")
                .fillPassword("AitWebsiteCohort82!!")
                .clickSignUpButton();
    }
    @Test
    public void registrationWithoutCaptchaTest() {
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

}