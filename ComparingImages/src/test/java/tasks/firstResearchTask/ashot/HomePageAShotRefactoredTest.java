package tasks.firstResearchTask.ashot;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tasks.firstResearchTask.BaseTestClass;
import tasks.firstResearchTask.pages.aShot.HomePageAShotRefactored;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class HomePageAShotRefactoredTest extends BaseTestClass {

    private HomePageAShotRefactored ashotRefactored = new HomePageAShotRefactored();
    private BufferedImage masterImage = ashotRefactored.getMasterImage();
    //private URL urlString = new URL("https://www.nature.com/");
    private WebElement elementToCapture = ashotRefactored.locateTheElementToScreenshot();

    @Test
    public void screenshotImageAndValidateItUsingAShotRefactored() throws IOException {
        Assert.assertTrue(ashotRefactored.validatingCapturedScreenshotUsingAShot(masterImage, elementToCapture));

    }
}
