package tasks.firstResearchTask;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static tasks.firstResearchTask.DriverFactory.getChromeDriver;

public class ComparingScreenshotAndMasterImageAshot {

    private WebDriver driver = getChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;


    public Boolean capturingScreenshotAndComparingItWithMasterImage(File masterImage, WebElement elementToCapture) throws IOException {

        // converting the file masterimage to bufferedImage
        BufferedImage expectedImage = null;
        // simpleFormat Class nachschauen
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
        LocalDate today = LocalDate.now();
        String todayFormatted = formatter.format(Date.valueOf(today));

        Boolean result = null;

        try {
            expectedImage = ImageIO.read(masterImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // locating the element und capturing a screenshot
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        File actualImageScreenshotFile = elementToCapture.getScreenshotAs(OutputType.FILE);
        BufferedImage actualImageScreenshot = ImageIO.read(actualImageScreenshotFile);

        // saving the screenshot
        File copiedImageFile = new File(".\\screenshots\\testResults\\actualImage" + todayFormatted + ".png");
        try {
            FileUtils.copyFile(actualImageScreenshotFile, copiedImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImageScreenshot);

        if (diff.hasDiff()) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}
