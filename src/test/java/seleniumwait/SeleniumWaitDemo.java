package seleniumwait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWaitDemo {
    private static WebDriver driver = null;

    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public static void seleniumWaits() {

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.ro/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();

        driver.findElement(By.name("q")).sendKeys("Hey Mofo", Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("abc")));
        driver.findElement(By.name("abc")).click();
    }
    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        System.out.println("Success !!!");
    }
}
