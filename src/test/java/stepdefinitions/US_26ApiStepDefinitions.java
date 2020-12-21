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
        System.out.println(".............");

        ApiUtil.changeCountry(18946,"kenya",null);
    }

    @Then("verifies if actual one is updated")
    public void verifies_if_actual_one_is_updated() {
        Map<String,Object> req2= new HashMap<>();
        req2.put("id",18946);
        req2.put("name","kenya");
        req2.put("states",null);
        Response response=given().
                spec(spec01).
                auth().oauth2(ConfigReader.
                getProperty("token")).
                when().
                get("/18946");
        Map<String ,Object>actual=response.as(HashMap.class);
        Assert.assertEquals(req2.get("name"),actual.get("name").toString());


    }

    @Given("user goes to end point {string}")
    public void user_goes_to_end_point(String end_point) {
//       response= given().contentType(ContentType.JSON).auth().
//                oauth2(ConfigReader.getProperty("token")).
//                when().get("https://www.gmibank.com/api/tp-countries");
//        response.prettyPrint();


     //  Driver.changeCountry(18937,"kayseri",null);
//        spec01=new RequestSpecBuilder().
//                setBaseUri("https://www.gmibank.com/api/tp-countries").
//                build();
//
//
//        Map<String,Object> req= new HashMap<>();
//        req.put("id",18937);
//        req.put("name","como");
//        req.put("states",null);
//
//        Response response=given().
//                contentType(ContentType.JSON).
//                spec(spec01).
//                auth().oauth2(ConfigReader.getProperty("token")).
//                body(req).when().put();
//        response.prettyPrint();

    }




}
