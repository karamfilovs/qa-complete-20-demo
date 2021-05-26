import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClientPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ClientPage clientPage;

    @BeforeAll
    public static void beforeAll() {
        //Executes before all tests
        //This downloads chrome driver and configures the env variable
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        //Executes before every test
        driver = new ChromeDriver(); //Creates new browser instance
        driver.manage().window().maximize(); //Maximizes browser
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS); //Implicit wait of 3 secs
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        clientPage = new ClientPage(driver);
    }

    @AfterEach
    public void afterEach() {
        driver.quit(); //Quits browser instance
    }
}
