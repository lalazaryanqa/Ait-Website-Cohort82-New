package pages;

import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class AccountPage extends HelperBase {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickProfile() {
        click(By.linkText("Profile"));
        return this;
    }

    public AccountPage fillAbout(String text) {

        WebElement visibleAboutBlock = wd.findElement(
                By.xpath("//div[contains(@class,'sS2e7y_') " +
                        "and not(contains(@class,'oJGYZQN--hidden'))]")
        );

        visibleAboutBlock.click();

        WebElement aboutEditor = wd.findElement(
                By.cssSelector("div[contenteditable='true'][aria-label='About']")
        );

        aboutEditor.click();
        aboutEditor.sendKeys(text);

        return this;
    }


//    public AccountPage clickSave() {
//        click(By.xpath("//button[.//div[normalize-space()='Save']]"));
//        return this;
//    }

    public AccountPage clickEditProfile() {
        click(By.cssSelector("[data-hook='Profile-EditProfileButton']"));
        return this;
    }

    public AccountPage fillTitle(String title) {
        type(By.id("title-id"), title);
        return this;
    }

    public AccountPage fillFirstName(String firstName) {
        type(By.cssSelector("input[data-hook='MyAccount-textField'][name='fields.2.value']"), firstName);
        return this;
    }

    public AccountPage fillLastName(String lastName) {
        type(By.cssSelector("input[data-hook='MyAccount-textField'][name='fields.3.value']"), lastName);
        return this;
    }

    public AccountPage fillPhone(String phone) {
        type(By.cssSelector("input[data-hook='MyAccount-textField'][name='fields.4.value']"), phone);
        return this;
    }

    public AccountPage uploadProfileImage(String imagePath) {
        wd.findElement(By.cssSelector("input[type='file'][name='member.profile.photo']")
        ).sendKeys(imagePath);
        return this;
    }
    public AccountPage scrollToVisibilityAndPrivacy() {
        Actions actions = new Actions(wd);
        actions.scrollByAmount(0, 1100).perform();
        return this;
    }
    public AccountPage openProfileUrlSection() {
        click(By.cssSelector("[data-hook='accordion-item-header']"));
        return this;
    }

    public AccountPage openProfilePrivacy() {
        click(By.xpath("(//*[@data-hook='accordion-item-header'])[2]"));
        return this;
    }

    public AccountPage openBlockedMembers() {
        click(By.xpath("(//*[@data-hook='accordion-item-header'])[3]"));
        return this;
    }

    public AccountPage scrollUp() {
        new Actions(wd)
                .scrollByAmount(0, -1500)
                .perform();
        return this;
    }

    public AccountPage clickMyGroups() {
        click(By.linkText("My Groups"));
        return this;
    }


}
