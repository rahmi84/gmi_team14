package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
public class US_0025StepDefinition {
    Response response;
    JsonPath expectedjson;
    JsonPath json;
    Map<String, Object> reqBody = new HashMap<>();

    @Given("create a country with map and send to end point{string}")
    public void createACountryWithMapAndSendToEndPoint(String endpoint) {
        reqBody.put("id", " ");
        reqBody.put("name", "India54");
        reqBody.put("states", null);
        System.out.println(reqBody);
        Response expectedCountry = response = given()
                .auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .post(endpoint);
        response.prettyPrint();
        expectedCountry.then()
                .contentType(ContentType.JSON)
                .statusCode(201);
        expectedCountry.prettyPrint();
         expectedjson = expectedCountry.jsonPath();
    }

    @And("get response and store response with JsonPath using endpoint{string}")
    public void getResponseAndStoreResponseWithJsonPathUsingEndpoint(String url) {
        response = given()
                .auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .get(url);
        response.prettyPrint();
        json = response.jsonPath();
    }

    //    @And("validate the country that created before")
//    public void validate_the_country_that_created_before() {
//        String id = json.getString("id");
//        System.out.println(id);
//        if (id != null) {
//            Assert.assertTrue("country is exist",id.contains("60767"));
//        }
//    }
    @Then("validate the country that created before")
    public void validate_the_country_that_created_before() {
        String id = json.getString("id");
        String expectedId = expectedjson.getString("id");
        System.out.println(id);
        System.out.println("=========");
        System.out.println(expectedjson.getString("id"));
        if (id != null) {
            Assert.assertTrue("country is exist", id.contains(expectedjson.getString("id")));
        }


//        @Then("delete the country that created before using end point{string} with extension{string}")
//        public void deleteTheCountryThatCreatedBeforeUsingEndPointWithExtension (String endpoint, String id){
//            Response expectedCountry = response = given()
//                    .auth()
//                    .oauth2(ConfigReader.getProperty("token"))
//                    .contentType(ContentType.JSON)
//                    .when()
//                    .delete(endpoint + id);
//        }
    }
}
