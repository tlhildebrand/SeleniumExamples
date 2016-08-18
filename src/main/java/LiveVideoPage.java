/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class LiveVideoPage {
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("TwinSpires.com | Live Video")) {
            return true;
        } else {
            return false;
        }
    }
}
