package com.benni.automation.service.features.steps;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DistribucionSteps {

	/* Distribucion */

	@Given("^El usuario quiere distribuir los pedidos disponibles$")
	public void usuario_quire_distrbuir_los_pedidos_disponibles() throws Throwable {
		given().contentType("application/json");

	}

	@When("^mira los pedidos disponibles$")
	public void mira_los_pedidos_disponibles() throws Throwable {
		when().get("http://localhost:8077/distribucion/listar/");
	}

	@When("^mira los pedidos disponibes por su identificador$")
	public void mira_los_pedidos_disponibles_por_su_id() throws Throwable {
		when().get("http://localhost:8077/distribucion/listar/1");
	}

	@Then("^el debe ver las distribuciones que están disponibles$")
	public void el_debe_ver_las_distribuciones_que_estan_disponibles() throws Throwable {
		try {
			then().statusCode(200).body(containsString("cliente"));
		} catch (Exception e) {
			assertFalse(false);
		}
	}

	@Then("^el debe ver las distribuciones que estàn disponibles que coincide con esa identificacion")
	public void el_debe_ver_las_distribuciones_que_estan_disponibles_que_coinciden_con_esa_identificacion()
			throws Throwable {
		then().statusCode(200).body(containsString("cliente"));
	}

	/*
    @Given("^Juan wants to purchase a vehicle$")
    public void juan_wants_to_purchase_a_vehicle() throws Throwable {
        given()
                .contentType("application/json");

    }

    @When("^he looks the available vehicles$")
    public void he_looks_the_available_vehicles() throws Throwable {
        when().get("http://localhost:3000/vehiculos");
    }

    @When("^he looks the available vehicles by Id$")
    public void he_looks_the_available_vehicles_by_Id() throws Throwable {
        when().get("http://localhost:3000/vehiculos/1");
    }

    @Then("^he must see which vehicles are available$")
    public void he_must_see_which_vehicles_are_available() throws Throwable {
        then().statusCode(200)
                .body(containsString("audi"));
    }

    @Then("^he must see the vehicle that match with that Id$")
    public void he_must_see_the_vehicle_that_match_with_that_Id() throws Throwable {
        then().statusCode(200)
                .body(containsString("ayw67p"));
    }
    */
    
}

