package lt.techin.stud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
//Locators
    public By clickSignInButton = By.cssSelector("div#_desktop_user_info .hidden-sm-down");
    public By clickCreateAccountButton = By.cssSelector("[data-link-action='display-register-form']");
    public By clickSocialTitleMrButton = By.cssSelector("label:nth-of-type(1) input[name='id_gender']");
    public By clickSocialTitleMrsButton = By.cssSelector("label:nth-of-type(2) input[name='id_gender']");
    public By inputFirstName = By.cssSelector("input#field-firstname");
    public By inputLastName = By.cssSelector("input#field-lastname");
    public By inputEmail = By.cssSelector("input#field-email");
    public By inputPassword = By.cssSelector("input#field-password");
    public By clickShowPasswordButton = By.cssSelector(".input-group-btn [type]");
    public By inputBirthday = By.cssSelector("input#field-birthday");
    public By clickReceiveOffersButton = By.cssSelector("input[name='optin']");
    public By clickAgreeWithTermsButton = By.cssSelector("input[name='psgdpr']");
    public By clickSingUpToNewsletterButton = By.cssSelector("input[name='newsletter']");
    public By clickCustomiseDataPrivacyButton = By.cssSelector("input[name='customer_privacy']");
    public By clickSaveButton = By.cssSelector("button[type='submit']"); // Assuming this is the submit button

    //    Assertion Locators
    public By firstNameErrorMessage = By.cssSelector(".register-form .has-error:nth-of-type(2) .alert-danger");
    public By lastNameErrorMessage = By.cssSelector(".alert-danger");
    public By emailErrorMessage = By.cssSelector("ul > .alert.alert-danger")  ;
    public By passwordErrorMessage = By.cssSelector(".field-password-policy ul > li:nth-of-type(1)");
    public By birthdayErrorMessage = By.cssSelector("div:nth-of-type(6) ul > .alert.alert-danger");
    public By successMessage = By.cssSelector(".hidden-sm-down.logout"); // Update based on actual success message selector
    public By errorMessage = By.cssSelector("button[type='submit']"); // Update based on actual error message selector

    // Methods
    public void setInputFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void setInputLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void setInputBirthday(String birthday) {
        driver.findElement(inputBirthday).sendKeys(birthday);
    }

    public void setClickReceiveOffersButton() {
        WebElement element = driver.findElement(clickReceiveOffersButton);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void setClickSingUpToNewsletterButton() {
        WebElement element = driver.findElement(clickSingUpToNewsletterButton);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void setClickAgreeWithTermsButton() {
        WebElement element = driver.findElement(clickAgreeWithTermsButton);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void setClickCustomiseDataPrivacyButton() {
        WebElement element = driver.findElement(clickCustomiseDataPrivacyButton);
        if (!element.isSelected()) {
            element.click();
        }
    }
    public void selectRandomSocialTitleButton() {
        WebElement mrRadio = driver.findElement(clickSocialTitleMrButton);
        WebElement mrsRadio = driver.findElement(clickSocialTitleMrsButton);

        Random rand = new Random();
        if (rand.nextBoolean()) {
            mrRadio.click();
        } else {
            mrsRadio.click();
        }
    }

    public String generateRandomFirstName() {
        String[] firstNames = {"John", "Jane", "Robert", "Emily", "Michael", "Sarah"};
        return firstNames[(int) (Math.random() * firstNames.length)];
    }

    public String generateRandomLastName() {
        String[] lastNames = {"Smith", "Doe", "Brown", "Johnson", "Williams", "Jones"};
        return lastNames[(int) (Math.random() * lastNames.length)];
    }

    public String generateRandomEmail() {
        String[] domains = {"example.com", "test.com", "sample.com"};
        String randomEmail = "user" + (int) (Math.random() * 1000) + "@" + domains[(int) (Math.random() * domains.length)];
        return randomEmail;
    }

    public String generateRandomPassword() {
        // Example of generating a random password
        return "StrongPassword" + (int) (Math.random() * 10000) + "!";
    }

    public String generateRandomBirthday() {
        int year = (int) (Math.random() * (2000 - 1950 + 1) + 1950);
        int month = (int) (Math.random() * 12 + 1);
        int day = (int) (Math.random() * 28 + 1);
        return String.format("%02d/%02d/%d", month, day, year);
    }
}

