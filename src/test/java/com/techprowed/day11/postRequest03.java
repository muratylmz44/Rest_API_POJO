package com.techprowed.day11;

import com.techprowed.testData.JsonPlaceHolderTestData;
import com.testBase.JsonPlaceHolderTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postRequest03 extends JsonPlaceHolderTestBase {

    @Test
    public void test() {
        this.spec01.pathParam("parametre1", "todos");
        JsonPlaceHolderTestData testObje = new JsonPlaceHolderTestData();
        JSONObject expectedRequest = testObje.setUpPostData();
        System.out.println(expectedRequest);
        Response response =  given().contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin", "password123").
                body(expectedRequest.toString()).
                when().
                post("/{parametre1}", new Object[0]);
        response.then().assertThat().statusCode(expectedRequest.getInt("statusCode")).body("completed",
                // Matchers Class
                equalTo(expectedRequest.getBoolean("completed")),
                new Object[]{"title", equalTo(expectedRequest.getString("title")), "userId",
                        equalTo(expectedRequest.getInt("userId"))});
        JsonPath json = response.jsonPath();


        // Json Class
        Assert.assertEquals((long)expectedRequest.getInt("statusCode"), (long)response.getStatusCode());
        Assert.assertEquals((long)expectedRequest.getInt("userId"), (long)json.getInt("userId"));
        Assert.assertEquals(expectedRequest.getString("title"), json.getString("title"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"), json.getBoolean("completed"));


        //Deserialization
        HashMap<String, Object> actualDataMap = (HashMap)response.as(HashMap.class);
        Assert.assertEquals(expectedRequest.getString("title"), actualDataMap.get("title"));
        Assert.assertEquals(expectedRequest.getInt("userId"), actualDataMap.get("userId"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"), actualDataMap.get("completed"));
    }


}
