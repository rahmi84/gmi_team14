package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class US_23stepDefinitionsAPI {
    Response response;
    JsonPath jsonPath;
    List<Map<String, Object>> allApplcntData;
    @Given("Use API end point for applicants {string}")
    public void use_API_end_point_for_applicants(String endPointUrl) {

         response= given().
                       accept(ContentType.JSON).
                       auth().oauth2(ConfigReader.getProperty("token")).
                when().get(endPointUrl);

         response.then().assertThat().statusCode(200);
         jsonPath=response.jsonPath();
    }

    @And("get all applicants' information as Deserialization")
    public void get_all_applicants_information_as_Deserialization() {
        allApplcntData= jsonPath.getList("$");
        System.out.println("Java List Map response: "+allApplcntData);
        System.out.println("First customer info: "+allApplcntData.get(0));
        System.out.println("First customer's first name: "+allApplcntData.get(0).get("firstName"));

    }

    @And("find out how many applicants are here and verify it")
    public void find_out_how_many_applicants_are_here_and_verify_it() {
        Integer actualApplcntscount=allApplcntData.size();
        System.out.println(actualApplcntscount);
        Assert.assertEquals(1659,actualApplcntscount.intValue());
    }

    @And("get all the information of the fifth applicant")
    public void get_all_the_information_of_the_fifth_applicant() {
       allApplcntData.get(4);
    }

    @And("verify fifth applicant's ssn is {string} and address is {string}")
    public void verify_fifth_applicant_s_ssn_is_and_address_is(String expectedSsn ,String expectedAddress) {
     String actualSsn= allApplcntData.get(4).get("ssn").toString();
     Assert.assertEquals(expectedSsn,actualSsn);
     String actualAddress=allApplcntData.get(4).get("address").toString();
     Assert.assertEquals(expectedAddress,actualAddress);
    }

    @And("verify first customer's firstName {string} \\(us23)")
    public void verify_first_customer_s_firstName_us23(String firstName) {
        String actualFirstName= allApplcntData.get(0).get("firstName").toString();
        Assert.assertEquals(firstName,actualFirstName);
    }

    @And("verify second customer's lastName {string} \\(us23)")
    public void verify_second_customer_s_lastName_us23(String lastName) {
        String actualLastName= allApplcntData.get(1).get("firstName").toString();
        Assert.assertEquals(lastName,actualLastName);
    }

    @And("verify third customer's phoneNumber {string} \\(us23)")
    public void verify_third_customer_s_country_us23(String phoneNumber) {
      String actualPhoneNumber=allApplcntData.get(2).get("mobilePhoneNumber").toString();
      Assert.assertEquals(phoneNumber,actualPhoneNumber);
    }

    @And("verify last customer's user email {string} \\(us23)")
    public void verify_last_customer_s_user_email_us23(String email) {
    String actualEmail=allApplcntData.get(allApplcntData.size()-1).get("email").toString();
    Assert.assertEquals(email,actualEmail);
    }


}
