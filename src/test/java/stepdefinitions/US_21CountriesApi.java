package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Country;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class US_21CountriesApi {

    Response response;
    String filePath=ConfigReader.getProperty("api_countries");
    String bearerToken=ConfigReader.getProperty("token");
    Country[] country;

    @Given("user read all countries and sets response using api end point {string}")
    public void user_read_all_countries_and_sets_response_using_api_end_point(String api_endpoint) {
        Response response=given().
                auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .response();
     //   response.prettyPrint();

    }

    @Given("user deserialization countries data json to pojo")
    public void user_deserialization_countries_data_json_to_pojo() throws IOException {

        ObjectMapper objectMapper=new ObjectMapper();
        country=objectMapper.readValue(response.asString(),Country[].class);
        for (int i=0; i<country.length;i++){
            System.out.println("name"+" "+country[i].getName());

        }


    }

    @Then("user validates all countries data")
    public void user_validates_all_countries_data() {

    }


}
