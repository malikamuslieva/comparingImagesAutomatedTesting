package tasks.firstResearchTask;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ComparingScreenshotAndMasterImageAShotTest extends BaseTestClassForGeneralPurpose {

    private ComparingScreenshotAndMasterImageAshot compare = new ComparingScreenshotAndMasterImageAshot();
    private File masterImage = new File("C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\ResearchTasks\\FirstTask\\ComparingImages\\screenshots\\masterImage.png");
    private File wrongImage = new File("C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\ResearchTasks\\FirstTask\\ComparingImages\\screenshots\\wrongMasterImage.png");
    private WebElement rightElementToCapture;
    private WebElement wrongElementToCapture;
    private By rightElement = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");
    private By wrongElement =By.id("featured-content");

    @BeforeMethod
    private void setUp(){

        driver.get("https://www.nature.com/");
        //driver.manage().deleteAllCookies();  - warum funktioniert das nicht?
        WebElement acceptCookies = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(acceptCookiesButton)));
        acceptCookies.click();

        rightElementToCapture = driver.findElement(rightElement);
        wrongElementToCapture = driver.findElement(wrongElement);

    }

    @Test
    public void capturingScreenshotAndComparingItWithMasterImageValidTest() throws IOException {
        Assert.assertTrue(compare.capturingScreenshotAndComparingItWithMasterImage(masterImage, rightElementToCapture));
    }

    @Test
    public void capturingScreenshotAndComparingItWithMasterImageInvalidTest() throws IOException {
        Assert.assertFalse(compare.capturingScreenshotAndComparingItWithMasterImage(wrongImage, wrongElementToCapture));
    }
}
