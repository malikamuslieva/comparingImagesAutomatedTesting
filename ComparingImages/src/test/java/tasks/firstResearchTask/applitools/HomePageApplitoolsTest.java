package tasks.firstResearchTask.applitools;

import org.junit.Assert;
import org.testng.annotations.Test;
import tasks.firstResearchTask.BaseTestClass;
import tasks.firstResearchTask.pages.applitools.HomePageApplitools;

import java.io.IOException;


public class HomePageApplitoolsTest extends BaseTestClass {

   private HomePageApplitools homePageApplitools = new HomePageApplitools();

    @Test
    public void screenshotImageAndValidateItUsingApplitools() {

        try {
            Assert.assertTrue(homePageApplitools.validatingCapturedScreenshotUsingApplitools());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
