package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigReader;
import utilities.Driver;

import static io.restassured.RestAssured.*;



public class ApiStepDefinitions {
    Response response;
    Driver driver;


    @Given("user goes to end point {string}")
    public void user_goes_to_end_point(String end_point) {
      // response= given().contentType(ContentType.JSON).auth().
           //     oauth2(ConfigReader.getProperty("token")).
           //     when().get("https://www.gmibank.com/api/tp-countries");
       // response.prettyPrint();
       Driver.changeCountry(18936,"Turkey","");

    }

    @Given("recieve all the data")
    public void recieve_all_the_data() {

    }


}
