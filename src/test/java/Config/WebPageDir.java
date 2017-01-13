package Config;


import WebBrowser.BrowserInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by santiago on 1/12/17.
 */

public class WebPageDir {

    private static final String CENTRAL_URL="http://automatizacion.herokuapp.com/svelez/";

    public enum Pages {
        ANADIR_DOCTOR ("addDoctor"),
        ANADIR_PACIENTE ("addPatient"),
        ANADIR_HABITACION ("addRoom"),
        ANADIR_HOSPITAL ("addHospital"),
        HOME (""),
        AGENDAR_CITA ("appointmentScheduling");

        private final String name;

        private Pages(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            // (otherName == null) check is not needed because name.equals(null) returns false
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
    }


    public static String build_page(Pages page){

        StringBuilder url= new StringBuilder();

        url.append(CENTRAL_URL);

        url.append(page.toString());

        return url.toString();
    }

    public static void clickPageOnMenu(BrowserInterface browser, WebPageDir.Pages page){
        browser.get(WebPageDir.build_page(WebPageDir.Pages.HOME));

        List<WebElement> dirs=browser.findElements(By.className("list-group-item"));
        WebElement where=null;
        for(WebElement dir:dirs){
            if(dir.getAttribute("href").equals(WebPageDir.build_page(page))){
                where=dir;
                break;
            }
        }

        assert where!=null:"No se puede encontrar el boton ara ir a la pagina"+WebPageDir.build_page(page);

        where.click();
    }



}
