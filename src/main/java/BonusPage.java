import org.openqa.selenium.*;

/**
 * Created by tony.hildebrand on 7/1/16.
 */
public class BonusPage {
  public static boolean isAt() {
    String title = Driver.instance.getTitle();

    if (title.contains("TwinSpires.com | Bonus Offers")) {
      return true;
    } else {
      return false;
    }
  }

  public static void manageMyAccount() {
    WebElement manageMyAccountLink = Driver.instance.findElement(
        By.linkText("manage my account"));
    manageMyAccountLink.click();
  }

  public static void viewBonusOffers() {
    WebElement viewBonusOffersLink = Driver.instance.findElement(
        By.linkText("view your bonus offers"));
    viewBonusOffersLink.click();
  }

  public static boolean doesPlayerHaveActiveBonus() {
    WebElement optOut = Driver.instance.findElement(By.linkText("Opt Out"));

    if (optOut.isDisplayed()) {
      return true;
    } else {
      return false;
    }
  }

  public static void optOutOfBonus() {
    WebElement optOut = Driver.instance.findElement(By.linkText("Opt Out"));
    optOut.click();
  }
}
