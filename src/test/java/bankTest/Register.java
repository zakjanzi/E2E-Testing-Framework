package bankTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Register {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

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
        driver.findElement(By.id("customer.username")).sendKeys("someusername");
        driver.findElement(By.id("customer.password")).sendKeys("somepassword");
        driver.findElement(By.id("repeatedPassword")).sendKeys("somepassword");

        driver.findElement(By.cssSelector("input[value='Register']")).click();


        // Assert the message





    }
}
