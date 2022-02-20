package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateService {

    @Test
    public void create(){

        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");
        requestParams.put("name", "Test Service");
        request.body(requestParams.toJSONString());

        Response response = request.post("http://localhost:3030/services");
        ResponseBody body = response.getBody();
        int code = response.getStatusCode();

        System.out.println(body.asPrettyString());
        Assert.assertEquals(201, code);



    }
}
