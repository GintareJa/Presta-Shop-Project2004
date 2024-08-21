package lt.techin.stud;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.setNavigateToLoginPage();
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Login with valid credentials")
    public void loginWithValidCredentials() {
        String email = "validUser@mail.com";
        String password = "validPassword123*";
        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();

//       assertFalse(loginPage.isAssertionMessagePresent(), "Yor account Page should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with invalid email")
    public void loginWithInvalidEmail() {
        String email = "invalidEmail@mail.com";
        String password = "validPassword123*";
        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
        assertTrue(loginPage.isAssertionMessagePresent(), "An error message should be displayed for an invalid email.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with invalid password")
    public void loginWithInvalidPassword() {
        String email = "validUser@mail.com";
        String password = "wrongPassword";
        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
        assertTrue(loginPage.isAssertionMessagePresent(), "An error message should be displayed for an invalid password.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with empty credentials")
    public void loginWithEmptyCredentials() {
        loginPage.setClickSignInButton();
//        assertTrue(loginPage.isEmailErrorMessagePresent(), "An error message should be displayed for empty email.");
//        assertTrue(loginPage.isPasswordErrorMessagePresent(), "An error message should be displayed for empty password.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with empty password")
    public void loginWithEmptyPassword() {
        String email = "validUser@mail.com";
        loginPage.setInputEmail(email);
        loginPage.setClickSignInButton();
//        assertTrue(loginPage.isPasswordErrorMessagePresent(), "An error message should be displayed for empty password.");
    }
}
