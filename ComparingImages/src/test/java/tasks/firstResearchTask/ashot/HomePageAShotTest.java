package tasks.firstResearchTask.ashot;

import org.junit.Assert;
import org.testng.annotations.Test;
import tasks.firstResearchTask.BaseTestClass;
import tasks.firstResearchTask.pages.aShot.HomePageAShot;

import java.io.IOException;

public class HomePageAShotTest extends BaseTestClass {

    private HomePageAShot homePage = new HomePageAShot();


    @Test
    public void screenshotImageAndValidateItUsingAShot() {
        try {
            Assert.assertTrue(homePage.validatingCapturedScreenshotUsingAShot());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
/*
        homePage.captureScreenshotOfImage()
                .validatingCapturedScreenshot();
*/
    }
}
