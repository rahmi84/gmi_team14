

package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.States;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


import static io.restassured.RestAssured.*;

public class US_27_StepDefinitions {
    Response response;
    JsonPath jsonPath;
    Response responseAll;
    States states = new States("SONstate", null, null);




    @Given("user post  a new state to end point")
    public void userPosttANewStateToEndPoint() {
        response = given()
                .headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty("token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .body(states)
                .post("https://www.gmibank.com/api/tp-states")
                .then()
                .statusCode(201)
                .extract()
                .response();
//response.prettyPrint();

    }
    @When("user deserialization state data  json to java pojo")
    public void userDeserializationnStateDataJsonToJavaPojo() {
        jsonPath = response.jsonPath();
        response.prettyPrint();
    }


    @Given("user deletes a state using endpoint {string} and its extension {string}")
    public void userDeletesAStateUsingEndpointAndItsExtension(String endpoint, String id) {
        Response response =given().headers(
                "Authorization",
                "Bearer " + ConfigReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .delete(endpoint+id)
                .then()
                .extract()
                .response();

        responseAll=given().headers(
                "Authorization",
                "Bearer " + ConfigReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        JsonPath jsonPath=responseAll.jsonPath();

        String idAll=jsonPath.getString("id");


        Assert.assertFalse("not verify",idAll.contains(id));


    }
}