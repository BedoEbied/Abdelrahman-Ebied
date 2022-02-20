package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ListProducts {

    @Test
    public void findAll(){

        Response response = RestAssured.get("http://localhost:3030/products");
        int code = response.getStatusCode();
        System.out.println("Status code: " +code);

        Assert.assertEquals(200,code);
    }



}
