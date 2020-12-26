package utilities;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtil {
    protected static RequestSpecification spec01 = new RequestSpecBuilder().
            setBaseUri("https://www.gmibank.com/api/tp-countries").
            build();
    static Response response;


    public static void changeCountry(Integer id, String country, String states) {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://www.gmibank.com/api/tp-countries").
                build();
        Map<String, Object> req = new HashMap<>();
        req.put("id", id);
        req.put("name", country);
        req.put("states", states);
        Response response = given().contentType(ContentType.JSON).
                spec(spec01).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(req).when().put();
        response.prettyPrint();


    }

    public static void callCountries() {

        response = given().auth().
                oauth2(ConfigReader.
                        getProperty("token")).
                when().get(ConfigReader.getProperty("api_countries"));
        response.prettyPrint();


    }

    public static void actualCountry(int param) {
        spec01.pathParam("id", param);
        response = given().spec(spec01).
                auth().oauth2(ConfigReader.
                getProperty("token")).when().get("/{id}");
        response.prettyPrint();


    }

    public static void createCountry(Integer id, String country, String states) {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://www.gmibank.com/api/tp-countries").
                build();
        Map<String, Object> req = new HashMap<>();
        req.put("id", id);
        req.put("name", country);
        req.put("states", states);
        Response response = given().contentType(ContentType.JSON).
                spec(spec01).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(req).when().post();
        response.prettyPrint();

    }

    public static LinkedHashMap<String,Object> createCustomer(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleInitial = faker.name().nameWithMiddle().substring(0, 1).toUpperCase();
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@gmail.com";
        String mobilePhoneNumber = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4);
        String phoneNumber = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4);
        String zipCode = faker.number().digits(5);
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String ssn = faker.idNumber().ssnValid();
        Boolean zelleEnrolled = faker.bool().bool();

        LinkedHashMap<String,Object> customer = new LinkedHashMap<>();
        customer.put("id", null);
        customer.put("firstName", firstName);
        customer.put("lastName", lastName);
        customer.put("middleInitial", middleInitial);
        customer.put("email", email);
        customer.put("mobilePhoneNumber", mobilePhoneNumber);
        customer.put("phoneNumber", phoneNumber);
        customer.put("zipCode", zipCode);
        customer.put("address", address);
        customer.put("city", city);
        customer.put("ssn", ssn);
        customer.put("zelleEnrolled", zelleEnrolled);
        customer.put("country", null);
        customer.put("user", null);

        return customer;

    }
}
