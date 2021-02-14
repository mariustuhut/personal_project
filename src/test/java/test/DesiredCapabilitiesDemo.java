package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

    public static void main(String[] args) {
        WebDriverManager.iedriver().setup();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("ignoreProtectedModeSettings", true);
        WebDriver driver = new InternetExplorerDriver(caps);

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("WTF");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

        driver.close();
        driver.quit();

    }
}
