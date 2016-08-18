/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class WagerPage {

    //Verifies user is at the wager page
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("TwinSpires.com | Wager Now")) {
            return true;
        } else {
            return false;
        }
    }
}
