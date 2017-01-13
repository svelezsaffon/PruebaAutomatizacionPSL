package Pacientes;

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
public class AnadirPacienteTest {
    BrowserInterface browser;

    @BeforeTest
    public void init(){
        this.browser= WebBrowserSession.createSession(BrowserFactory.BROWSER_TYPE.FIRE_FOX);
    }


    @Test
    public void test(){



        this.browser.get(WebPageDir.build_page(WebPageDir.Pages.ANADIR_PACIENTE));

        /*
            seccion dodne obtenemos todos los fiedls a llenar
         */


        BrowserFactory.browserWait(this.browser, BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.name("name")));

        WebElement doctorName=this.browser.findElement(By.name("name"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.name("last_name")));

        WebElement doctorLastName=this.browser.findElement(By.name("last_name"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.name("telephone")));

        WebElement doctorTel=this.browser.findElement(By.name("telephone"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.name("identification")));

        WebElement doctorId=this.browser.findElement(By.name("identification"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.name("identification_type")));

        Select idType=new Select(this.browser.findElement(By.name("identification_type")));

        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.name("prepaid")));

        WebElement prepagada=this.browser.findElement(By.name("prepaid"));





        /*

            Seccion dodne llenamos formularios despues de que encontramos todos los fields
         */


        Paciente paciente=Paciente.generatePaciente();


        doctorName.sendKeys(paciente.getName());

        doctorLastName.sendKeys(paciente.getLastName());

        doctorTel.sendKeys(paciente.getTel());

        idType.selectByVisibleText("Cédula de extrangería");

        doctorId.sendKeys(paciente.getId());

        if(paciente.getPrepa()){

            prepagada.click();
        }

        /*
            Seccion donde verificamos todos los valores antes de enviar el formulario
         */

        assert doctorName.getAttribute("value").equals(paciente.getName()):"Nombre paciente no es el ingresado";
        assert doctorLastName.getAttribute("value").equals(paciente.getLastName()):"Apellido paciente no es el ingresado";
        assert doctorTel.getAttribute("value").equals(paciente.getTel()):"Telefono paciente no es el ingresado";
        assert doctorId.getAttribute("value").equals(paciente.getId()):"Identificacion paciente no es el ingresado";


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

        BrowserFactory.browserWait(this.browser, BrowserInterface.XSHORT_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.className("panel-success")));


    }


    @AfterMethod
    public void closeTest(){
        //this.browser.close();
    }



}
