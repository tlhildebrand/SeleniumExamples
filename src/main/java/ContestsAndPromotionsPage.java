/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class ContestsAndPromotionsPage {
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("TwinSpires.com | Promotions")) {
            return true;
        } else {
            return false;
        }
    }
}
