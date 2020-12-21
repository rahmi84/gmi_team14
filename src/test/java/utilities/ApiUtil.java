package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtil {
    protected static RequestSpecification  spec01=new RequestSpecBuilder().
            setBaseUri("https://www.gmibank.com/api/tp-countries").
            build();
    static Response response;


    public static void changeCountry(Integer id,String country,String states){
        spec01=new RequestSpecBuilder().
                setBaseUri("https://www.gmibank.com/api/tp-countries").
                build();
        Map<String,Object> req= new HashMap<>();
        req.put("id",id);
        req.put("name",country);
        req.put("states",states);
        Response response=given().contentType(ContentType.JSON).
                spec(spec01).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(req).when().put();
        response.prettyPrint();


    }
    public static void callCountries(){

        response=given().auth().
                oauth2(ConfigReader.
                        getProperty("token")).
                when().get(ConfigReader.getProperty("api_countries"));
        response.prettyPrint();


    }
    public static void actualCountry(int param){
        spec01.pathParam("id",param);
           response =given().spec(spec01).
                   auth().oauth2(ConfigReader.
                   getProperty("token")).when().get("/{id}");
           response.prettyPrint();


    }
}
