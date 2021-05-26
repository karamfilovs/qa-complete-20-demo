import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.IOP.CodecOperations;

public class LoginPageTest extends BaseTest {
    private final String INVALID_CREDENTIALS_MESSAGE = "Грешно потребителско име или парола. Моля, опитайте отново.";
    private final String BLANK_CREDENTIALS_MESSAGE = "Моля, попълнете вашия email";
    private final String LOGOUT_SUCCESS_MESSAGE = "Вие излязохте от акаунта си.";
    private static final String EMAIL = System.getProperty("email");
    private static final String PASSWORD = System.getProperty("password");
    private static final String COMPANY = System.getProperty("company");


    @Test
    @DisplayName("Can login with valid credentials")
    public void canLoginWithValidCredentials() {
        loginPage.goTo();
        Assertions.assertEquals(COMPANY, loginPage.heading2Text());
        loginPage.enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressLoginButton();
        //Check that the user is logged in
        Assertions.assertEquals(EMAIL, homePage.getUserPanelText());
    }

    @Test
    @DisplayName("Cant login with blank credentials")
    public void cantLoginWithBlankCredentials() {
        loginPage.goTo();
        Assertions.assertEquals(COMPANY, loginPage.heading2Text());
        loginPage.pressLoginButton();
        //Check error message
        Assertions.assertEquals(BLANK_CREDENTIALS_MESSAGE, loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Cant login with invalid email/password")
    public void cantLoginWithInvalidCredentials() {
        loginPage.goTo();
        Assertions.assertEquals(COMPANY, loginPage.heading2Text());
        loginPage.enterEmail(EMAIL)
                .enterPassword("12345678")
                .pressLoginButton();
        //Check error message
        Assertions.assertEquals(INVALID_CREDENTIALS_MESSAGE, loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Can login with valid credentials and logout")
    public void canLoginWithValidCredentialsAndLogOut() {
        loginPage.goTo();
        Assertions.assertEquals(COMPANY, loginPage.heading2Text());
        loginPage.login(EMAIL, PASSWORD);
        //Check that the user is logged in
        Assertions.assertEquals(EMAIL, homePage.getUserPanelText());
        //Logout
        homePage.logout();
        //Check that logout message is correct
        Assertions.assertEquals(LOGOUT_SUCCESS_MESSAGE, loginPage.getOKMsgText());
    }
}
