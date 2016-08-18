/**
 * Created by tony.hildebrand on 5/18/16.
 */
public class NewsPage {
    public static boolean isAt() {
        String title = Driver.instance.getTitle();

        if (title.contains("News | Twinspires.com")) {
            return true;
        } else {
            return false;
        }
    }
}
