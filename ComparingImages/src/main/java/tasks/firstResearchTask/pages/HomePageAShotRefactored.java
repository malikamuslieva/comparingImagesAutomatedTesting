package tasks.firstResearchTask.pages;

import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;

// alle Parameter mit if-else überprüfen
public class HomePageAShotRefactored {

    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private By picture = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");

    // locate the WebElement to capture a screenshot of
    public WebElement locateTheElementToScreenshot() {
        WebElement elementToCapture = driver.findElement(picture);
        return elementToCapture;
    }

    // load the masterImage into a BufferedImage object and return it
    public BufferedImage getTheMasterImage() {

        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(".\\screenshots\\magazin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedImage;
    }

    // return the url string
    // warum soll URL als einer der Parameter eingegeben werden? - Ich brauche es ja bereits für die Methode die mein WebElement liefert
    public URL getHomePageURL() {
        URL homePage = null;
        try {
            homePage = new URL("https://www.nature.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return homePage;
    }
    /*
     // take 3 parameters from above methods and compare the images
    public Boolean validatingCapturedScreenshotUsingAShot(BufferedImage masterImage, WebElement elementToCapture) throws IOException {

        // scroll the WebElement into view, save it as img file and convert to bufferedImg
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        File screenshotOfTheElementFile = elementToCapture.getScreenshotAs(OutputType.FILE);
        BufferedImage screenshotOfTheElement = ImageIO.read(screenshotOfTheElementFile);

        // compare those two buffered images by using the ImageDiffer class and create an ImageDiff(erence) object to store the difference
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(masterImage, screenshotOfTheElement);

        // if those images have a difference, diff.hasDiff will return true
        if (diff.hasDiff()) {
            return false;
        } else {
            return true;
        }
    }


     */

    // take 3 parameters from above methods and compare the images
    public Boolean validatingCapturedScreenshotUsingAShot(BufferedImage masterImage, WebElement elementToCapture) throws IOException {

        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        File screenshotOfTheElementFile = elementToCapture.getScreenshotAs(OutputType.FILE);
        BufferedImage screenshotOfTheElement = ImageIO.read(screenshotOfTheElementFile);

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(masterImage, screenshotOfTheElement);

        if (diff.hasDiff()) {
            return false;
        } else {
            return true;
        }
    }

}
