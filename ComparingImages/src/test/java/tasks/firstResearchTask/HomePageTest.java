package tasks.firstResearchTask;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;
import com.applitools.eyes.images.Target;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePageTest extends BaseTestClass {

    private HomePage homePage = new HomePage();
    private String APIKeyForApplitools = "SRzr54R78ihRyHhZI99sV70kfOdk7wtddTdCYqVU3Aec110";

    @Test
    public void screenshotImageAndValidateItUsingAShot() {
        try {
            Assert.assertNotNull(homePage.captureScreenshotOfImage());
            Assert.assertTrue(homePage.validatingCapturedScreenshotUsingAShot());
        }catch (IOException ex){
            ex.printStackTrace();
        }
/*
        homePage.captureScreenshotOfImage()
                .validatingCapturedScreenshot();
*/
    }

    @Test
    public void screenshotImageAndValidateItUsingApplitools() {
        // refactor - move to setUp to BeforeTest Method just fo this test
        // move required code to the HomePage Class, just like in the case above
        Eyes eyes = new Eyes();

        eyes.setHostOS("Windows 11");
        eyes.setHostApp("HomePage");
        eyes.setApiKey(APIKeyForApplitools);

        try {
            Assert.assertNotNull(homePage.captureScreenshotOfImage());
            // the name of the class my test is in, the name of the test method, and size I want the screenshot to have
            eyes.open("HomePageTest", "screenshotImageAndValidateItUsingApplitools", new RectangleSize(800, 600));

            // get the saved image-file
            BufferedImage expectedImage = ImageIO.read(new File(".\\screenshots\\magazin.png"));

            // https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
            // https://applitools.com/docs/api-ref/sdk-api/selenium/java/eyes/#check-method

            // no scrollingIntoView required :)
            eyes.check("Image buffer", Target.image(expectedImage));

            // end the visual UI testing
            eyes.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // If the test was aborted before eyes.close was called, ends the test as aborted
            eyes.abortIfNotClosed();
        }

    }
}
