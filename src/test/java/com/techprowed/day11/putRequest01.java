package com.techprowed.day11;

import com.techprowed.testData.JsonPlaceHolderTestData;
import com.testBase.JsonPlaceHolderTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class putRequest01 extends JsonPlaceHolderTestBase {

    @Test
    public void test() {
        this.spec01.pathParams("parametre1", "todos", new Object[]{"parametre2", 198});
        JsonPlaceHolderTestData testObje = new JsonPlaceHolderTestData();
        JSONObject expectedRequest = testObje.setUpPutData();
        System.out.println(expectedRequest);
        Response response =  RestAssured.
                given().contentType(ContentType.JSON).
                spec(this.spec01).auth().basic("admin", "password123").
                body(expectedRequest.toString()).
                when().
                put("/{parametre1}/{parametre2}", new Object[0]);
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200L, (long)response.getStatusCode());
        Assert.assertEquals((long)expectedRequest.getInt("userId"), (long)json.getInt("userId"));
        Assert.assertEquals(expectedRequest.getString("title"), json.getString("title"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"), json.getBoolean("completed"));
    }




}
