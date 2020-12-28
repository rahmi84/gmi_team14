package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.ApiUtil;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;



public class US_26ApiStepDefinitions extends ApiUtil {
    Response response;
    Driver driver;


    @Given("user goes to end point and change any user's country")
    public void user_goes_to_end_point_and_change_any_user_s_country() {

        ApiUtil.actualCountry(18946);
        System.out.println("after update");

        ApiUtil.changeCountry(18946,"argentina",null);
    }

    @Then("verifies if actual one is updated")
    public void verifies_if_actual_one_is_updated() {
        Map<String,Object> req2= new HashMap<>();
        req2.put("id",18946);
        req2.put("name","argentina");
        req2.put("states",null);
        spec01.pathParam("id","18946");
        Response response=given().
                spec(spec01).
                auth().oauth2(ConfigReader.
                getProperty("token")).
                when().
                get("/{id}");
        Map<String ,Object>actual=response.as(HashMap.class);
        Assert.assertEquals(req2.get("name"),actual.get("name"));


    }






}
