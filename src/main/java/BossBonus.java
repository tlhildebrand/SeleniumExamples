import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tony.hildebrand on 7/7/16.
 */
public class BossBonus {

  //HAVE NOT TESTED
  public static void navigateToAddBonusPage() {
    Actions action = new Actions(Driver.instance);
    WebElement bonusHoverLink = Driver.instance.findElement(By.xpath("//span[@class=\'divLink\']"));
    action.moveToElement(bonusHoverLink).build().perform();
    action.moveToElement(Driver.instance.findElement(By.xpath("//span[contains(@class,'divLink')]")));
  }
}
