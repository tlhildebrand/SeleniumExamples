import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class WagerPageTests {
    @BeforeTest
    public void setupTests() {
        Driver.getInstance();
        LoginPage.login();
    }

    @Test(priority = 1)
    public void canUserAccessWagerPage() {
        TopNavigationMenu.clickWagerLink();
        Assert.assertTrue(WagerPage.isAt(), "Wager Link failed. Unable to access Wager page.");
    }

    @AfterTest
    public void tearDownTests() {
        Driver.logout();
        Driver.close();
    }
}
