package com.benni.automation.service.features.steps;

import com.benni.automation.service.features.steps.action.ActionEjecutarServicioAndAPI;
import com.benni.automation.service.features.steps.action.ActionValidateConsultRisk;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class StepConsultarMB {

	static String Riesgo = "";
	static String URl_trama = "";
	static String URL_RIESGO = "";
	static String PATH_trama = "";
	static String EstadoTarjeta = "";

	@Given("^cliente quiere consultar sus millas con su tarjeta$")
	public void cliente_quiere_consultar_sus_millas_con_su_tarjeta() throws Throwable {
	}

	@Given("^la tarjeta debe participar en benefit$")
	public void la_tarjeta_debe_participar_en_benefit() throws Throwable {
	}

	@Given("^la tarjeta acomula millas benefit$")
	public void la_tarjeta_acomula_millas_benefit() throws Throwable {
	}

	@When("^cliente consulta sus millas benefit con su \"([^\"]*)\" de credito de \"([^\"]*)\" \"([^\"]*)\"$")
	public void cliente_consulta_sus_millas_benefit_con_su_de_credito_de(String tarjeta, String arg2, String arg3)
			throws Throwable {

		//ActionEjecutarServicioAndAPI.ActionEjecutarAPIConsultarMillas(tarjeta);
	}

	@When("^cliente consulta sus millas benefit con su \"([^\"]*)\" de debito de \"([^\"]*)\" \"([^\"]*)\"$")
	public void cliente_consulta_sus_millas_benefit_con_su_de_debito_de(String tarjeta, String arg2, String arg3)
			throws Throwable {

		ActionEjecutarServicioAndAPI.ActionEjecutarAPIConsultarMillas(tarjeta);
	}

	@When("^la \"([^\"]*)\" se encuentra \"([^\"]*)\"$")
	public void la_se_encuentra(String tarjeta, String estado) throws Throwable {
		

		if (estado.equals("Activa")) {
			 EstadoTarjeta="A";
		} else if (estado.equals("BAJA")) {
			 EstadoTarjeta="B";
		} else if (estado.equals("API NOT EXECUTED")) {
			 EstadoTarjeta="";
		} else if (estado.equals("BLOQUEADA")) {
			 EstadoTarjeta="Q";
		} else if (estado.equals("No Activa")) {
			 EstadoTarjeta="N";
		}

		URL_RIESGO = "https://dpiuat.grupoib.local:7200/ibk/srv/MPO/AtencionCliente/tarjeta.consultarRiesgo/v1.0";

		String fileInputStream = generateStringFromResource("features/consultarRiesgo.xml").toString();
		//FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/features/consultarRiesgo.xml"));
	
		String finalfileInputStream = (fileInputStream.replace("{{numeroTarjeta}}",tarjeta));
		System.out.print(finalfileInputStream);
		Map<String, Object> headerRiesgo = new HashMap<>();
		headerRiesgo.put("SOAPAction","http://interbank.com.pe/service/MPO/AtencionCliente/tarjeta.consultarRiesgo/v1.0/");
		headerRiesgo.put("Host", "dpiuat.grupoib.local:7200");
		headerRiesgo.put("Content-Type", "text/xml");
		
																	
		SerenityRest.given()
		.headers(headerRiesgo).and().and()
		.body(finalfileInputStream).when()
		.post(URL_RIESGO).then().statusCode(200).and().log().all().extract().response().then()
		.body("Envelope.Body.ConsultarRiesgoResponse.tarjeta.codigoEstadoTarjeta", equalTo(EstadoTarjeta));
		
		

	}

	@Then("^Muestra millas disponibles$")
	public void muestra_millas_disponibles() throws Throwable {
	
		 
	}

	@Then("^la consulta no le debe generar Error$")
	public void la_consulta_no_le_debe_generar_Error(int expectedStatusCode) throws Throwable {
		expectedStatusCode = 200;
		assertThat("Wrong response status code", ActionEjecutarServicioAndAPI.getStatusCode(),
				equalTo(expectedStatusCode));
		ActionEjecutarServicioAndAPI.getProviderMessage();
	}

	@When("^cliente consulta sus millas benefit con su \"([^\"]*)\" de debito o credito de \"([^\"]*)\" \"([^\"]*)\"$")
	public void cliente_consulta_sus_millas_benefit_con_su_de_debito_o_credito_de(String tarjeta, String arg2,
			String arg3) throws Throwable {

		ActionEjecutarServicioAndAPI.ActionEjecutarAPIConsultarMillas(tarjeta);
	}

	@Then("^No muestra millas disponibles$")
	public void no_muestra_millas_disponibles() throws Throwable {
		ActionEjecutarServicioAndAPI.getExtraerMillas();
	}
	private String   generateStringFromResource(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream(fileName), StandardCharsets.UTF_8);

    }

}
