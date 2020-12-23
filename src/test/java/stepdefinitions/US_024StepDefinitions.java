package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.junit.Assert;
import utilities.ConfigReader;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.entity.ContentType.*;

public class US_024StepDefinitions {
    Response response;
    JsonPath json;
    Map<String, Object> expectedstate = new HashMap<>();


    @Given("create a state with map and send to end point{string}")
    public void createAStateWithMapAndSendToEndPoint(String endpoint) {
        expectedstate.put("id", "");
        expectedstate.put("name", "ohioColumbus");
        expectedstate.put("tpcountry", null);
        System.out.println(expectedstate);
        Response expectedCountry = response = given()
                .auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(JSON)
                .when()
                .body(expectedstate)
                .post(endpoint);
        response.prettyPrint();

        expectedCountry.then()
                .contentType(JSON)
                .statusCode(201);
        expectedCountry.prettyPrint();
    }




    @And("get response and store response with JsonPath using endpoint {string}")
    public void getResponseAndStoreResponseWithJsonPathUsingEndpoint(String url) { response = given()
            .auth()
            .oauth2(ConfigReader.getProperty("token"))
            .contentType(JSON)
            .get(url);
        response.prettyPrint();
        json = response.jsonPath();
    }
    @Then("validate the state that created before")
    public void validateTheStateThatCreatedBefore() {
        String id = json.getString("id");
        if (id != null) {
            Assert.assertTrue("state is exist",id.contains((CharSequence)expectedstate.get("id")));
        }
    }
}






















