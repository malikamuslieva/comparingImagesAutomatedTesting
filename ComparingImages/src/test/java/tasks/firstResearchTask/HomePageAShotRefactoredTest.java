package tasks.firstResearchTask;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePageAShotRefactored;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class HomePageAShotRefactoredTest extends BaseTestClass{

    private HomePageAShotRefactored AShotRefactored = new HomePageAShotRefactored();
    private BufferedImage masterImage;
    private URL urlString;
    private WebElement elementToCapture;

    @Test
    public void screenshotImageAndValidateItUsingAShotRefactored(){

        try {
            masterImage=AShotRefactored.getTheMasterImage();
            urlString = AShotRefactored.getHomePageURL();
            elementToCapture = AShotRefactored.locateTheElementToScreenshot();

            Assert.assertTrue(AShotRefactored.validatingCapturedScreenshotUsingAShot(masterImage, urlString, elementToCapture));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
