package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.States;
import utilities.ConfigReader;
import utilities.ReadToTxt;
import utilities.WriteToTxt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class US_022_StepDefinitions {
    Response response;
    States[] states;
    String filePath = "AllStatesData.txt";
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
    public void user_sets_the_states_to_response_using(String statesUrl) {
        response=given().headers(
                "Authorization",
                "Bearer "+ ConfigReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().
                        get(statesUrl).
                        then().
                        contentType(ContentType.JSON).
                        extract().
                        response();
        response.prettyPrint();

    }

    @And("user deserialization all states to pojo")
    public void user_deserialization_all_states_to_pojo() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        states=objectMapper.readValue(response.asString(),States[].class);
   //     list=response.as(ArrayList.class);
        json=response.jsonPath();
    }
//
//    @And("user saves the states to correspondent files")
//    public void user_saves_the_states_to_correspondent_files() {
//        WriteToTxt.saveAllStates(filePath,states);

  //  }

//    @Then("user validates the all states {int} by {int}")
//    public void user_validates_the_all_states_by(Integer id, Integer states) {
//        List<States> list = ReadToTxt.returnAllStates2(filePath);
////        System.out.println(list.get(331).getId());
//
//    }

    @Then("Verify state id {string} is {string}")
    public void verify_state_id_is(String id, String state) {

        list= json.getList("$");
        System.out.println(list);

        for(Map<String,Object> w: list){
            if (w.get("name")!=null && w.get("name").equals("Lowa")){
                Assert.assertEquals(59950,w.get("id"));
                break;
            }

        }
    }
}
