package tasks.firstResearchTask.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;

//Validating Images using Sikuli
public class HomePageSikuli {

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
        File copiedImageFile = new File(".\\screenshots\\magazin.png");

        //copy the screenshot to my copiedImageFile location
        try {
            FileUtils.copyFile(srcImageFile, copiedImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copiedImageFile;
    }

    public Boolean validatingCapturedScreenshotUsingSikuli(Path masterImagePath) {
        try {
            Boolean result;
            Pattern masterImagePattern = new Pattern(String.valueOf(masterImagePath));

            File screenshotOfTheElement = takeScreenshotAndReturnAsAFile();
            BufferedImage bufferedImageOfScreenshot = ImageIO.read(screenshotOfTheElement);
            //Pattern screenshotPattern = new Pattern(bufferedImageOfScreenshot);

            Screen screen = new Screen();
            //set a timeout for waiting for the image
            screen.setAutoWaitTimeout(10000);

            Finder finder = new Finder(screen.capture().getImage());
            finder.find(masterImagePattern);

            if(finder.hasNext()){
                Match match = finder.next();
                // per definition, an iterator can be stepped through only once - it is empty afterwards
                //it has to be destroyed using finder.destroy(), especially when used with for: or while:
                //when used in a with: construct, it is destroyed automatically
                finder.destroy();
                result = true;
            }else {
                System.out.println("No match found");
                result = false;
            }

            return result;
            //wait for an image to get displayed on the screen and then click on it - screen.wait(masterImagePattern).click();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
