package WebBrowser;

/**
 * Created by santiago on 1/12/17.
 */
public class WebBrowserSession {

    private static WebBrowserSession session=null;

    static BrowserInterface  browser;


    private WebBrowserSession(){

    }

    public static BrowserInterface createSession(BrowserFactory.BROWSER_TYPE typBr){

        if(session==null){
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


    public static void closeSession(){
        browser.close();
    }

}
