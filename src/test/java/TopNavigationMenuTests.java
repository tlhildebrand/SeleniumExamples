import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class TopNavigationMenuTests {
    @BeforeTest
    public void setupTests() {
        Driver.getInstance();
        LoginPage.login();
    }

    @Test(priority = 1)
    public void testsWagerLink() {
        TopNavigationMenu.clickWagerLink();
        Assert.assertTrue(WagerPage.isAt(), "Wager Link failed. Unable to access Wager page.");
    }

    @Test(priority = 2)
    public void testsLiveVideoLink() {
        TopNavigationMenu.clickLiveVideoLink();
        Assert.assertTrue(LiveVideoPage.isAt(), "Live Video link failed. Unable to access Live Video page.");
    }

    @Test(priority = 3)
    public void testsHandicappingLink() {
        TopNavigationMenu.clickHandicappingLink();
        Assert.assertTrue(HandicappingPage.isAt(), "Handicapping link failed. Unable to access Handicapping page.");
    }

    @Test(priority = 4)
    public void testsNewsLink() {
        TopNavigationMenu.clickNewsLink();
        Assert.assertTrue(NewsPage.isAt(), "News link failed. Unable to access News page.");
    }

    @Test(priority = 5)
    public void testsRewardsLink() {
        TopNavigationMenu.clickRewardsLink();
        Assert.assertTrue(RewardsPage.isAt(), "Rewards link failed. Unable to access Rewards page.");
    }

    @Test(priority = 6)
    public void testsContestsAndPromotionsLink() {
        TopNavigationMenu.clickContestsAndPromotionsLink();
        Assert.assertTrue(ContestsAndPromotionsPage.isAt(),
                "Contests and Promotions link failed. Unable to access Contests and Promotions page.");
    }

    @Test(priority = 7)
    public void testsSupportLink() {
        TopNavigationMenu.clickSupportLink();
        Assert.assertTrue(SupportPage.isAt(), "Support link failed. Unable to access Support page.");
    }

    @AfterTest
    public void tearDownTests() {
        Driver.logout();
        Driver.close();
    }
}
