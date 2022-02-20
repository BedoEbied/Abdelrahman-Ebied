package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class UpdateProduct {

    @Test
    public void update(){

        // Building up the request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type: application/json","Accept: application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("price",10);
        request.body(requestParams.toString());

        Response response = request.patch("http://localhost:3030/products/150115");
        int code = response.getStatusCode();

        System.out.println("Status Code : " +code );

        Assert.assertEquals(200, code);
    }
}
