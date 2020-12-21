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
        ApiUtil.actualCountry(18945);
        System.out.println(".............");

        ApiUtil.changeCountry(18945,"argentina",null);
    }

    @Then("verifies if actual one is updated")
    public void verifies_if_actual_one_is_updated() {
        Map<String,Object> req2= new HashMap<>();
        req2.put("id",18945);
        req2.put("name","argentina");
        req2.put("states",null);
        Response response=given().
                spec(spec01).
                auth().oauth2(ConfigReader.
                getProperty("token")).
                when().
                get("/18945");
        Map<String ,Object>actual=response.as(HashMap.class);
        Assert.assertEquals(req2.get("name"),actual.get("name").toString());


    }






}
