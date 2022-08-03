package tasks.firstResearchTask;

/**
 *
 * Selenium does not offer a feature to compare two images
 * Therefore we have to use external libraries.
 *
 * Examples:
 *  1. AShot
 *  2. Applitools
 *  3. sikuli API
 *  4. etc.
 *
 *   solutions from
 *   https://sqa.stackexchange.com/questions/18340/how-to-verify-two-images-using-selenium-webdriver#:~:text=If%20you%20use%20Selenium%2FWebdriver%20with%20Javascript%2C%20there%20are,comparison%20requirement%20you%20might%20have%20in%20the%20browser.
 */
public class App 
{
    public static void main( String[] args )
    {
                /*
        mögliche Probleme: wie kann ich sie vermeiden?
        They have a whole ecosystem around their product. If you do start comparing images you'll begin to realize that different
        browsers will render html in subtly different ways. To a human, two images will look identical, to a computer, however,
        text being rendered might be smoothed with a different algorithm which may result in pixels not matching.
        This is a common problem with image verification from screenshots.
        This problem can also exist within the same browser but for different versions or on different operating systems too.
        This is one of the problems companies have set out to solve.

        example code

        Screen screen = new Screen();
        //set a timeout for waiting for the image
        screen.setAutoWaitTimeout(30000); //default is 10 seconds
        //wait for an image to get displayed on the screen and then click on it
        screen.wait(new Pattern("img/image.PNG")).click();
        //wait for an image with exact match
        screen.wait(new Pattern("img/image.PNG").exact()).click();

         */
    }
}
