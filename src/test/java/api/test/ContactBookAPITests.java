package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.POJOClasses.UserDetails;
import api.endpoints.UserEndpoints;
import api.payload.UserInputs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ContactBookAPITests {

	UserEndpoints userEndpoints = new UserEndpoints();
	UserInputs userInputs = new UserInputs();

	@BeforeTest
	public void login() throws IOException {
		Response loginResponse = userEndpoints.loginUser();
		Assert.assertEquals(loginResponse.getStatusCode(), 200);

	}

	@Test
	public void createUser() throws IOException {
		Response createUserResponse = userEndpoints.addUser();
		System.out.println(createUserResponse.asString());
		JsonPath js = new JsonPath(createUserResponse.asString());
		Assert.assertEquals(createUserResponse.statusCode(), 201);

	}

	@Test
	public void getUserDetails() throws IOException {
		UserDetails getResponse = userEndpoints.getUser();
		Assert.assertEquals(getResponse.getFirstName(), "jithin");
		System.out.println(getResponse.getEmail());

	}
}
