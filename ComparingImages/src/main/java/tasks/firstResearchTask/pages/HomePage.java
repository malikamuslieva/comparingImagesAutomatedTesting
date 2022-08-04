package tasks.firstResearchTask.pages;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;
import com.applitools.eyes.images.Target;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;

// validating images using AShot, Applitools and Sikuli
public class HomePage {


    private String APIKeyForApplitools = "SRzr54R78ihRyHhZI99sV70kfOdk7wtddTdCYqVU3Aec110";
    private Eyes eyes = new Eyes();


    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    private By picture = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");


    public File magazinImageFile() {
        // scroll the image I want to capture a Screenshot of  into view
        WebElement pictureToValidate = driver.findElement(picture);
        js.executeScript("arguments[0].scrollIntoView();", pictureToValidate);

        // wrap it with an if-else statement - take a screenshot and save as a file
        File srcImageFile = pictureToValidate.getScreenshotAs(OutputType.FILE);

        return srcImageFile;

    }

    public HomePage captureScreenshotOfImage() throws IOException {

        File srcImageFile = magazinImageFile();
        File target = new File(".\\screenshots\\magazin.png");
        //copy the screenshot to my target location
        FileUtils.copyFile(srcImageFile, target);
        return this;
    }


    public Boolean validatingCapturedScreenshotUsingAShot() throws IOException {

        // read the expected image and save in the BufferedImage object
        BufferedImage expectedImage = ImageIO.read(new File(".\\screenshots\\magazin.png"));

        // to make the test fail replace the image magazinSecondScreenshot.png

        // now take screenshot of the current Image
        File srcImageFile = magazinImageFile();
        BufferedImage actualImage = ImageIO.read(srcImageFile);

        // compare those two images
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

        // if those images have a difference
        if (diff.hasDiff()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean validatingCapturedScreenshotUsingApplitools() {
        // if-else statement missing: if eyes.check(true) then true else false

        eyes.setHostOS("Windows 11");
        //eyes.setHostApp("HomePageTest");
        eyes.setApiKey(APIKeyForApplitools);

        try {
            // the name of the class my test is in, the name of the test method, and size I want the screenshot to have
            //eyes.open("HomePageTest", "screenshotImageAndValidateItUsingApplitools", new RectangleSize(800, 600));

            eyes.open("HomePage", "validatingCapturedScreenshotUsingApplitools", new RectangleSize(800, 600));
            BufferedImage expectedImage = ImageIO.read(new File(".\\screenshots\\magazin.png"));

            // https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
            // no scrollingIntoView required - to make the test replace the image magazinSecondScreenshot.png
            eyes.check("Image buffer", Target.image(expectedImage));

            eyes.close();
            return true;

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public Boolean validatingCapturedScreenshotUsingSikuli() {
        // if-else statement missing

/*
        sollte so einfach sein, wie unten beschrieben:

        Screen screen = new Screen();
        //set a timeout for waiting for the image
        screen.setAutoWaitTimeout(30000); //default is 10 seconds
        //wait for an image to get displayed on the screen and then click on it
        screen.wait(new Pattern("img/image.PNG")).click();
        //wait for an image with exact match
        screen.wait(new Pattern("img/image.PNG").exact()).click();*/


        return true;
    }
}
