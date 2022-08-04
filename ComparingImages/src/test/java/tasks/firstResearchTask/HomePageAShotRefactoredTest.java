package tasks.firstResearchTask;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePageAShotRefactored;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

// damit das funktioniert, muss ich die validatingCapturedScreenshotUsingAShot auskommentierte Methode verwenden
public class HomePageAShotRefactoredTest extends BaseTestClass{

    private HomePageAShotRefactored AShotRefactored = new HomePageAShotRefactored();
    private BufferedImage masterImage;
    private URL urlString;
    private WebElement elementToCapture;

    @Test
    public void screenshotImageAndValidateItUsingAShotRefactored(){

        try {
            masterImage=AShotRefactored.getTheMasterImage();
            elementToCapture = AShotRefactored.locateTheElementToScreenshot();

            Assert.assertTrue(AShotRefactored.validatingCapturedScreenshotUsingAShot(masterImage, elementToCapture));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
