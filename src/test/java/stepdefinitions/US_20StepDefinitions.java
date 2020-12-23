package stepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import pojo.Customer;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        Faker faker = new Faker();
        int id = Integer.parseInt(faker.number().digits(5));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleInitial = faker.name().nameWithMiddle().substring(0, 1).toUpperCase();
        String email = firstName + lastName + "@gmail.com";
        String mobilePhoneNumber = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4);
        String phoneNumber = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4);
        String zipCode = faker.number().digits(5);
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String ssn = faker.idNumber().ssnValid();
        Boolean zelleEnrolled = faker.bool().bool();
//      String accounts = faker.number().digits(7);

        Map<String, Object> expectedCustomer = new LinkedHashMap<>();
        expectedCustomer.put("id", null);
        expectedCustomer.put("firstName", firstName);
        expectedCustomer.put("lastName", lastName);
        expectedCustomer.put("middleInitial", middleInitial);
        expectedCustomer.put("email", email);
        expectedCustomer.put("mobilePhoneNumber", mobilePhoneNumber);
        expectedCustomer.put("phoneNumber", phoneNumber);
        expectedCustomer.put("zipCode", zipCode);
        expectedCustomer.put("address", address);
        expectedCustomer.put("city", city);
        expectedCustomer.put("ssn", ssn);
        expectedCustomer.put("zelleEnrolled", zelleEnrolled);
//       expectedCustomer.put("accounts", accounts);
        expectedCustomer.put("country", null);
        expectedCustomer.put("user", null);

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


    @And("Retrive the Customer with CustomerId you created")
    public void retriveThecustomerWithCustomerIdYouCreated() {
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
        softAssert.assertEquals(expectedCustomer.get("firstName"), customer.getString("firstname"));
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
}
