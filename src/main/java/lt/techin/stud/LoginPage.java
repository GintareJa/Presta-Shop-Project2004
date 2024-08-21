package lt.techin.stud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By navigateToLoginPage= By.cssSelector("div#_desktop_user_info .hidden-sm-down");
    public By inputEmail = By.cssSelector("input#field-email");
    public By inputPassword = By.cssSelector("input#field-password");
    public By clickSignInButton = By.cssSelector("button#submit-login");
    public By clickForgotPasswordButton = By.cssSelector("form#login-form a[rel='nofollow']");
    public By clickShowPasswordButton = By.cssSelector(".input-group-btn [type]");

    // Assertion locators
    public By inputEmailError = By.cssSelector("ul > .alert.alert-danger");
    public By inputPasswordError = By.cssSelector("ul > .alert.alert-danger");
    public By assertionMessage = By.cssSelector(".alert.alert-danger");

    // Methods
    public void setNavigateToLoginPage(){
        driver.findElement(navigateToLoginPage).click();
    }
    public void setInputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void setClickSignInButton(){
        driver.findElement(clickSignInButton).click();
    }
//assertion methods

    public boolean isEmailErrorMessagePresent() {
        return driver.findElement(inputEmailError).isDisplayed();
    }

    public boolean isPasswordErrorMessagePresent() {
        return driver.findElement(inputPasswordError).isDisplayed();
    }
    public boolean isAssertionMessagePresent() {
        return driver.findElement(assertionMessage).isDisplayed();
    }
}
