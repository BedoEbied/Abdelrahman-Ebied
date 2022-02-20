package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FindStore {

    @Test
    public void findByID(){

        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3030/stores/4");

        int code = response.getStatusCode();

        Assert.assertEquals(200,code);
    }
    @Test
    public void findByStoreName(){

        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3030/stores?name[$like]=*Richfield*");

        int code = response.getStatusCode();
        Assert.assertEquals(200,code);
    }
}
