package lt.techin.stud;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        super.setUp();
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Register with valid credentials")
    public void registerWithRandomValidCredentials() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.selectRandomSocialTitleButton();
        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.successMessage));
        assertTrue(driver.findElement(registerPage.successMessage).isDisplayed(), "Success message should be displayed");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Social Title Button test")
    public void socialTitleButtonTest() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();
        registerPage.selectRandomSocialTitleButton();

        assertTrue(driver.findElement(registerPage.clickSocialTitleMrButton).isSelected() ||
                driver.findElement(registerPage.clickSocialTitleMrsButton).isSelected(), "One of the social title buttons should be selected");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with invalid First Name")
    public void registerWithInvalidFirstName() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setInputFirstName("4");
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.firstNameErrorMessage).isDisplayed(), "Error message should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with invalid Last Name")
    public void registerWithInvalidLastName() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName("4");
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.lastNameErrorMessage).isDisplayed(), "Error message should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with invalid Email")
    public void registerWithInvalidEmail() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail("invalid@email");
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.emailErrorMessage).isDisplayed(), "Error message should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with invalid Password")
    public void registerWithInvalidPassword() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword("password");
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.passwordErrorMessage).isDisplayed(), "Error message should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with invalid Birthday")
    public void registerWithInvalidBirthday() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday("11/11/11");
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.birthdayErrorMessage).isDisplayed(), "Error message should be displayed");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Show password Button test")
    public void showPasswordButtonTest() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        WebElement passwordField = driver.findElement(registerPage.inputPassword);
        WebElement showPasswordButton = driver.findElement(registerPage.clickShowPasswordButton);
        showPasswordButton.click();

        // Check if the password is visible
        assertTrue(passwordField.getAttribute("type").equals("text"), "Password should be visible after clicking the Show Password button");

        // Click again to hide password
        showPasswordButton.click();
        assertTrue(passwordField.getAttribute("type").equals("password"), "Password should be hidden after clicking the Show Password button again");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Receive offers Button test")
    public void receiveOffersButtonTest() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setClickReceiveOffersButton();

        WebElement element = driver.findElement(registerPage.clickReceiveOffersButton);
        assertTrue(element.isSelected(), "'Receive offers' checkbox should be selected");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Agree with Terms Button Test")
    public void agreeWithTermsButtonTest() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setClickAgreeWithTermsButton();

        WebElement element = driver.findElement(registerPage.clickAgreeWithTermsButton);
        assertTrue(element.isSelected(), "'Agree with Terms' checkbox should be selected");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Sign Up for Newsletter Button test")
    public void signUpForNewsletterButtonTest() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setClickSingUpToNewsletterButton();

        WebElement element = driver.findElement(registerPage.clickSingUpToNewsletterButton);
        assertTrue(element.isSelected(), "'Sign Up for Newsletter' checkbox should be selected");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Customize Data Privacy Button test")
    public void customizeDataPrivacyButtonTest() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.setClickCustomiseDataPrivacyButton();

        WebElement element = driver.findElement(registerPage.clickCustomiseDataPrivacyButton);
        assertTrue(element.isSelected(), "'Customize Data Privacy' checkbox should be selected");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with empty credentials")
    public void registerWithEmptyCredentials() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.selectRandomSocialTitleButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.errorMessage).isDisplayed(), "Error message should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with too long First Name")
    public void registerWithTooLongFirstName() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.selectRandomSocialTitleButton();
        registerPage.setInputFirstName("A".repeat(256)); // Too long first name
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.firstNameErrorMessage).isDisplayed(), "Error message for first name should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with too long Last Name")
    public void registerWithTooLongLastName() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.selectRandomSocialTitleButton();
        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName("B".repeat(256)); // Too long last name
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());
        registerPage.setClickReceiveOffersButton();
        registerPage.setClickSingUpToNewsletterButton();
        registerPage.setClickAgreeWithTermsButton();
        registerPage.setClickCustomiseDataPrivacyButton();
        driver.findElement(registerPage.clickSaveButton).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.lastNameErrorMessage).isDisplayed(), "Error message for last name should be displayed");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with missing required checkboxes")
    public void registerWithMissingRequiredCheckboxes() {
        driver.findElement(registerPage.clickSignInButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.clickCreateAccountButton)).click();

        registerPage.selectRandomSocialTitleButton();
        registerPage.setInputFirstName(registerPage.generateRandomFirstName());
        registerPage.setInputLastName(registerPage.generateRandomLastName());
        registerPage.setInputEmail(registerPage.generateRandomEmail());
        registerPage.setInputPassword(registerPage.generateRandomPassword());
        registerPage.setInputBirthday(registerPage.generateRandomBirthday());

        driver.findElement(registerPage.clickSaveButton).click();

      
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorMessage));
        assertTrue(driver.findElement(registerPage.errorMessage).isDisplayed(), "Error message for missing checkboxes should be displayed");
    }

}
