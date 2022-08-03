package tasks.firstResearchTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;
import static tasks.firstResearchTask.DriverFactory.getWebDriverWait;

public class BaseTestClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private By acceptCookiesButton = By.cssSelector(".cc-button.cc-button--contrast.cc-banner__button.cc-banner__button-accept");

    @BeforeSuite
    public void startUpBrowser(){
        driver = getChromeDriver();
        driver.manage().window().maximize();
        wait = getWebDriverWait();
    }

    // für jede Methode wird somit die Homepage aufgemacht
    @BeforeMethod()
    public void goToHomePage(){

        driver.get("https://www.nature.com/");
        //driver.manage().deleteAllCookies();  - warum funktioniert das nicht?
        WebElement acceptCookies = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(acceptCookiesButton)));
        acceptCookies.click();
    }

    @AfterSuite(enabled = false)
    public void closeBrowser(){
        driver.close();
    }
}
