package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    String baseTranslateFunction = "[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '']";

    @FindBy(xpath = "//div[@id=\"content\"]//h1")
    WebElement tituloProducto;

    @FindBy(xpath = "//button[@id=\"button-cart\"]")
    WebElement agregarCarroButton;

    @FindBy(xpath = "//div[@id=\"cart\"]/button")
    WebElement carroButton;

    @FindBy(xpath = "//table//td[2]/a")
    WebElement tituloElementoCarro;

    public void agregarElementoCarro(String elemento) {
        try {
            waitForElement(tituloProducto);
            Assertions.assertEquals(elemento, tituloProducto.getText().toLowerCase());
            click(agregarCarroButton);
        }catch (AssertionError assertionError){
            System.out.println("Error durante assertion: " + assertionError.getMessage());
        }
    }

    public void verificarProductoCarro(String elemento){
        click(carroButton);
        waitForElement(tituloElementoCarro);
        Assertions.assertEquals(elemento,tituloElementoCarro.getText().toLowerCase());
    }

}
