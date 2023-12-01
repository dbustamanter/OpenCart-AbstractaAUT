package driverConfig;

import constants.Navegador;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static WebDriver driver;

    protected void createDriver(Navegador nav) {
        System.out.println("Inicializando navegador: " + nav.toString());
        String os = System.getProperty("os.name").toLowerCase();
        switch (nav) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (os.contains("linux")) {
                    chromeOptions.addArguments("--ignore-certificate-errors");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EdgeGrid:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("ms:edgeOptions","--headlesss");
                try{
                    driver = new RemoteWebDriver(new URL("http://143.47.112.7:4444"),edgeOptions);
                }catch (MalformedURLException urlException){
                    System.out.println("Error al ubicar hub ejecutor");
                }
                break;
            case FirefoxGrid:
                WebDriverManager.firefoxdriver().setup();
                FirefoxBinary firefoxBinaryGrid = new FirefoxBinary();
                FirefoxOptions firefoxOptionsGrid = new FirefoxOptions();
                firefoxOptionsGrid.setBinary(firefoxBinaryGrid);
                firefoxOptionsGrid.addArguments("--headless");
                try{
                    driver = new RemoteWebDriver(new URL("http://143.47.112.7:4444"),firefoxOptionsGrid);
                }catch (MalformedURLException urlException){
                    System.out.println("Error al ubicar hub ejecutor");
                }
                break;
            case ChromeGrid:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeGridOptions = new ChromeOptions();
                if (os.contains("linux")) {
                    chromeGridOptions.addArguments("--ignore-certificate-errors");
                    chromeGridOptions.addArguments("--disable-extensions");
                    chromeGridOptions.addArguments("--disable-dev-shm-usage");
                    chromeGridOptions.addArguments("--disable-gpu");
                    chromeGridOptions.addArguments("--no-sandbox");
                    chromeGridOptions.addArguments("--headless");
                }
                chromeGridOptions.addArguments("--remote-allow-origins=*");
                try{
                driver = new RemoteWebDriver(new URL("http://143.47.112.7:4444"),chromeGridOptions);
                }catch (MalformedURLException urlException){
                    System.out.println("Error al ubicar hub ejecutor");
                }
                break;

        }
        driver.manage().window().maximize();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
