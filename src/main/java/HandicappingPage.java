/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class HandicappingPage {
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("Brisnet Handicapping")) {
            return true;
        } else {
            return false;
        }
    }
}
