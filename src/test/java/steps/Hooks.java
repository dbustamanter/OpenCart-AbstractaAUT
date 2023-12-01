package steps;

import constants.Navegador;
import driverConfig.DriverContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private Scenario scenario;
    private static String evidencia;

    static {
        evidencia = System.getProperty("evidence", "fullEvidence");
    }

    @Before
    public void beforeClass(Scenario scenario){
        this.scenario =scenario;
        DriverContext.setUpDriver(Navegador.Chrome);
    }
    @AfterStep
    public void capturarEvidencia() throws Exception{
        if (this.scenario.isFailed()) {
            generarEvidencia("[FALLIDO] Captura de Scenario");
        } else if (Hooks.evidencia.equalsIgnoreCase("fullEvidence")) {
            generarEvidencia("[EXITO] Captura de Step");
        }
    }

    @After
    public void afterClass(){
        DriverContext.getDriver().quit();
    }

    public void generarEvidencia(String textoRefImagen){
        byte[] screenShot = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(screenShot, "image/png", textoRefImagen);
    }
}
