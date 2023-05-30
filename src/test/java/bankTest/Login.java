package bankTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    public static void performLogin(WebDriver driver, String username, String password) {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("someusername");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("somepassword");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Perform the login
        performLogin(driver, "randomuser", "randompass");

        // Go to Home page
        driver.findElement(By.cssSelector("a[href='/parabank/index.htm']")).click();


        // Wait for the message element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));

        // Get the text of the message
        String actualMessage = messageElement.getText();
        String expectedMessage = "Your account was created successfully. You are now logged in.";

        // Assert the message
        Assert.assertEquals(expectedMessage, actualMessage);

        // Close the browser
        driver.quit();


    }
}




