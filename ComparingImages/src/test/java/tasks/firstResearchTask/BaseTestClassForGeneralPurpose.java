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

public class BaseTestClassForGeneralPurpose {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public By acceptCookiesButton = By.cssSelector(".cc-button.cc-button--contrast.cc-banner__button.cc-banner__button-accept");

/*    private WebElement rightElementToCapture;
    private WebElement wrongElementToCapture;
    private By rightElement = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");
    private By wrongElement =By.id("q");*/

    @BeforeSuite
    public void startUpBrowser() {
        driver = getChromeDriver();
        driver.manage().window().maximize();
        wait = getWebDriverWait();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
}
