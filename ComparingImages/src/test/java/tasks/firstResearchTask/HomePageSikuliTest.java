package tasks.firstResearchTask;

import org.junit.Assert;
import org.testng.annotations.Test;
import tasks.firstResearchTask.pages.HomePageSikuli;

import java.nio.file.Path;
import java.nio.file.Paths;

public class HomePageSikuliTest extends BaseTestClass{

    private HomePageSikuli homePageSikuli = new HomePageSikuli();
    private Path masterImagePath = Paths.get(".\\screenshots\\magazin.png");

    @Test
    public void screenshotImageAndValidateItUsingSikuli() {
        Assert.assertTrue(homePageSikuli.validatingCapturedScreenshotUsingSikuli(masterImagePath));
    }
}
