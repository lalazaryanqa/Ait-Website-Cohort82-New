package pages;

import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}