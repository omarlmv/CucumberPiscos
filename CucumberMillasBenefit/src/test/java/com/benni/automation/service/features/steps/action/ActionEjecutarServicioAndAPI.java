package com.benni.automation.service.features.steps.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;

public class ActionEjecutarServicioAndAPI {

	static String URl_trama = "";
	static String millasConsulta = "";

	@Step
	public static void ActionEjecutarAPIConsultarMillas(String tarjeta) throws IOException {

		URl_trama = "https://dpiuat.grupoib.local:7020/ibk/uat/api/exp-benefit/v1/";

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Authorization", "Basic dUJzZUdlblVhdDpJbnRlcmJhbmsyMDE4");
		parameters.put("X-INT-Module-Id", "modctacte");
		parameters.put("X-INT-Country-Id", "PE");
		parameters.put("X-INT-Service-Id", "RNC");
		parameters.put("X-INT-Branch-Id", "898");
		parameters.put("X-Ibm-Client-Id", "b7974711-f636-4d20-bc84-d3c8d6c3ace2");
		parameters.put("X-INT-Branch-Id", "898");
		parameters.put("X-INT-Server-Id", "SERVER01");
		parameters.put("X-INT-Device-Id", "127.0.0.1");
		parameters.put("X-INT-Timestamp", "2019-03-13T15:56:35.657422");
		parameters.put("X-INT-Net-Id", "BI");
		parameters.put("X-INT-Supervisor-Id", "S33211");
		parameters.put("X-INT-Consumer-Id", "BENNI");
		parameters.put("X-INT-Message-Id", "prueba000");
		parameters.put("X-INT-User-Id", "BENI00000");
		parameters.put("Host", "dpiuat.grupoib.local:7020");
		parameters.put("Connection", "Keep-Alive");

		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("name", "NORMA");
		queryParam.put("code", "0112124");
		queryParam.put("cardId", tarjeta);

		SerenityRest.given().contentType("application/json").and().headers(parameters).and().queryParams(queryParam)
				.when().get(URl_trama).then().statusCode(200);

	}
	
	@Step
	public static void ActionEjecutarAPIFilelizarCliente(String tarjeta) throws IOException {

		URl_trama = "https://dpiuat.grupoib.local:7020/ibk/uat/api/benefit/v1/{customerId}";

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Authorization", "Basic dUJzZUdlblVhdDpJbnRlcmJhbmsyMDE4");
		parameters.put("X-INT-Module-Id", "modctacte");
		parameters.put("X-INT-Country-Id", "PE");
		parameters.put("X-INT-Service-Id", "RNC");//
		parameters.put("X-INT-Branch-Id", "898");//
		parameters.put("X-Ibm-Client-Id", "b7974711-f636-4d20-bc84-d3c8d6c3ace2");//
		parameters.put("X-INT-Branch-Id", "898");//
		parameters.put("X-INT-Server-Id", "SERVER01");//
		parameters.put("X-INT-Device-Id", "127.0.0.1");//
		parameters.put("X-INT-Timestamp", "2019-03-13T15:56:35.657422");//
		parameters.put("X-INT-Net-Id", "BI");//
		parameters.put("X-INT-Supervisor-Id", "S33211");//
		parameters.put("X-INT-Consumer-Id", "BENNI");
		parameters.put("X-INT-Message-Id", "prueba000");
		parameters.put("X-INT-User-Id", "BENI00000");
		parameters.put("Host", "dpiuat.grupoib.local:7020");
		parameters.put("Connection", "Keep-Alive");

		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("name", "NORMA");
		queryParam.put("code", "0112124");
		queryParam.put("cardId", tarjeta);

		SerenityRest.given().contentType("application/json").and().headers(parameters).and().queryParams(queryParam)
				.when().get(URl_trama).then().statusCode(200);

	}
	
	@Step
	public static int getStatusCode() {
		return SerenityRest.then().extract().statusCode();
	}
	@Step
	public static int getProviderMessage() {
		return SerenityRest.then().extract().body().jsonPath().get("providerMessage");
	}

	@Step
	public static void getExtraerMillas() {
		
		millasConsulta = SerenityRest.then().extract().body().jsonPath().get("miles");
		
		
	}
}
