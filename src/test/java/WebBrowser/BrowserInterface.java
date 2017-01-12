package WebBrowser;

import org.openqa.selenium.WebDriver;

/**
 * Created by santiago on 1/12/17.
 */
public interface BrowserInterface extends WebDriver {
    public static int XSHORT_WAIT_TIME=2;

    public static int SHORT_WAIT_TIME=15;

    public static int MEDIUM_WAIT_TIME=45;

    public static int LONG_WAIT_TIME=90;

    public static int XLONG_WAIT_TIME=200;
}
