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

//Validating Images using Sikuli - some dependency issues occur
public class HomePageSikuli {

    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private By picture = By.xpath("//body[1]/div[2]/section[1]/div[1]/ul[1]/li[5]/div[1]/a[1]/picture[1]/img[1]");

    private File takeScreenshotAndReturnAsAFileSikuli() {

        WebElement pictureToValidate = driver.findElement(picture);
        js.executeScript("arguments[0].scrollIntoView();", pictureToValidate);
        File srcImageFile = pictureToValidate.getScreenshotAs(OutputType.FILE);
        File copiedImageFile = new File(".\\screenshots\\magazin.png");

        try {
            FileUtils.copyFile(srcImageFile, copiedImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copiedImageFile;
    }

    public Boolean validatingCapturedScreenshotUsingSikuli(Path masterImagePath) throws IOException {

        Boolean result = null;
        Pattern masterImagePattern = new Pattern(String.valueOf(masterImagePath));

        File screenshotOfTheElement = takeScreenshotAndReturnAsAFileSikuli();
        BufferedImage bufferedImageOfScreenshot = ImageIO.read(screenshotOfTheElement);

        Screen screen = new Screen();
        screen.setAutoWaitTimeout(10000);

        Finder finder = new Finder(screen.capture().getImage());
        finder.find(masterImagePattern);

        if (finder.hasNext()) {
            //Match match = finder.next();
            finder.next();
            // per definition, an iterator can be stepped through only once - it is empty afterwards - it has to be destroyed using finder.destroy()
            result = true;
            finder.destroy();
        } else {
            System.out.println("No match found");
            result = false;
        }

        return result;

    }

}
