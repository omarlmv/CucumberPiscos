package com.benni.automation.service.features.steps.action;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;

public class ActionValidateConsultRisk {


	@Step
	public static  void validaEstadoTrjeta(String tarjeta, String estado) throws IOException {

		/*
		 * XmlPath jsXpath= new XmlPath(response.asString());//Converting string into
		 * xml path to assert String rate=jsXpath.getString("GetConversionRateResult");
		 * System.out.println("rate returned is: " + rate);
		 */

	}
	
	 
}
