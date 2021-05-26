package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By userPanelSelector = By.cssSelector("div.userpanel-header");
    private By logoutLinkSelector = By.xpath("//a[@class='selenium-button-logout button-logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserPanelText(){
        return getText(userPanelSelector);
    }

    public HomePage logout(){
        press(userPanelSelector, "user panel div");
        press(logoutLinkSelector, "logout link");
        return this;
    }
}
