package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;
    private final String BASE_URL = System.getProperty("url");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void press(By selector, String name){
        System.out.println("Pressing:" + name);
        WebElement element = driver.findElement(selector);
        element.click();
    }

    protected String getText(By selector){
        System.out.println("Retrieving text");
        WebElement element = driver.findElement(selector);
        String text = element.getText().trim();
        System.out.println("Text found:" + text);
        return text;
    }

    protected void type(By selector, String text){
        System.out.println("Typing text:" + text);
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(text);
    }

    protected void navigateTo(String suffix){
        System.out.println("Navigating to:" + BASE_URL + suffix);
        driver.navigate().to(BASE_URL + suffix);
    }

    public String heading1Text(){
        return getText(By.xpath("//h1"));
    }

    public String heading2Text(){
        return getText(By.xpath("//h2"));
    }

    public String getTitle(){
        System.out.println("Retrieving page title");
        return driver.getTitle().trim();
    }

}
