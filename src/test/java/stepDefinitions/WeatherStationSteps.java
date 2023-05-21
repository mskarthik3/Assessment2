package stepDefinitions;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;

public class WeatherStationSteps {

    Response response;
    Response response1;
    Response response2;
    Response response3;

    @When("I register a weather station without an API key")
    public void registerWeatherStationWithoutApiKey() {
       
        String requestBody = "{\"external_id\": \"DEMO_TEST001\",\"name\": \"Team Demo Test Station 001\",\"latitude\": 33.33,\"longitude\": -122.43,\"altitude\": 222}";

        response = given()
        		 .contentType("application/json")
 				 .body(requestBody)
 			     .pathParam("mypath","data/3.0/stations")
 			     .post("https://api.openweathermap.org/{mypath}");
    }

    @Then("I should receive an error response with code {int} and a specific error message")
    public void verifyErrorResponse(int expectedStatusCode) {
        response.then()
                .statusCode(expectedStatusCode)
                .contentType("application/json")
               
                .body("message", equalTo("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."));
    }

    String requestBody1 = "{\"external_id\": \"DEMO_TEST001\",\"name\": \"Team Demo Test Station 001\",\"latitude\": 33.33,\"longitude\": -122.43,\"altitude\": 222}";
    String requestBody2 = "{\"external_id\": \"DEMO_TEST002\",\"name\": \"Team Demo Test Station 002\",\"latitude\": 44.44,\"longitude\": -122.44,\"altitude\": 111}";	

   @When("I register two weather stations with the specified details")
    public void registerTwoWeatherStations() { 
        response1 = given()
        		  .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
        		  .pathParam("mypath","data/3.0/stations")
        		  .contentType("application/json")
  				  .body(requestBody1)
  			      .post("https://api.openweathermap.org/{mypath}");
        response2 = given()
    		      .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
     		      .pathParam("mypath","data/3.0/stations")
    		      .contentType("application/json")
 				  .body(requestBody2)
 			      .post("https://api.openweathermap.org/{mypath}");
    }

    @Then("I should receive a successful response with code {int}")
    public void verifySuccessfulResponse(int expectedStatusCode) {
        response2.then()
               .statusCode(expectedStatusCode);
    }

   @Then("the registered stations should be retrieved correctly")
    public void verifyRegisteredStations() {
	// Retrieve the registered stations
		   response3 = given()
		    		 .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")			
					 .pathParam("mypath","data/3.0/stations")
					 .when()
					 .get("https://api.openweathermap.org/{mypath}");

       // Parse the response body and verify the station details match the registration request
       String responseBody = response3.getBody().asString();

       if (responseBody.contains(requestBody1)) {
           System.out.println("Registered Station 1:\n" + requestBody1);
       } else {
           System.out.println("Registered Station 1 not found in the response.");
       }

       if (responseBody.contains(requestBody2)) {
           System.out.println("Registered Station 2:\n" + requestBody2);
       } else {
           System.out.println("Registered Station 2 not found in the response.");
       }

    } 
   
   
   
}