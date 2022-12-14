package tasks.firstResearchTask.pages.aShot;

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
public class HomePageAShot {

    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private By picture = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");

    private File takeScreenshotAndReturnAsAFile() {

        // Locate the WebElement I want to take a screenshot of
        WebElement pictureToValidate = driver.findElement(picture);

        // scroll the WebElement into view
        js.executeScript("arguments[0].scrollIntoView();", pictureToValidate);

        // take a screenshot of the WebElement and save it as the img file
        File srcImageFile = pictureToValidate.getScreenshotAs(OutputType.FILE);

        // create a location to copy the screenshot to
        File copiedImageFile = new File(".\\screenshots\\masterImage.png");

        //copy the screenshot to my copiedImageFile location
        try {
            FileUtils.copyFile(srcImageFile, copiedImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copiedImageFile;
    }


    public Boolean validatingCapturedScreenshotUsingAShot() throws IOException {

        // read the expected image and save in the BufferedImage object
        BufferedImage expectedImage = ImageIO.read(new File(".\\screenshots\\masterImage.png"));

        // to make the test fail replace the image wrongMasterImage.png

        // now take screenshot of the current Image
        File srcImageFile = takeScreenshotAndReturnAsAFile();
        BufferedImage actualImage = ImageIO.read(srcImageFile);

        // compare those two images by using the ImageDiffer class
        ImageDiffer imgDiff = new ImageDiffer();

        // create an ImageDiff(erence) object to store the difference
        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

        // if those images have a difference, diff.hasDiff will return true
        if (diff.hasDiff()) {
            return false;
        } else {
            return true;
        }
    }

}
