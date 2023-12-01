package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//div[@id=\"logo\"]")
    WebElement indexTitle;

    @FindBy(xpath = "//div[@id=\"search\"]/input")
    WebElement searchInput;

    @FindBy(xpath = "//div[@id=\"search\"]//button")
    WebElement searchButton;

    public void ingresarIndexStore(){
        driver.get("https://opencart.abstracta.us/");
        waitForElement(indexTitle);
    }
    public void realizarBusqueda(String elementoBusqueda){
        click(searchInput);
        sendKeys(searchInput,elementoBusqueda);
        click(searchButton);
    }
}
