package ui_tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

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
}