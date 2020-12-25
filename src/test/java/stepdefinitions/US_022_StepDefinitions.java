package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class US_022_StepDefinitions {
    Response response;
    JsonPath json;
    List<Map<String,Object>> list;

    @Given("Get data from states end point {string} and create the states using {string} and {string}")
    public void get_data_from_states_end_point_and_create_the_states_using_and(String statesUrl, String type, String state) {
//        response=given().headers(
//                "Authorization",
//                "Bearer "+ ConfigReader.getProperty("token"),
//                "Content-Type",
//                        ContentType.JSON)
//                       .when().
//                        body("{\""+type+"\":\""+state+"\"}").
//                        post(statesUrl).
//                        then().
//                        contentType(ContentType.JSON).
//                        extract().
//                        response();
//       response.prettyPrint();

    }



    @Given("user sets the states to response using {string}")
    public void user_sets_the_states_to_response_using(String states_url) {
        response=given().auth().oauth2(ConfigReader.getProperty("token"))
                .when().
                        get(states_url);
        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);

 //       response.prettyPrint();

    }

    @And("user deserialization all states Json to Java")
    public void user_deserialization_all_states_Json_to_Java() throws IOException {

        json = response.jsonPath();
        list = response.as(ArrayList.class);
    }


    @Then("Validate your created all states one by one")
    public void Validate_your_created_all_states_one_by_one() {

        list= json.getList("$");
        System.out.println(list);

        for(Map<String,Object> w: list) {
            if (w.get("name") != null && w.get("name").equals("Maine")) {
                Assert.assertEquals(59949, w.get("id"));
            }

        }

        for(Map<String,Object> w2: list) {
            if (w2.get("name") != null && w2.get("name").equals("Lowa")) {
                Assert.assertEquals(59950, w2.get("id"));
            }

        }


    }

}