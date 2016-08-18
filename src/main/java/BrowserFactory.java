import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tony.hildebrand on 7/7/16.
 */
public class BrowserFactory {

  //BrowserFactory example - can setup additional properties for each
  //browser before they're instantiated

  //HAVE NOT TESTED
  private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

  public static WebDriver getBrowser(String browserName) {
    WebDriver driver = null;

    switch (browserName) {
      case "Chrome":
        driver = drivers.get("Chrome");

        if (driver == null) {
          driver = drivers.get("Chrome");
          System.setProperty("webdriver.chrome.driver", "driver location here");
          driver = new ChromeDriver();
          drivers.put("Chrome", driver);
        }
      case "IE":
        driver = drivers.get("IE");

        if (driver == null) {
          System.setProperty("webdriver.ie.driver", "driver location here");
          driver = new InternetExplorerDriver();
          drivers.put("IE", driver);
        }
      default:
        driver = drivers.get("Firefox");

        if (driver == null) {
          driver = new FirefoxDriver();
          drivers.put("Firefox", driver);
        }

        break;
    }

    return driver;
  }
}
