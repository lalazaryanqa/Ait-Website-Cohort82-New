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


//        app.getHomePage()
//                .clickUserMenu()
//                .clickMyAccount();

    }
