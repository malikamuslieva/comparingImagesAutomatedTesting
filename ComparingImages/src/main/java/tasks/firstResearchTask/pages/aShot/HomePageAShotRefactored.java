package tasks.firstResearchTask.pages.aShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;

public class HomePageAShotRefactored {

    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private By picture = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");


    public WebElement locateTheElementToScreenshot() {
        WebElement elementToCapture = driver.findElement(picture);
        return elementToCapture;
    }


    public BufferedImage getMasterImage() {

        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(".\\screenshots\\masterImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedImage;
    }

    public Boolean validatingCapturedScreenshotUsingAShot(BufferedImage masterImage, WebElement elementToCapture) throws IOException {

        //driver.get(String.valueOf(url)); - if I add an additional param URL url

        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        File screenshotOfTheElementFile = elementToCapture.getScreenshotAs(OutputType.FILE);

        LocalDate today = LocalDate.now();
        File copiedImageFile = new File(".\\screenshots\\actualImage" + today + ".png");
        try {
            FileUtils.copyFile(screenshotOfTheElementFile, copiedImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage screenshotOfTheElement = ImageIO.read(screenshotOfTheElementFile);

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(masterImage, screenshotOfTheElement);

            if (!diff.hasDiff()) {
                return false;
            } else {
                return true;
            }
        }

}
