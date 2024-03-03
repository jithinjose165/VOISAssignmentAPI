package api.endpoints;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.POJOClasses.UserDetails;
import api.payload.UserInputs;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserEndpoints extends Routes{

	RequestSpecification loginRequest;
	RequestSpecification addUserRequest;
	UserInputs loginCredentials = new UserInputs();
	//Response response;
	String bearerToken;
	
	public Response loginUser() throws IOException {
		
		 loginRequest = given().spec(requestSpecification()).header("Content-Type","application/json").body(loginCredentials.getLogin());
			Response loginResponse = loginRequest.when().post(postLogin).then().log().all().extract().response();
			System.out.println(loginResponse.asString());
			JsonPath js = new JsonPath(loginResponse.asString());
		 bearerToken  = js.getString("token");
		return loginResponse;
	
		
	}
	
	public Response addUser() throws IOException {
		addUserRequest = given().spec(requestSpecification()).header("Content-Type","application/json")
				.header("Authorization",  "Bearer "+bearerToken).body(loginCredentials.createUser());
		Response addUserresponse = addUserRequest.when().post(postCreateUser).then().log().all().extract().response();
		System.out.println(addUserresponse.asString());
		return addUserresponse;
	}
	public UserDetails getUser() throws IOException {
		RequestSpecification getUserRequest = given().spec(requestSpecification())
				.header("Authorization",  "Bearer "+bearerToken);
		UserDetails addUserresponse = getUserRequest.when().get(getUser).as(UserDetails.class);
		return addUserresponse;
	}
	
	
}
