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

    public HomePage captureScreenshotOfImage() throws IOException {

        // scroll the image I want to capture a Screenshot of  into view
        WebElement pictureToValidate = driver.findElement(picture);
        js.executeScript("arguments[0].scrollIntoView();", pictureToValidate);

        // wrap it with an if-else statement
        // take a screenshot and save as a file
        File src = pictureToValidate.getScreenshotAs(OutputType.FILE);
        // i can refactor by returning the file src
        // create new Target location
        File target = new File(".\\screenshots\\magazin.png");

        //copy the screenshot to my target location
        FileUtils.copyFile(src, target);
        return this;
    }

    public HomePage validatingCapturedScreenshot() throws IOException {

        // read the expected image and save in the BufferedImage object
        BufferedImage expectedImage = ImageIO.read(new File(".\\screenshots\\magazin.png"));

        WebElement pictureToValidate = driver.findElement(picture);
        js.executeScript("arguments[0].scrollIntoView();", pictureToValidate);

        File src = pictureToValidate.getScreenshotAs(OutputType.FILE);
        // create new Target location
        File target = new File(".\\screenshots\\magazinSecondScreenshot.png");
        //copy the screenshot to my target location
        FileUtils.copyFile(src, target);

        // read the actualScreenshot
        BufferedImage actualImage = ImageIO.read(target);

        // compare those two images
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

        // if those images have a difference
        if(diff.hasDiff()){
            System.out.println("Failed! Images are not same!");
        }else {
            System.out.println("Passed. Images are same");
        }
        return this;
    }

}
