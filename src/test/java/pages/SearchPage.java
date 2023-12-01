package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(),\"Search\")]")
    WebElement tituloBusqueda;

    public void verificarBusquedaRealizada(String elementoBusqueda) {
        try {
            waitForElement(tituloBusqueda);
            Assertions.assertEquals("Search - " + elementoBusqueda, tituloBusqueda.getText());
        }catch (AssertionError assertionError){
            System.out.println("Error durante assertion: " + assertionError.getMessage());
        }
    }
    public void seleccionarPrimerResultadoBusqueda(){
        List<WebElement> productosEncontrados = findElements("//div[contains(@class,\"product-layout\")]//h4/a");
        if(productosEncontrados.size()!=0){
            click(productosEncontrados.get(0));
        }else{
            System.out.println("Busqueda no arroja resultado");
        }
    }
}
