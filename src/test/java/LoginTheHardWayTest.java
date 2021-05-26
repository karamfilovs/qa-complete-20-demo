import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTheHardWayTest {
    private WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        //Executes before all tests
        //This downloads chrome driver and configures the env variable
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        //Executes before every test
        driver = new FirefoxDriver(); //Creates new browser instance
        driver.manage().window().maximize(); //Maximizes browser
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS); //Implicit wait of 3 secs
    }

    @AfterEach
    public void afterEach() {
        driver.quit(); //Quits browser instance
    }

    @Test
    @Disabled
    @DisplayName("Can login with valid credentials")
    public void canLoginWithValidCredentials() {
        driver.navigate().to(System.getProperty("url"));
        //Check heading text
        String pageTitle = driver.findElement(By.xpath("//h1")).getText();
        Assertions.assertEquals("Вход в inv.bg", pageTitle);
        //Enter email
        WebElement emailField = driver.findElement(By.id("loginusername")); //Locates email
        emailField.sendKeys("karamfilovs@gmail.com"); //Populates email
        //Enter password
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("123456");
        //Click Login button
        WebElement loginButton = driver.findElement(By.id("loginsubmit"));
        loginButton.click();
        //Check user is logged in
        WebElement userPanel = driver.findElement(By.cssSelector("div.userpanel-header"));
        Assertions.assertEquals("karamfilovs@gmail.com", userPanel.getText());
    }
}
