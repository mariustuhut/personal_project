package listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners.TestNGListeners.class)

public class TestNGListenerDemo {
    WebDriver driver = null;

    @Test
    public void test1() {
        System.out.println("Inside Test 1");
    }
    @Test
    public void test2() {
        System.out.println("Inside Test 2");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();
        driver.findElement(By.id("abc"));
    }
    @Test
    public void test3() {
        System.out.println("Inside Test 3");
//        Assert.assertTrue(false);
    }

}
