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


public class Register {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        // TO do: Use external data for the sign up information (fixtures)
        String username = "anotherusername88888";
        String password = "anotherpassword88888";


        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("customer.firstName")).sendKeys("somename");
        driver.findElement(By.id("customer.lastName")).sendKeys("somename");
        driver.findElement(By.id("customer.address.street")).sendKeys("some address");
        driver.findElement(By.id("customer.address.city")).sendKeys("some city");
        driver.findElement(By.id("customer.address.state")).sendKeys("some state");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("65493");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("6456894");
        driver.findElement(By.id("customer.ssn")).sendKeys("5646894");
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys(password);
        driver.findElement(By.id("repeatedPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("input[value='Register']")).click();


        // Wait for the success message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));

        // Get success message
        String actualMessage = messageElement.getText();
        String expectedMessage = "Welcome " + username;

        // Assert
        Assert.assertEquals(expectedMessage, actualMessage);

        // Check if the assertion is correct
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Register test successful");
        } else {
            System.out.println("Register failed");
        }





    }
}
