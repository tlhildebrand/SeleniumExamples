import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class LoginTests {
    @BeforeTest
    public void setupTests() {
        Driver.getInstance();
    }

    @Test(priority = 1)
    public void canUserLogin() {
        LoginPage.login();
        Assert.assertTrue(LoginPage.isAt(), "Login failed. Unable to login.");
    }

    @AfterTest
    public void tearDownTests() {
        Driver.logout();
        Driver.close();
    }
}
