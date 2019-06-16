package com.benni.automation.service.features.steps.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.internal.filter.ValueNode.JsonNode;

import groovy.json.internal.JsonStringDecoder;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;

public class PO_ServicioJoinnus_Eventos {

	static String URl_trama = "";
	static String millasConsulta = "";

	@Step
	public static void ActionEjecutarAPIConsultarMillas() throws IOException {
		try {
			String output="";
			DocumentContext docCtx=null;
			JsonPath jsonPath=null;
			JSONArray val1=null;
			 int i=1;
			 boolean bValidar=true;
			 
			 while (bValidar==true) {
			 
			 URL url = new URL("http://52.7.202.142/proxyJoinnus/api/v1/PE/events/outsource?page="+i);//URL
	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         conn.setRequestProperty("Accept", "application/json");
	         conn.setRequestProperty("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImI2ZTAwYWM5MjY0YmQ0NmQ1ZTlhMGMxZmQ3ZjA3MWUzNDM0NDU0M2U2NGZmY2YxYjBhZjNlNzUxOTc1MWI2ODhkZTdkNWQ0ZTIzMjc4OWY1In0.eyJhdWQiOiIzIiwianRpIjoiYjZlMDBhYzkyNjRiZDQ2ZDVlOWEwYzFmZDdmMDcxZTM0MzQ0NTQzZTY0ZmZjZjFiMGFmM2U3NTE5NzUxYjY4OGRlN2Q1ZDRlMjMyNzg5ZjUiLCJpYXQiOjE1NTk4Mzg5MTEsIm5iZiI6MTU1OTgzODkxMSwiZXhwIjoxNTU5ODgyMTExLCJzdWIiOiIiLCJzY29wZXMiOltdfQ.VnTMrwNAluo8XdM5HAGZoxtMEVZHDMROz3P7cLbfzGVhr0PjXKNHOqJF_oaFhx34xkxd1teQpUo3koZ2LPiWhkLuwaDmPMaHTpqnKPUX2_tCSFH5jVbGFVXxnnEclYIv4BTHdxuyKj18_e21tANy3JQ-cy-SWSIDcjS_qdtzP4G38TrhLc5VMLO1AZ8DER8rk4VtS_fgxq8KRCLpMrNBG0xwdfCLJl368qV3rAZQVM_174jpsRavK0nz1Cd4-zQb06tq8ZooziGtnFiwR-OV9TN6b9K_LPnK85xP9-QbUkxS_2NQbyzt-Km1FldqfAGeu8emGOyQPmBdcNQvrIwIUoE93bjnyqKuBI6lk3eeT3AKGwgu1wqqCQT4N0zwfASpNBo9G26HMPWSM1kKnq7CKpS6GsHy3JE14ucRs5KN0cFtA2QrIh5fJg_zmKON2nOtsCskkXBBHp5GXVIC4TYdT-lbn_bh-PW1UNaCCFHGJDnkeo1K2VL4rGJK3NCEpwSEanSRE2gLZunYFDOWhPGu421x9kL2P4DjOXIBTIIF425xFpq6-2Bvk53eNr2LEnoOaQpBg137dW7TQ432XVOiuYAZTj_ALaRcqDjngfPXltIuYwMAFp_vw7smQMmErEOyhJtccR66crqX61iULVY0nRLt1n65nciqRxC3-MvBebQ");
	        		 
	         
	         
	         if (conn.getResponseCode() != 200) {
	             throw new RuntimeException("Failed : HTTP Error code : "+ conn.getResponseCode());	             
			}
	        	         	        
	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	         BufferedReader br = new BufferedReader(in);
	         
	         while ((output = br.readLine()) != null) {
	        	 //System.out.println(output);
	        	 
	        	 docCtx = JsonPath.parse(output);
	        	 jsonPath = JsonPath.compile("$..description");	         
		         val1=docCtx.read(jsonPath);
		         //System.out.println(""+val1.isEmpty());
		         if (val1.isEmpty()) {
					bValidar=false;
				}else {
					System.out.println(val1);
				}
		         
	         	}
	         
			 i++;
			 }
             
             /*DocumentContext docCtx = JsonPath.parse(output);
	         JsonPath jsonPath = JsonPath.compile("$..activities");	         
	         JSONArray val1=docCtx.read(jsonPath);
	         System.out.println(val1);*/
	         
			//conn.disconnect();
			
			} catch (Exception e) {
				System.out.println("Exception in NetClientGet:- " + e);
			}
	}
	
	
	
	@Step
	public static void ActionEjecutarAPIFilelizarCliente(String tarjeta) throws IOException {
		
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
