import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony.hildebrand on 5/18/16.
 */
public final class Driver {

    //Creates a static instance of the WebDriver
    public static WebDriver instance;

    //Not sure if a public constructor is needed - will test later
    public Driver() {
        Driver.getInstance();
        driverWait(10);
    }

    //Creates a Firefox instance of WebDriver and creates a 10 second implicit wait
    public static void getInstance() {
        instance = new FirefoxDriver();
        driverWait(10);
    }

    //Closes the instance - should refactor to have cookies cleared and user logged out
    public static void close() {
        if (instance != null) {
            instance.close();
        }
    }

    //Logs the user out of the website
    public static void logout() {
        instance.findElement(By.linkText("logout")).click();
    }

    //Deletes cookies
    public static void deleteCookies() {
        instance.manage().deleteAllCookies();
    }

    //Deletes named cookies
    public static void deleteNamedCookies(String cookieName) {
        instance.manage().deleteCookieNamed(cookieName);
    }

    //Creates an implicit wait which you can specify how long in seconds
    public static void driverWait(int seconds) {
        instance.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
