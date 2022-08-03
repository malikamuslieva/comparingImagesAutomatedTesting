package tasks.firstResearchTask;

import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePage;

import java.io.IOException;

public class HomePageTest extends BaseTestClass{

    private HomePage homePage = new HomePage();

    @Test
    public void captureScreenshotOfImageTest() throws IOException {
/*        homePage.captureScreenshotOfImage()
                .validatingCapturedScreenshot();*/
        homePage.validatingCapturedScreenshot();
    }


}
