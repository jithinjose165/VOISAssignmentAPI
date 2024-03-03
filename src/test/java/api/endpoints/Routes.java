package api.endpoints;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Routes {
	public static RequestSpecification reqSpecification;
	public static String postLogin="/users/login";
	public static String postCreateUser="/users";
	public static String getUser="/users/me";
	
	public RequestSpecification requestSpecification() throws IOException {
		reqSpecification =  new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).build();
		return reqSpecification;
		
	}
	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\utils\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
