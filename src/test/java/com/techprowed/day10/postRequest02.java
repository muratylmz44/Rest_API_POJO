package com.techprowed.day10;

import com.techprowed.testData.HerokuappTestData;
import com.testBase.HerokuAppTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class postRequest02 extends HerokuAppTestBase {


    @Test
    public void test() {
        this.spec02.pathParam("parametre1", "booking");
        HerokuappTestData testData = new HerokuappTestData();
        JSONObject expectedRequestData = testData.setUpTestAndRequestData();
        System.out.println(expectedRequestData);
        Response response =  given().
                contentType(ContentType.JSON).
                spec(spec02).auth().basic("admin", "password123").
                body(expectedRequestData.toString()).
                when().post("/{parametre1}", new Object[0]);
        HashMap<String, Object> actualDataMap = (HashMap)response.as(HashMap.class);
        System.out.println(actualDataMap);
        Assert.assertEquals(expectedRequestData.getString("firstname"), ((Map)actualDataMap.get("booking")).get("firstname"));
        Assert.assertEquals(expectedRequestData.getString("lastname"), ((Map)actualDataMap.get("booking")).get("lastname"));
        Assert.assertEquals(expectedRequestData.getInt("totalprice"), ((Map)actualDataMap.get("booking")).get("totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"), ((Map)actualDataMap.get("booking")).get("depositpaid"));

        // İç İçe Mapler için JSONObject kullnıyoruz.
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin"), ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout"), ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));
        JsonPath json = response.jsonPath();
        Assert.assertEquals(expectedRequestData.getString("lastname"), json.getString("booking.lastname"));
        Assert.assertEquals(expectedRequestData.getString("firstname"), json.getString("booking.firstname"));
        Assert.assertEquals((long)expectedRequestData.getInt("totalprice"), (long)json.getInt("booking.totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"), json.getBoolean("booking.depositpaid"));

        // İç İçe Mapler için JSONObject kullnıyoruz.
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin"), json.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout"), json.getString("booking.bookingdates.checkout"));
    }

}
