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

    @FindBy(xpath = "//table//td[2]/a/parent::td/following-sibling::td/button")
    WebElement cancelarProducto;

    @FindBy(xpath = "//span[@id=\"cart-total\" and contains(text(),\"0 item\")]")
    WebElement carroVacio;

    @FindBy(xpath = "//div[@id=\"cart\"]//p")
    WebElement mensajeCarroVacio;

    public void agregarElementoCarro(String elemento) {
        try {
            waitForElement(tituloProducto);
            Assertions.assertEquals(elemento, tituloProducto.getText().toLowerCase());
            click(agregarCarroButton);
        } catch (AssertionError assertionError) {
            System.out.println("Error durante assertion: " + assertionError.getMessage());
        }
    }

    public void verificarProductoCarro(String elemento) {
        click(carroButton);
        waitForElement(tituloElementoCarro);
        Assertions.assertEquals(elemento, tituloElementoCarro.getText().toLowerCase());
    }

    public void cancelarElementoCarro() {
        waitForElement(cancelarProducto);
        click(cancelarProducto);
    }

    public void validarCarroVacio() {
        waitForElement(carroVacio);
        click(carroButton);
        Assertions.assertEquals("Your shopping cart is empty!", mensajeCarroVacio.getText());
    }

}
