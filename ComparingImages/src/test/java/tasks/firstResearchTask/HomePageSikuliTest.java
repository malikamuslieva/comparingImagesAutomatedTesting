package tasks.firstResearchTask;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class HomePageSikuliTest extends BaseTestClass {

    private researchtasks.taskone.HomePageSikuli homePageSikuli = new researchtasks.taskone.HomePageSikuli();
    private Path masterImagePath = Paths.get("C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\ResearchTasks\\FirstTask\\ComparingImages\\screenshots\\magazin.png");
    private Path wrongImage = Paths.get("C:\\Users\\malika.muslieva\\OneDrive - Accenture\\Desktop\\TestAutomation\\ResearchTasks\\FirstTask\\ComparingImages\\screenshots\\magazinSecondScreenshot.png");

    @Test
    public void screenshotImageAndValidateItUsingSikuli() {
        Assert.assertTrue(homePageSikuli.validatingCapturedScreenshotUsingSikuli(masterImagePath));
    }

    @Test
    public void creenshotImageAndValidateItUsingSikuliFailedTest() {
        Assert.assertFalse(homePageSikuli.validatingCapturedScreenshotUsingSikuli(wrongImage));
    }
}
