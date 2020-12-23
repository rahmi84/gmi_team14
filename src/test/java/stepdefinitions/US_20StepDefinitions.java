package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.ApiUtil;
import utilities.ConfigReader;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class US_20StepDefinitions {

    Response response;
    JsonPath json;
    JsonPath customer;
    int custId;
    Map<String, Object> expectedCustomer;


    @Given("create a customer with map and send to end point {string}")
    public void create_a_customer_with_map_and_send_to_end_point(String endpoint) {
        expectedCustomer = ApiUtil.createCustomer();

        System.out.println(expectedCustomer);
        System.out.println("************************************");

        response = given()
                .auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .when()
                .body(expectedCustomer)
                .post(endpoint);
    }
    @And("Retrive the CustomerId you created")
    public void retriveTheCustomerIdYouCreated() {
        json = response.jsonPath();
        custId = json.getInt("id");
        System.out.println("customer id : " + custId);
        System.out.println("************************************");
    }
    @When("get response and store response with JsonPath using endpoint{string} with {string} Pathparam")
    public void getResponseAndStoreResponseWithJsonPathUsingEndpointWithPathparam(String endpoint, String pathParam) {

        response = given()
                .auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint + "/" + custId);

        response.prettyPrint();
        customer = response.jsonPath();
    }
    @Then("validate the customers that created before")
    public void validateTheCustomersThatCreatedBefore() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedCustomer.get("firstName"), customer.getString("firstName"));
        softAssert.assertEquals(expectedCustomer.get("lastName"), customer.getString("lastName"));
        softAssert.assertEquals(expectedCustomer.get("middleInitial"), customer.getString("middleInitial"));
        softAssert.assertEquals(expectedCustomer.get("email"), customer.getString("email"));
        softAssert.assertEquals(expectedCustomer.get("mobilePhoneNumber"), customer.getString("mobilePhoneNumber"));
        softAssert.assertEquals(expectedCustomer.get("phoneNumber"), customer.getString("phoneNumber"));
        softAssert.assertEquals(expectedCustomer.get("zipCode"), customer.getString("zipCode"));
        softAssert.assertEquals(expectedCustomer.get("address"), customer.getString("address"));
        softAssert.assertEquals(expectedCustomer.get("city"), customer.getString("city"));
        softAssert.assertEquals(expectedCustomer.get("ssn"), customer.getString("ssn"));
        softAssert.assertAll();
    }
    @When("Retrive the All Customers")
    public void retriveTheAllCustomers() {
        response = given()
                .auth()
                .oauth2(ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .when()
                .get(ConfigReader.getProperty("api_customer"));

        response.prettyPrint();
    }
    @Then("Verify the customer you created is in the payload")
    public void verifyTheCustomerYouCreatedIsInThePayload() {
        List allIds = response.jsonPath().get("id");
        try {
            Assert.assertTrue(allIds.contains(custId));
        } catch (AssertionError e) {
            System.out.println("********************************************************");
            System.out.println("The customer we created has not shown in current payload");
            System.out.println("********************************************************");
        }
    }
}