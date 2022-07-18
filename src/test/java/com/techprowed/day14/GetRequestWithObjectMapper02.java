package com.techprowed.day14;

import com.techprowed.utilities.JsonUtil;
import com.testBase.HerokuAppTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper02 extends HerokuAppTestBase {


    public GetRequestWithObjectMapper02() {
    }

    @Test
    public void test() {
        spec02.pathParams("parametre1", "booking", new Object[]{"parametre2", 2});
        String jsonData =
                "{\n\"" +
                        "firstname\":" + " \"Александр\"," + "\n\"" +
                        "lastname\": \"Тест\",\n\"" +
                        "totalprice\": 200,\n\"" +
                        "depositpaid\": true,\n\"" +
                        "bookingdates\": {\n\"" +
                        "checkin\": \"2022-06-12\",\n\"" +
                        "checkout\": \"2022-06-14\"\n},\n\"" +
                        "additionalneeds\": \"" +
                        "Breakfast\"\n}";
        HashMap<String, Object> expectedData = (HashMap) JsonUtil.convertJsonToJava(jsonData, HashMap.class);
        System.out.println(expectedData);
        Response response = given().contentType(ContentType.JSON).spec(spec02).when().get("/{parametre1}/{parametre2}", new Object[0]);
        response.prettyPrint();
        HashMap<String, Object> actualData = (HashMap)JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
        Assert.assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));
    }







}
