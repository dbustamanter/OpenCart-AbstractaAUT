package driverConfig;

import constants.Navegador;
import org.openqa.selenium.WebDriver;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();
    public static void setUpDriver(Navegador navegador) {
        driverManager.createDriver(navegador);
    }
    public static WebDriver getDriver(){
        return driverManager.getDriver();
    }
}
