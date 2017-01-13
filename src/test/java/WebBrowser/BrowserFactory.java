package WebBrowser;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by santiago on 1/12/17.
 */
public class BrowserFactory {

    public enum BROWSER_TYPE{
        CHROME,FIRE_FOX,
    }



    public static BrowserInterface createBrowser(BROWSER_TYPE option){

        BrowserInterface ret = null;

        switch(option){
            case CHROME:
                ret = new LocalBrowser();
                break;
            case FIRE_FOX:
                ret= new FireFox();
                break;
            default:
                ret= new FireFox();
                break;
        }


        return ret;
    }


    public static void browserWait(BrowserInterface browser, int time, ExpectedCondition condition) {
        WebDriverWait wait_alert = new WebDriverWait(browser, time);
        wait_alert.until(condition);
    }




}
