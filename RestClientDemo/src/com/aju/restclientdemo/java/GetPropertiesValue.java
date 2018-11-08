package com.aju.restclientdemo.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.json.simple.JSONObject;

public class GetPropertiesValue {
	String result = "";
	InputStream inputStream;
	public String getRequest() throws IOException {
		JSONObject propertyData = new JSONObject();
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
			propertyData.put("request", prop.getProperty("json_request"));
			propertyData.put("url", prop.getProperty("url"));
			
			
			
 
		

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return propertyData.toString();
	}

}
