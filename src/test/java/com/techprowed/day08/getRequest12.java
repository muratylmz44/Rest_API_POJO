package com.techprowed.day08;

import com.techprowed.testData.HerokuappTestData;
import com.testBase.HerokuAppTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class getRequest12 extends HerokuAppTestBase {



    @Test
    public void test(){


        spec02.pathParams("parametre1","booking","parametre2",9);


        HerokuappTestData expectedObje= new HerokuappTestData();
        HashMap<String,Object>expectedDataMap=expectedObje.setUpTestData();
        System.out.println("expectedDataMap"+expectedDataMap);


        Response response =given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{parametre1}/{parametre2}");

       // response.prettyPrint();

        HashMap<String, Object> actualDataMap = response.as(HashMap.class);

        System.out.println("actualDataMap"+actualDataMap);


        Assert.assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));

        Assert.assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"),
                ((Map)actualDataMap.get("bookingdates")).get("checkin"));

        Assert.assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"),
                ((Map)actualDataMap.get("bookingdates")).get("checkout"));



            // 2.Yol JsonPath
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(expectedDataMap.get("firstname"),jsonPath.getString("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"),jsonPath.getString("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"),jsonPath.getInt("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"),jsonPath.getBoolean("depositpaid"));

        Assert.assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"),
                jsonPath.getString("bookingdates.checkin"));

        Assert.assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"),
                jsonPath.getString("bookingdates.checkout"));






    }




}
