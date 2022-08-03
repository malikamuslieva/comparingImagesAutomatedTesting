package tasks.firstResearchTask;

import org.junit.Assert;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePage;

import java.io.IOException;

public class HomePageTest extends BaseTestClass {

    private HomePage homePage = new HomePage();

    @Test
    public void screenshotImageAndValidateItUsingAShot() throws IOException {
        Assert.assertNotNull(homePage.captureScreenshotOfImage());
        Assert.assertTrue(homePage.validatingCapturedScreenshotUsingAShot());
/*
        homePage.captureScreenshotOfImage()
                .validatingCapturedScreenshot();
*/
    }

    @Test
    public void screenshotImageAndValidateItUsingApplitools() throws IOException {
        Assert.assertNotNull(homePage.captureScreenshotOfImage());

    }
}
