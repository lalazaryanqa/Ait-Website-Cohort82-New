package pages;

import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends HelperBase {

    public HomePage(WebDriver wd) {
        super(wd);
    }

    public HomePage openHomePage() {
        wd.get("https://my-ait.com/");
        return this;
    }

    public HomePage acceptCookies() {
        click(By.cssSelector("#cst-cookies-submit"));
        return this;
    }

    public HomePage clickLoginButton() {
        click(By.xpath("//*[contains(text(),'Log In')]"));
        return this;
    }

    public HomePage clickUserMenu() {
        new WebDriverWait(wd, Duration.ofSeconds(3))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector("[data-testid='siteMembersDialogLayout']")
                ));

        click(By.cssSelector("[data-testid='handle-button']"));
        pause(3000);
        return this;
    }

    public AccountPage clickMyAccount() {
        click(By.xpath("//*[contains(text(),'My Account')]"));
        pause(3000);
        return new AccountPage(wd);
    }

    public boolean isUserMenuDisplayed() {
        return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='handle-button']")
                ))
                .isDisplayed();
    }
}