package bankTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    public static void performLogin(WebDriver driver, String username, String password) {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);

        driver.findElement(By.cssSelector("input[value='Log In']")).click();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Assign the new username and password values
        String username = "anotherusername88";
        String password = "anotherpassword88";

        // Perform the login with new values
        performLogin(driver, username, password);

        // Go to Home page
        // driver.findElement(By.cssSelector("a[href='/parabank/index.htm']")).click();

        // Wait for the success message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));

        // Get success message
        String actualMessage = messageElement.getText();
        String expectedMessage = "Accounts Overview";

        // If Login test fails, run the Register test
        if (!expectedMessage.equals(actualMessage)) {
            System.out.println("Login test failed (account does not exist). Running Register test...");
            Register.main(args);
        } else {
            System.out.println("Login test passed.");
        }
    }
}
