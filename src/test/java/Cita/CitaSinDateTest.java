package Cita;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by santiago on 1/12/17.
 */
public class CitaSinDateTest {
    BrowserInterface browser;

    @BeforeTest
    public void init(){

        this.browser= WebBrowserSession.createSession(SetUp.BROWSER);

    }


    @Test
    public void test(){

        WebPageDir.clickPageOnMenu(this.browser,WebPageDir.Pages.AGENDAR_CITA);

        BrowserFactory.browserWait(this.browser, BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.id("datepicker")));

        WebElement fecha=this.browser.findElement(By.id("datepicker"));



        //TODO El input de este formulario no tiene id ni names :(

        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/div[2]/input")));

        WebElement idpaciente = this.browser.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/div[2]/input"));

        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/div[3]/input")));

        WebElement iddoctor = this.browser.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/div[3]/input"));


        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/div[4]/textarea")));

        WebElement comments = this.browser.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/div[4]/textarea"));



        BrowserFactory.browserWait(this.browser,BrowserInterface.MEDIUM_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/a")));

        WebElement saveForm = this.browser.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[3]/div/a"));




        /*
            llenar los datos de los fields
         */

        Paciente pac=Paciente.generatePaciente();

        Doctor doc=Doctor.generateDoctor();

        idpaciente.sendKeys(pac.getId());

        iddoctor.sendKeys(doc.getId());

        comments.sendKeys("Gracias por tenerme en cuenta para esta entrevista, esta genial!!");

        saveForm.click();

        try {
            BrowserFactory.browserWait(this.browser, BrowserInterface.XSHORT_WAIT_TIME, ExpectedConditions.presenceOfElementLocated(By.className("panel-dange")));
        }catch (Exception e){
            assert false:"Error al agendar una cita sin fecha";
        }


    }


    @AfterMethod
    public void closeTest(){

    }


}
