package com.aju.restclientdemo.java;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	public static void main(String[] args) throws IOException, ParseException {
		try { 
		
		GetPropertiesValue getProperties = new GetPropertiesValue();
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(getProperties.getRequest());
		String jsonInput = (String) jsonObj.get("request");
		String url = (String) jsonObj.get("url");
		
			Client client = Client.create();
			WebResource resource = client.resource(url);
			ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput);
			String output = response.getEntity(String.class);
			
			System.out.println(output);
			
		} catch (Exception e) {
			System.out.println("error"+e);
			e.printStackTrace();
		}
		

	}

}
