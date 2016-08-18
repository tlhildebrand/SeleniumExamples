import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class TopNavigationMenu {

    //Clicks the wager navigation link
    public static void clickWagerLink() {
        /*
        Using XPath can slow down performance but sometimes it may be one of the easiest ways
        to grab an element. However, there are better ways to grab a navigation menu which
        uses unordered list. I haven't found enough data to verify newer browsers can navigate
        XPath the same speed as grabbing the element by ID. In studies shown with older browsers
        XPath can take up to 2-6 seconds longer than ID depending how many elements it has to
        navigate through on the DOM. Will investigate more...
         */
        WebElement wagerLink = Driver.instance.findElement(By.xpath("//*[@id=\"nav-top-list\"]/li[1]/a"));
        wagerLink.click();
    }

    //Clicks the live video navigation link
    public static void clickLiveVideoLink() {
        WebElement liveVideoLink = Driver.instance.findElement(By.xpath("//*[@id=\"nav-top-list\"]/li[2]/a"));
        liveVideoLink.click();
    }

    //Handicapping
    public static void clickHandicappingLink() {
        WebElement handicappingLink = Driver.instance.findElement(By.xpath("//*[@id=\"nav-top-list\"]/li[3]/a"));
        handicappingLink.click();
    }

    //News
    public static void clickNewsLink() {
        WebElement newsLink = Driver.instance.findElement(By.xpath("//*[@id=\"nav-top-list\"]/li[4]/a"));
        newsLink.click();
    }

    //Rewards
    public static void clickRewardsLink() {
        WebElement rewardsLink = Driver.instance.findElement(By.xpath("//*[@id=\"nav-top-list\"]/li[5]/a"));
        rewardsLink.click();
    }

    //Contests and Promotions
    public static void clickContestsAndPromotionsLink() {
        WebElement contestsAndPromotionsLink = Driver.instance.findElement(
                By.xpath("//*[@id=\"nav-top-list\"]/li[6]/a"));
        contestsAndPromotionsLink.click();

    }

    //Support
    public static void clickSupportLink() {
        WebElement supportLink = Driver.instance.findElement(By.xpath("//*[@id=\"nav-top-list\"]/li[7]/a"));
        supportLink.click();
    }
}
