package ui_tests;

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
    }
}