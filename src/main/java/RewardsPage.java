/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class RewardsPage {
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("TwinSpires.com | TSC Rewards")) {
            return true;
        } else {
            return false;
        }
    }
}
