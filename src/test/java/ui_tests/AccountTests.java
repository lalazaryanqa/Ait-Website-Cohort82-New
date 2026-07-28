package ui_tests;

import manager.PropertiesReader;
import org.testng.annotations.Test;

import java.io.File;

public class AccountTests extends TestBase {


    @Test
    public void openAccountPageTest() {

        File file = new File("src/test/resources/images/Person.png");

        app.getHomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginButton();

        app.getLoginPage()
                .clickLoginWithEmail()
                .fillEmail(PropertiesReader.getProperty("base.properties", "email"))
                .fillPassword(PropertiesReader.getProperty("base.properties", "password"))
                .clickLoginButton();

        app.getHomePage()
                .clickUserMenu()
                .clickMyAccount()
                .clickProfile()
                .fillAbout("Tanja and Albert are currently testing AIT Website.")
                .clickEditProfile()
                .fillTitle("Automation QA Engineer")
                .fillFirstName("Albert and Tatjana")
                .fillLastName("Lalazaryan and Karotkina")
                .fillPhone("+491701234567")
                .uploadProfileImage(file.getAbsolutePath())
                .scrollToVisibilityAndPrivacy()
                .openProfileUrlSection()
                .openProfilePrivacy()
                .openBlockedMembers()
                .scrollUp()
                .clickMyGroups()
                .clickAccountMenuItems()
                .logout();
    }


}


