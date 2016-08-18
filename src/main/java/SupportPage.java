/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class SupportPage {
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("TwinSpires.com | Support")) {
            return true;
        } else {
            return false;
        }
    }
}
