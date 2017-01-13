package Doctor;

import Config.SetUp;
import Config.WebPageDir;
import DatosUtilizados.Doctor;
import DatosUtilizados.Paciente;
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

/**
 * Created by santiago on 1/12/17.
 */
public class AnadirDoctorExistenteTest {

    BrowserInterface browser;

    @BeforeTest
    public void init(){
        this.browser= WebBrowserSession.createSession(SetUp.BROWSER);
    }


    @Test
    public void test(){


        WebPageDir.clickPageOnMenu(this.browser,WebPageDir.Pages.ANADIR_DOCTOR);

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


        Doctor doc=Doctor.generateDoctor();

        doctorName.sendKeys(doc.getName());

        doctorLastName.sendKeys(doc.getLastName());

        doctorTel.sendKeys(doc.getTel());

        idType.selectByVisibleText("Cédula de extrangería");

        doctorId.sendKeys(doc.getId());

        /*
            Seccion donde verificamos todos los valores antes de enviar el formulario
         */

        assert doctorName.getAttribute("value").equals(doc.getName()):"Nombre doctor no es el ingresado";
        assert doctorLastName.getAttribute("value").equals(doc.getLastName()):"Apellido doctor no es el ingresado";
        assert doctorTel.getAttribute("value").equals(doc.getTel()):"Telefono doctor no es el ingresado";
        assert doctorId.getAttribute("value").equals(doc.getId()):"Identificacion doctor no es el ingresado";


        /*
        Enviar el formulariotest
         */


        /*
        TODO el boton del fomulario no tiene ningun tipo de identificacion, lo mejor seria hacerlo por XPATH
         */

        BrowserFactory.browserWait(this.browser, BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/a")));

        WebElement sendButton=this.browser.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/a"));

        sendButton.click();




        /*
        Aca no tenemos mucho que nos diga que el doctor fue guardado, asi que podemos hacerlo por el panel succes de bootstrpa
         */

        BrowserFactory.browserWait(this.browser, BrowserInterface.XSHORT_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.className("panel-danger")));


    }


    @AfterMethod
    public void closeTest(){
    }



}
