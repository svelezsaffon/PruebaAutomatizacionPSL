package AnadirDoctor;

import Config.WebPageDir;
import WebBrowser.BrowserFactory;
import WebBrowser.BrowserInterface;
import WebBrowser.WebBrowserSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by santiago on 1/12/17.
 */



public class AnadirDoctorTest {

    BrowserInterface browser;

    @BeforeTest
    public void init(){
        this.browser= WebBrowserSession.createSession(BrowserFactory.BROWSER_TYPE.FIRE_FOX);
    }


    @Test
    public void test(){
        this.browser.get(WebPageDir.build_page(WebPageDir.Pages.ANADIR_DOCTOR));

        /*
            seccion dodne obtenemos todos los fiedls a llenar
         */


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.id("name")));

        WebElement doctorName=this.browser.findElement(By.id("name"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.id("last_name")));

        WebElement doctorLastName=this.browser.findElement(By.id("last_name"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.id("telephone")));

        WebElement doctorTel=this.browser.findElement(By.id("telephone"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.id("identification")));

        WebElement doctorId=this.browser.findElement(By.id("identification"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.id("identification_type")));

        Select idType=new Select(this.browser.findElement(By.id("identification_type")));


        /*
            Seccion dodne llenamos formularios despues de que encontramos todos los fields
         */


        doctorName.sendKeys("Santiago");

        doctorLastName.sendKeys("Velez");

        doctorTel.sendKeys("8745462");

        idType.selectByVisibleText("Cédula de extrangería");

        doctorId.sendKeys("12345678910");

        /*
            Seccion donde verificamos todos los valores antes de enviar el formulario
         */

        assert doctorName.getAttribute("value").equals("Santiago");
        assert doctorLastName.getAttribute("value").equals("Velez");
        assert doctorTel.getAttribute("value").equals("8745462");
        assert doctorId.getAttribute("value").equals("12544896325");


        /*
        Enviar el formulario
         */


    }


    @AfterMethod
    public void closeTest(){
        //this.browser.close();
    }


}
