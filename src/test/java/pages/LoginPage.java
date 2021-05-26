package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailFieldSelector = By.id("loginusername");
    private By passwordFieldSelector = By.id("loginpassword");
    private By loginButtonSelector = By.id("loginsubmit");
    private By okMsgSelector = By.id("okmsg");
    private By errorMessageSelector = By.xpath("//div[@class='selenium-error-block']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage enterEmail(String email){
        type(emailFieldSelector, email);
        return this;
    }

    public LoginPage enterPassword (String password){
        type(passwordFieldSelector, password);
        return this;

    }

    public LoginPage pressLoginButton(){
        press(loginButtonSelector, "login button");
        return this;
    }

    public void login(String email, String password){
       goTo().enterEmail(email)
               .enterPassword(password)
               .pressLoginButton();
    }

    public String getOKMsgText(){
        return getText(okMsgSelector);
    }

    public String getErrorMessage(){
        return getText(errorMessageSelector);
    }

    public LoginPage goTo(){
        navigateTo("/login");
        return this;
    }

}
