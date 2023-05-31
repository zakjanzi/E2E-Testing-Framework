package bankTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BillPay {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        // TO do: Use external data for the bill payment info (fixtures)
        String amount = "5007";
        String accountNumber = "9687";

        // Test cases:
        // Amount existing: > or < or == Amount sent (include ranges)
        // Amount sent: 0 or negative number
        // Account number: send to non-existent account (use letters & special characters in account number)
        // Account number: send to your own account

        // Login before proceeding
        Login.performLogin(driver, "anotherusername88888", "anotherpassword88888");

        //Go to home page then to Bill Pay section
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.cssSelector("a[href='/parabank/billpay.htm']")).click();

        // Fill out the form
        driver.findElement(By.name("payee.name")).sendKeys("somename");
        driver.findElement(By.name("payee.address.street")).sendKeys("some address");
        driver.findElement(By.name("payee.address.city")).sendKeys("some city");
        driver.findElement(By.name("payee.address.state")).sendKeys("some state");
        driver.findElement(By.name("payee.address.zipCode")).sendKeys("84956");
        driver.findElement(By.name("payee.phoneNumber")).sendKeys("65493");
        driver.findElement(By.name("payee.accountNumber")).sendKeys(accountNumber);
        driver.findElement(By.name("verifyAccount")).sendKeys(accountNumber);
        driver.findElement(By.name("amount")).sendKeys(amount);
        // Drop down menu (+ a short wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fromAccountId")));
        Select dropdownFrom = new Select(dropdownElement);


        // Check the number of options in the dropdown
        if (dropdownFrom.getOptions().size() > 1) {
            // Select option 2
            dropdownFrom.selectByIndex(1);
        } else {
            // Select option 1 if only one option exists
            dropdownFrom.selectByIndex(0);
        }


        driver.findElement(By.cssSelector("input[value='Send Payment']")).click();


        // Wait for the success message to be visible
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bill Payment Complete']")));

        // Get success message
        String actualMessage = messageElement.getText();
        String expectedMessage = "Bill Payment Complete";

        // Assert
        Assert.assertEquals(expectedMessage, actualMessage);

        // Check if the assertion is correct
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Bill Pay test successful");
        } else {
            System.out.println("Bill Pay test failed");
        }





    }
}

