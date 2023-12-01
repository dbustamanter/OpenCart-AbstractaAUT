package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.IndexPage;
import pages.ProductPage;
import pages.SearchPage;

public class YourStoreAbstractaSteps {
    IndexPage indexPage = new IndexPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();

    @Given("cliente se encuentra en tienda online")
    public void cliente_se_encuentra_en_tienda_online() {
        indexPage.ingresarIndexStore();
    }
    @When("cliente realiza busqueda de producto iphone")
    public void cliente_realiza_busqueda_de_producto_iphone() {
        indexPage.realizarBusqueda("iphone");
        searchPage.verificarBusquedaRealizada("iphone");
    }
    @When("cliente selecciona producto correspondiente a la busqueda y lo añade al carro de compras")
    public void cliente_selecciona_producto_correspondiente_a_la_busqueda_y_lo_anade_al_carro_de_compras() {
        searchPage.seleccionarPrimerResultadoBusqueda();
        productPage.agregarElementoCarro("iphone");


    }
    @When("cliente selecciona y añade producto Iphone al carro de compras")
    public void cliente_selecciona_y_anade_producto_iphone_al_carro_de_compras() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("cliente quita el producto del carro de compras")
    public void cliente_quita_el_producto_del_carro_de_compras() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("cliente encuentra su seleccion añadida al carro de compras")
    public void cliente_encuentra_su_seleccion_anadida_al_carro_de_compras() {
        productPage.verificarProductoCarro("iphone");
    }
    @Then("cliente encuentra carro de compras vacio")
    public void cliente_encuentra_carro_de_compras_vacio() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
