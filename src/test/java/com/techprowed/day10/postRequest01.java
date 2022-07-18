package com.techprowed.day10;

import com.techprowed.testData.DummyTestData;
import com.testBase.DummyTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class postRequest01 extends DummyTestBase {

    @Test
    public void test() {
        spec03.pathParam("parametre1", "create");
        DummyTestData obje = new DummyTestData();
        HashMap<String, String> requestBodyMap = obje.setupRequestBody();
        HashMap<String, Object> expectedDataMap = obje.setUpExpectedData();
        Response response = given().
                accept("application/json").
                spec(spec03).auth().basic("admin", "password123").
                body(requestBodyMap).when().post("/{parametre1}");
        response.prettyPrint();
        HashMap<String, Object> actualDataMap = (HashMap)response.as(HashMap.class);
        Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());
        Assert.assertEquals(expectedDataMap.get("status"), actualDataMap.get("status"));
        Assert.assertEquals(expectedDataMap.get("message"), actualDataMap.get("message"));



        JsonPath json = response.jsonPath();
        Assert.assertEquals(expectedDataMap.get("status"), json.getString("status"));
        Assert.assertEquals(expectedDataMap.get("message"), json.getString("message"));
    }
}
