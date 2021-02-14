package rerun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGRetryFailedDemo {

    @Test
    public void test1(){
        System.out.println("Inside Test 1");
    }

    @Test(retryAnalyzer = rerun.RetryAnalyzer.class)
    public void test2(){
        System.out.println("Inside Test 2");
        Assert.assertTrue(0 > 1);

    }

    @Test
    public void test3(){
        System.out.println("Inside Test 3");
//        Assert.assertEquals(1, 2);
    }
}
