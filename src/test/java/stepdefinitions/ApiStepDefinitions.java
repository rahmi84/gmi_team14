package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.*;



public class ApiStepDefinitions {


    @Given("user goes to end point {string}")
    public void user_goes_to_end_point(String end_point) {
        Response response=given().
                          auth().
                          oauth2(ConfigReader.getProperty("token")).
                          contentType(ContentType.JSON).
                          when().get(end_point);
 response.prettyPrint();
 response.then().statusCode(200).contentType(ContentType.JSON);
    }

    @Given("recieve all the data")
    public void recieve_all_the_data() {

    }


}
