package WebBrowser;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by santiago on 1/12/17.
 */
public class WebBrowserSession {

    private static WebBrowserSession session=null;

    static BrowserInterface browser;


    public WebBrowserSession(){

    }

    public static BrowserInterface createSession(BrowserFactory.BROWSER_TYPE typBr){

        if(session==null){
            session=getInstanceSession();
            browser=BrowserFactory.createBrowser(typBr);
        }


        return browser;
    }

    public static WebBrowserSession getInstanceSession(){
        if(session==null){
            session=new WebBrowserSession();
        }

        return session;
    }






    @AfterSuite
    public static void closeSession(){
        browser.close();
    }

}
