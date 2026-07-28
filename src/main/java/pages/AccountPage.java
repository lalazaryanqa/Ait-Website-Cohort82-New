package pages;

import manager.HelperBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class AccountPage extends HelperBase {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickProfile() {
        click(By.linkText("Profile"));
        pause(3000);
        return this;
    }

    public AccountPage fillAbout(String text) {

        WebElement visibleAboutBlock = wd.findElement(
                By.xpath("//div[contains(@class,'sS2e7y_') and not(contains(@class,'oJGYZQN--hidden'))]")
        );

        visibleAboutBlock.click();

        WebElement aboutEditor = wd.findElement(
                By.cssSelector("div[contenteditable='true'][aria-label='About']")
        );

        aboutEditor.click();
        aboutEditor.sendKeys(text);
        pause(3000);

        return this;
    }


//    public AccountPage clickSave() {
//        click(By.xpath("//button[.//div[normalize-space()='Save']]"));
//        return this;
//    }

    public AccountPage clickEditProfile() {
        click(By.cssSelector("[data-hook='Profile-EditProfileButton']"));
        pause(3000);
        return this;
    }

    public AccountPage fillTitle(String title) {
        type(By.id("title-id"), title);
        pause(3000);
        return this;
    }

    public AccountPage fillFirstName(String firstName) {
        type(By.cssSelector("input[data-hook='MyAccount-textField'][name='fields.2.value']"), firstName);
        pause(3000);
        return this;
    }

    public AccountPage fillLastName(String lastName) {
        type(By.cssSelector("input[data-hook='MyAccount-textField'][name='fields.3.value']"), lastName);
        pause(3000);
        return this;
    }

    public AccountPage fillPhone(String phone) {
        type(By.cssSelector("input[data-hook='MyAccount-textField'][name='fields.4.value']"), phone);
        pause(3000);
        return this;
    }

    public AccountPage uploadProfileImage(String imagePath) {
        wd.findElement(By.cssSelector("input[type='file'][name='member.profile.photo']")
        ).sendKeys(imagePath);
        pause(3000);
        return this;
    }
    public AccountPage scrollToVisibilityAndPrivacy() {
        Actions actions = new Actions(wd);
        actions.scrollByAmount(0, 1100).perform();
        pause(3000);
        return this;
    }
    public AccountPage openProfileUrlSection() {
        click(By.cssSelector("[data-hook='accordion-item-header']"));
        pause(3000);
        return this;
    }

    public AccountPage openProfilePrivacy() {
        click(By.xpath("(//*[@data-hook='accordion-item-header'])[2]"));
        pause(3000);
        return this;
    }

    public AccountPage openBlockedMembers() {
        click(By.xpath("(//*[@data-hook='accordion-item-header'])[3]"));
        pause(3000);
        return this;
    }

    public AccountPage scrollUp() {
        new Actions(wd)
                .scrollByAmount(0, -1500)
                .perform();
        pause(3000);
        return this;
    }

    public AccountPage clickMyGroups() {
        click(By.linkText("My Groups"));
        pause(3000);
        return this;
    }
    public AccountPage clickAccountMenuItems() {

        String myGroupsUrl = wd.getCurrentUrl();

        clickMenuItemAndReturn("My Programs", myGroupsUrl);

        clickMenuItemAndReturn("My Homeworks", myGroupsUrl);

        clickMenuItemAndReturn("Files", myGroupsUrl);

        clickMenuItemAndReturn("Program List", myGroupsUrl);

        clickMenuItemAndReturn("Notifications", myGroupsUrl);

        clickMenuItemAndReturn("My Wallet", myGroupsUrl);

        clickMenuItemAndReturn("My Subscriptions", myGroupsUrl);

        return this;
    }

    private void clickMenuItemAndReturn(
            String linkText,
            String myGroupsUrl
    ) {
        click(By.linkText(linkText));
        pause(5000);

        wd.get(myGroupsUrl);
        pause(5000);
    }

    public AccountPage clickUserMenu() {
        click(By.cssSelector("[data-testid='handle-button']"));
        pause(5000);
        return this;
    }

    public AccountPage clickLogout() {

        List<WebElement> logoutButtons = wd.findElements(
                By.xpath("//div[@role='menuitem' and @data-testid='link']" +
                        "[.//span[normalize-space()='Log Out']]")
        );

        for (WebElement logoutButton : logoutButtons) {
            if (logoutButton.isDisplayed()) {
                ((JavascriptExecutor) wd)
                        .executeScript("arguments[0].click();", logoutButton);
                pause(5000);
                return this;
            }
        }

        throw new RuntimeException("");
    }

    public AccountPage logout() {
        pause(1000);
        clickUserMenu();
        pause(1000);
        clickLogout();
        return this;
    }


}
