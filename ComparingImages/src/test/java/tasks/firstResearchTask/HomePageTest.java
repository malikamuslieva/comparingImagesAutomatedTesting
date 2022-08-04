package tasks.firstResearchTask;

import org.junit.Assert;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePage;

import java.io.IOException;

public class HomePageTest extends BaseTestClass {

    private HomePage homePage = new HomePage();

    @Test
    public void screenshotImageAndValidateItUsingAShot() {
        try {
            Assert.assertNotNull(homePage.captureScreenshotOfImage());
            Assert.assertTrue(homePage.validatingCapturedScreenshotUsingAShot());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
/*
        homePage.captureScreenshotOfImage()
                .validatingCapturedScreenshot();
*/
    }

    @Test
    public void screenshotImageAndValidateItUsingApplitools() {

        try {
            Assert.assertNotNull(homePage.captureScreenshotOfImage());
            Assert.assertTrue(homePage.validatingCapturedScreenshotUsingApplitools());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
