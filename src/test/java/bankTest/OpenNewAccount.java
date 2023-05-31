package bankTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewAccount {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Login before proceeding
        Login.performLogin(driver, "someusername66", "somepassword66");

        // If login fails, run register with the same credentials as above (usernames reset every hour)

        driver.findElement(By.cssSelector("a[href='/parabank/openaccount.htm']")).click();

        driver.findElement(By.id("type")).click();
        driver.findElement(By.xpath("//option[text()='SAVINGS']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type=submit]")).click();




    }
}
