package lt.techin.stud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class TestDataGenerator extends BasePage {
    private RegisterPage registerPage;

    public TestDataGenerator(WebDriver driver) {
        super(driver);
    }
    public By clickSocialTitleMrButton = By.cssSelector("label:nth-of-type(1) input[name='id_gender']");
    public By clickSocialTitleMrsButton = By.cssSelector("label:nth-of-type(2) input[name='id_gender']");
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
