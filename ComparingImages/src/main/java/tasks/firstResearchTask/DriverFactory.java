package tasks.firstResearchTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Duration duration;

    public static WebDriver getChromeDriver() {
        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\SelfStudy\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }


    public static WebDriverWait getWebDriverWait() {
        if (wait == null) {
            duration = Duration.ofSeconds(5);
            wait = new WebDriverWait(driver, duration);
        }
        return wait;
    }
}