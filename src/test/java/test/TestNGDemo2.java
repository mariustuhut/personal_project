package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.GoogleSearchPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestNGDemo2 {
    private static WebDriver driver = null;

    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
public void googleSearchTest2(){

    GoogleSearchPage searchPageObj = new GoogleSearchPage(driver);
    driver.get("https://google.com");
    driver.manage().window().maximize();
    driver.switchTo().frame(0);
    driver.findElement(By.id("introAgreeButton")).click();

    searchPageObj.sendCharToSearchField("Liverpool F.C");
    searchPageObj.clickSearchButton();
    }

    @AfterTest
public void tearDownTest(){
        driver.close();
        driver.quit();
        System.out.println("Success !!!");
}
}
