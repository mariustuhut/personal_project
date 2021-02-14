package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class ExtentReportsDemoWithTestNG {
    WebDriver driver = null;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeTest
    public void setUp(){
        htmlReporter = new ExtentHtmlReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() throws Exception {
        ExtentTest test1 = extent.createTest("Google Search TestNG & Extent Reports", "Waterford Achievment");
        driver.get("https://google.com");
        test1.pass("Navigation complete");

        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();
        test1.pass("Agreed terms and conditions");

        test1.log(Status.INFO, "Status details");
        test1.info("Usage Info");
        test1.addScreenCaptureFromPath("screenshot.png");
    }

    @Test
    public void test2() throws Exception {
        ExtentTest test2 = extent.createTest("Google Search Test", "Waterford Achievment");
        test2.log(Status.INFO, "Status details");
        test2.info("Usage Info");
        test2.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        System.out.println("Success !!!");
    }

    @AfterSuite
    public void tearDown(){
        extent.flush();
    }
}
