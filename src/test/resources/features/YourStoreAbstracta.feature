@AbstractaDemo
Feature: Escenarios de prueba tienda Your Store Abstracta

  Background:
    Given cliente se encuentra en tienda online

  @AgregarCarrito
  Scenario: Agregar Iphone a carrito de compras
    When cliente realiza busqueda de producto iphone
    And cliente selecciona producto correspondiente a la busqueda y lo añade al carro de compras
    Then cliente encuentra su seleccion añadida al carro de compras

  @QuitarCarrito
  Scenario: Quitar Iphone de carrito de compras
    When cliente selecciona y añade producto Iphone al carro de compras
    And cliente encuentra su seleccion añadida al carro de compras
    And cliente quita el producto del carro de compras
    Then cliente encuentra carro de compras vacio
