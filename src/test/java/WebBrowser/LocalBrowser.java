package WebBrowser;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by santiago on 1/12/17.
 */
public class LocalBrowser extends ChromeDriver implements BrowserInterface {

    static {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    public LocalBrowser(){
        super();
    }

}
