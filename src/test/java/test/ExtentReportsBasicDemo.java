package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class ExtentReportsBasicDemo {

    private static WebDriver driver = null;

    public static void main(String[] args) {

//        start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

//        create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

//        creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Google Search Test", "Waterford Achievment");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        test.log(Status.INFO, "Starting Test Case");
        driver.get("https://www.google.com/");
        test.pass("Natigated to google.com");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();

        driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
        test.pass("Results are displayed");

        driver.close();
        driver.quit();
        test.pass("Browser closed");
        test.info("Test Completed");


        ExtentTest test2 = extent.createTest("Google Search Test 2", "Waterford Achievment");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        test2.log(Status.INFO, "Starting Test Case");
        driver.get("https://www.google.com/");
        test2.fail("Natigated to google.com");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();

        driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
        test2.pass("Results are displayed");

        driver.close();
        driver.quit();
        test2.pass("Browser closed");
        test2.info("Test Completed");


        extent.flush();

    }
}
