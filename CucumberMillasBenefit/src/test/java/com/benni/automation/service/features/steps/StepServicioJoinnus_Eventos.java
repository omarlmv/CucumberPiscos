package com.benni.automation.service.features.steps;

import com.benni.automation.service.features.steps.action.PO_ServicioJoinnus_Eventos;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepServicioJoinnus_Eventos {

	@Given("^Usuario consulte el servicio de eventos de joinnus$")
	public void usuario_consulte_el_servicio_de_eventos_de_joinnus() throws Throwable {
		PO_ServicioJoinnus_Eventos.ActionEjecutarAPIConsultarMillas();
	    
	}

	@When("^pase una hora los eventos se actualizan$")
	public void pase_una_hora_los_eventos_se_actualizan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^se visualizan la misma cantidad y los mismos eventos en el front$")
	public void se_visualizan_la_misma_cantidad_y_los_mismos_eventos_en_el_front() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
}
