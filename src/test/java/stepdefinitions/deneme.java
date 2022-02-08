package stepdefinitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utilities.ApiUtil;

import static io.restassured.RestAssured.given;

public class deneme {

    @Test
    public void dene1(){

        Response response = given()
                .auth()
                .oauth2(ApiUtil.getToken("Admin"))
                .contentType(ContentType.JSON)
                .when()
                .get("https://www.gmibank.com/api/tp-customers").prettyPeek();
        System.out.println("###########################################");
        String jsonString=response.asString();
        System.out.println(jsonString);

        String compare="[{\"id\":42688,\"firstName\":\"Reanna\",\"lastName\":\"Grady\",\"middleInitial\":\"Wally Murazik Wiza\",\"email\":\"com.github.javafaker.Name@5d08976a@gmail.com\",\"mobilePhoneNumber\":\"401-652-5134\",\"phoneNumber\":\"272-817-1549\",\"zipCode\":\"67321\",\"address\":\"I live in St louis MO\",\"city\":\"St Louis\",\"ssn\":\"186-48-4946\",\"createDate\":\"2020-12-11T06:00:00Z\",\"zelleEnrolled\":false," +
                "\"country\":null,\"state\":\"\",\"user\":null,\"accounts\":null}]";
        Assert.assertTrue(jsonString.contains(compare));



    }
}
