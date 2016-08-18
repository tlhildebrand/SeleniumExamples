import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class LoginPage {

    //Gets the url
    public static void homepage() {
        Driver.instance.navigate().to("http://www.twinspires.com");
    }

    //Verifies if user successfully logged in
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("TwinSpires.com | Wager Now")) {
            return true;
        } else {
            return false;
        }
    }

    //Logs the user into the website
    public static void login() {
        homepage();

        WebElement usernameElement = Driver.instance.findElement(By.id("username"));
        usernameElement.sendKeys("Username");

        WebElement passwordElement = Driver.instance.findElement(By.id("password"));
        passwordElement.sendKeys("Password");

        WebElement loginButtonElement = Driver.instance.findElement(By.id("Login"));
        loginButtonElement.click();
    }
}
