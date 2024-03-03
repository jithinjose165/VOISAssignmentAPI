package api.payload;

import java.util.Random;

import api.POJOClasses.UserDetails;

public class UserInputs {
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	
	public String getLogin() {
		return "{\r\n"
				+ "    \"email\": \"jithin6@gmail.com\",\r\n"
				+ "    \"password\": \"Testtest@123\"\r\n"
				+ "}";
		
	}
	public String createUser() {
		Random rand = new Random();
		   
       
        int rand_int1 = rand.nextInt(1000);
         firstName="gloria";
         lastName="User";
         email = "gloria"+rand_int1+"@gmail.com";
         password = "myPassword";
       
   
        
		return "{\r\n"
			+ "    \"firstName\": \""+firstName+"\",\r\n"
				+ "    \"lastName\": \""+lastName+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
			+ "    \"password\": \""+password+"\"\r\n"
				+ "}";
	}
}
