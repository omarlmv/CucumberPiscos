package com.benni.automation.service.features.steps;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.containsString;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductosSteps {

	/* Productos */
	@Given("^El usuario quiere saber los productos disponibles$")
	public void elUsuarioQuiereSaberLossProductosDisponibles() throws Throwable {
		given().contentType("application/json");
	}

	@When("^mira los productos disponibles$")
	public void miraLosProductosDisponibles() throws Throwable {
		when().get("http://localhost:8077/producto/listadoProducto");
	}

	@Then("^el debe ver los productos que están disponibles$")
	public void elDebeVerLosProductosQueEstaDisponibles() throws Throwable {
		then().statusCode(200).body(containsString("idProducto"));
	}

}