import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by tony.hildebrand on 7/1/16.
 */
public class BonusPageTests {
  @BeforeTest
  public void setupTests() {
    Driver.getInstance();
    LoginPage.login();
  }

  @BeforeMethod
  public void setupMethods() {
    LoginPage.homepage();
    BonusPage.manageMyAccount();
    BonusPage.viewBonusOffers();
  }

  @Test
  public void canPlayerAccessBonusPage() {
    Assert.assertTrue(BonusPage.isAt(), "Player was unable to access Bonus page.");
  }

  @Test
  public void isPlayerAssociatedWithABonus() {
    Assert.assertTrue(BonusPage.doesPlayerHaveActiveBonus(),
        "Player does not have an active Bonus");
  }

  @Test
  public void optPlayerOutOfBonus() {
    BonusPage.optOutOfBonus();
    Assert.assertFalse(BonusPage.doesPlayerHaveActiveBonus(),
        "Player is associated with a bonus");
  }

  @AfterTest
  public void tearDownTests() {
    Driver.logout();
    Driver.close();
  }
}
