package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.time.Duration;

public class AppManager {

    WebDriver wd;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountPage accountPage;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(wd);
        registrationPage = new RegistrationPage(wd);
        loginPage = new LoginPage(wd);
        accountPage = new AccountPage(wd);
    }

    public void stop() {
        wd.quit();
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }
    public AccountPage getAccountPage() {
        return accountPage;
    }
}