package tasks.firstResearchTask;

import org.junit.Assert;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePageSikuli;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HomePageSikuliTest extends BaseTestClass {
    // only absolute paths work -dont know why
    private HomePageSikuli homePageSikuli = new HomePageSikuli();
    private Path masterImagePath = Paths.get("C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\ResearchTasks\\FirstTask\\ComparingImages\\screenshots\\magazin.png");
    private Path wrongImage = Paths.get("C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\ResearchTasks\\FirstTask\\ComparingImages\\screenshots\\magazinWrongImage.png");

    @Test
    public void screenshotImageAndValidateItUsingSikuli() throws IOException {
        Assert.assertTrue(homePageSikuli.validatingCapturedScreenshotUsingSikuli(masterImagePath));
    }

    @Test
    public void screenshotImageAndValidateItUsingSikuliFailedTest() throws IOException {
        Assert.assertFalse(homePageSikuli.validatingCapturedScreenshotUsingSikuli(wrongImage));
    }
}
