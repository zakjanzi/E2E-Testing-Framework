package bankTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Login before proceeding with other tests
        Login.performLogin(driver, "someusername7", "somepassword2");

        // Go to the "Transfer Funds" section
        driver.findElement(By.cssSelector("a[href='/parabank/transfer.htm']")).click();

        System.out.println("waiting");
        Thread.sleep(2000);

        // Select amount
        driver.findElement(By.id("amount")).sendKeys("200");

        // Select accounts from a drop-down menu
        Select dropdownFrom = new Select(driver.findElement(By.id("fromAccountId")));
        // Select the second option
        dropdownFrom.selectByIndex(0);
        Select dropdownTo = new Select(driver.findElement(By.id("toAccountId")));
        // Select the second option
        dropdownTo.selectByIndex(0);
        System.out.println("waiting");
        Thread.sleep(2000);

        // Click "Transfer"
        driver.findElement(By.cssSelector("input[value='Transfer']")).click();

    }
}
