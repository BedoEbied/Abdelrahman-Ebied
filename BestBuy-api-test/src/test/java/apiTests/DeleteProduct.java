package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeleteProduct {

    @Test
    public void delete(){

        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3030/products/2");
        int code = response.getStatusCode();

        System.out.println("Status Code : " +code );

        Assert.assertEquals(200, code);

    }
}
