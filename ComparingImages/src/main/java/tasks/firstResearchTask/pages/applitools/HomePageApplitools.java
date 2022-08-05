package tasks.firstResearchTask.pages.applitools;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;
import com.applitools.eyes.images.Target;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/* comparing two images using Applitools

    Applitools können wir aufgrund Datenschutz nicht verwenden.
    Da man hier ein user-account anlegen muss und nur mit dem persönlichen API Key zugang zum Tool hat

    https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
 */


public class HomePageApplitools {


    private String APIKeyForApplitools = "SRzr54R78ihRyHhZI99sV70kfOdk7wtddTdCYqVU3Aec110";
    private Eyes eyes = new Eyes();


    public Boolean validatingCapturedScreenshotUsingApplitools() throws IOException {

        eyes.setHostOS("Windows 11");
        //eyes.setHostApp("HomePageTest");
        eyes.setApiKey(APIKeyForApplitools);

        // the name of the class my test is in, the name of the test method, and size I want the screenshot to have
        //eyes.open("HomePageTest", "screenshotImageAndValidateItUsingApplitools", new RectangleSize(800, 600));

        eyes.open("HomePageApplitools", "validatingCapturedScreenshotUsingApplitools", new RectangleSize(800, 600));
        BufferedImage expectedImage = ImageIO.read(new File(".\\screenshots\\masterImage.png"));

        // no scrollingIntoView required - to make the test replace the image wrongMasterImage.png

        Boolean result = eyes.check("Image buffer", Target.image(expectedImage));

        if (result) {
            eyes.close();
            return true;
        } else {
            return false;
        }
    }
}
