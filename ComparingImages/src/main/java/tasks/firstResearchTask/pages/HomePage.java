package tasks.firstResearchTask.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;

// validating images using AShot
public class HomePage {


    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    private By picture = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");

    // refactor by adding the following method: public HomePage locateAnImage(){}


    public File magazinImageFile() {
        // scroll the image I want to capture a Screenshot of  into view
        WebElement pictureToValidate = driver.findElement(picture);
        js.executeScript("arguments[0].scrollIntoView();", pictureToValidate);

        // wrap it with an if-else statement - take a screenshot and save as a file
        File srcImageFile = pictureToValidate.getScreenshotAs(OutputType.FILE);
        // create new Target location

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

    public Boolean validatingCapturedScreenshotUsingApplitools(){

        return true;
    }
}
