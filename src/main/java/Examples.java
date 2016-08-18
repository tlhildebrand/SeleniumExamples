import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by tony.hildebrand on 5/19/16.
 */
public class Examples {

    //Browser capabilities
    public static void browserCapabilities() {
        java.util.Map capabilitiesMap = new HashMap();
        capabilitiesMap.put("takesScreenShot", true);

        DesiredCapabilities capabilities = new DesiredCapabilities(capabilitiesMap);
        WebDriver capabilityDriver = new FirefoxDriver(capabilities);
        capabilityDriver.get("http://www.twinspires.com");
    }

    //Screenshots
    public static File getBrowserScreenShot() {
        /*
        getScreenshotAs method returns whatever OutputType is passed into the method
        In this case we are turning back a file so the method signature returns a File type
         */
        File srcFile = ((TakesScreenshot) Driver.instance).getScreenshotAs(OutputType.FILE);
        return srcFile;
    }

    //Explicit wait method where I can define a custom explicit wait for any specified element
    public static void explicitWait(int seconds, WebElement currentElement, final By selector) {
        currentElement = (new WebDriverWait(Driver.instance, seconds)).until(
                new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return input.findElement(selector);
                    }
                });
    }

    //Store cookies so we only have to login once
    public static void storeLoginCookies() {
        LoginPage.homepage();
        LoginPage.login();

        File file = new File("browser.data");

        try {
                file.delete();
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

            for (Cookie cookie : Driver.instance.manage().getCookies()) {
                /*
                The example provided here is the same as the StringBuilder class. The reason I use
                the StringBuilder class is because Strings are immutable and we are taking a performance
                hit when adding multiple strings together. If you're adding one or two Strings then
                it is okay to use this method.
                 */
                //bw.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain())
                        //+ ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());

                String delimiter = ";";
                StringBuilder sb = new StringBuilder();
                sb.append(cookie.getName())
                        .append(delimiter)
                        .append(cookie.getValue())
                        .append(delimiter)
                        .append(cookie.getDomain())
                        .append(delimiter)
                        .append(cookie.getPath())
                        .append(delimiter)
                        .append(cookie.getExpiry())
                        .append(delimiter)
                        .append(cookie.isSecure());
                //Once we call toString() on the string builder instance it will complete the string
                bw.write(sb.toString());

                bw.newLine();
            }

            bw.flush();
            bw.close();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Load cookie info to the browser
    public static void loadCookiesInBrowser() {
        Driver.getInstance();
        LoginPage.homepage();

        try {
            File file = new File("browser.data");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenContainer = new StringTokenizer(line, ";");
                while (tokenContainer.hasMoreTokens()) {
                    String name = tokenContainer.nextToken();
                    String value = tokenContainer.nextToken();
                    String domain = tokenContainer.nextToken();
                    String path = tokenContainer.nextToken();
                    Date expiry = null;
                    String dt;

                    if (!(dt = tokenContainer.nextToken()).equals("null")) {
                        expiry = new Date(Long.parseLong(dt));
                    }

                    boolean isSecure = new Boolean(tokenContainer.nextToken()).booleanValue();
                    Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    Driver.instance.manage().addCookie(cookie);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Driver.instance.get("http://www.twinspires.com");
    }

    /*
    Example of changing the user agent to test against mobile websites .
    Input parameters are key, which is a string and represents your preference; and value, which has
    to be set to the preference. There are two overloaded methods which value is accepted as an int and boolean
    value.
     */
    public static void setPreferences() {
        FirefoxProfile profile = new FirefoxProfile();

        String value = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_0 like Mac OS X; en-us)"
            + "AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7";

        profile.setPreference("general.useragent.override", value);
        FirefoxDriver driver = new FirefoxDriver(profile);
    }

    /*
    Modifying frozen preferences on Firefox
     */
    public static void setUntrustedCertificatesToFalse() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setAcceptUntrustedCertificates(false);

        FirefoxDriver driver = new FirefoxDriver(profile);
    }

    /*
    Using different Firefox versions by using binaries
     */
    public static void loadFirefoxBinary() {
        FirefoxBinary binary = new FirefoxBinary(new File("location of firefox.exe"));
        FirefoxProfile profile = new FirefoxProfile();

        FirefoxDriver driver = new FirefoxDriver(binary, profile);
    }

    /*
    Setting the desired capabilities in IE
     */
    public static void setIEDesiredCapabilities() {
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

        ieCapabilities.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);

        WebDriver driver = new InternetExplorerDriver(ieCapabilities);
    }

    /*
    Specifying port for InternetExplorer driver service
     */
    public static void buildIEDriverService() {
        InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();
        InternetExplorerDriverService srvc = builder.usingPort(5555).withHost("127.0.0.1").build();

        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);

        WebDriver driver = new InternetExplorerDriver(srvc, ieCapabilities);

        //Kill IE process running on port 5555 then stop the service
        driver.quit();

        //Stop service
        srvc.stop();
    }

    /*
    ChromeOptions is the same as FirefoxProfile
    Example: installing extensions
     */
    public static void setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("file location to .crx file"));
    }
}

