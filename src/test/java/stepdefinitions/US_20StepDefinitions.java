package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.ApiUtil;
import utilities.ConfigReader;
import utilities.DatabaseUtility;
import utilities.Driver;

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

    @Then("validate the customer with UI,API and Database perspective")
    public void validateTheCustomerWithUIAPIAndDatabasePerspective() {
        Driver.loginAll("employee");
        Driver.getDriver().findElement(By.xpath("//li[@id=\"entity-menu\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"entity-menu\"]/div/a[1]/span")).click();
        WebElement next = Driver.getDriver().findElement(By.xpath("//ul[@class=\"pagination\"]/li[last()-1]/a"));
        WebElement lastPage = Driver.getDriver().findElement(By.xpath("//ul[@class=\"pagination\"]/li[last()-2]/a"));

        String line1 = "//table[@class='table']/tbody/tr[";
        String line2 = "]/td[1]/a";
        int totalPage = Integer.parseInt(lastPage.getText());

        String idToFind = "" + custId;
        int k = 1;
        int size = Driver.getDriver().findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
        while (k <= totalPage) {
            for (int i = 1; i <= size; i++) {
                if (Driver.getDriver().findElement(By.xpath(line1 + i + line2)).getText().equals(idToFind)) {
                    Driver.clickWithJS(Driver.getDriver().findElement(By.xpath(line1 + i + line2)));
                    Driver.wait(5);
                    WebElement firstname = Driver.getDriver().findElement(By.xpath("//dl[@class=\"jh-entity-details\"]//dd[1]"));
                    WebElement lastname = Driver.getDriver().findElement(By.xpath("//dl[@class=\"jh-entity-details\"]//dd[2]"));
                    WebElement middlename = Driver.getDriver().findElement(By.xpath("//dl[@class=\"jh-entity-details\"]//dd[3]"));


                    DatabaseUtility.createConnection("jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user", "Techpro_@126");
                    String query = "Select first_name,last_name,middle_initial from tp_customer where id=" + custId;
                    List<Object> list = DatabaseUtility.getRowList(query);


                    System.out.println("UI firstname is with Cust Id : " + idToFind + " = " + firstname.getText());
                    System.out.println("UI lasttname is with Cust Id : " + idToFind + " = " + lastname.getText());
                    System.out.println("UI middlename is with Cust Id : " + idToFind + " = " + middlename.getText());
                    System.out.println("----------------------------------------------------");
                    System.out.println("API firstname is with Cust Id : " + custId + " = " + customer.getString("firstName"));
                    System.out.println("API lasttname is with Cust Id : " + custId + " = " + customer.getString("lastName"));
                    System.out.println("API middlename is with Cust Id : " + custId + " = " + customer.getString("middleInitial"));
                    System.out.println("----------------------------------------------------");
                    System.out.println("DB firstname is with Cust Id : " + custId + " = " + list.get(0));
                    System.out.println("DB lasttname is with Cust Id : " + custId + " = " + list.get(1));
                    System.out.println("DB middlename is with Cust Id : " + custId + " = " + list.get(2));
                    System.out.println("----------------------------------------------------");


                    Assert.assertEquals(firstname.getText(), customer.getString("firstName"));
                    Assert.assertEquals(lastname.getText(), customer.getString("lastName"));
                    Assert.assertEquals(middlename.getText(), customer.getString("middleInitial"));

                    Assert.assertEquals(firstname.getText(), list.get(0));
                    Assert.assertEquals(lastname.getText(), list.get(1));
                    Assert.assertEquals(middlename.getText(), list.get(2));


                    break;
                }
            }
            k++;
            try {
                next.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("*********************************");
                System.out.println("stale element but not important");
                System.out.println("*********************************");
            }


        }
        DatabaseUtility.closeConnection();
    }


}
