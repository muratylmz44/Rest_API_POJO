package com.techprowed.day12;

import com.techprowed.testData.DummyTestData;
import com.testBase.DummyTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class deleteRequest extends DummyTestBase {

    @Test
    public void test() {
        spec03.pathParams("parametre1", "delete", new Object[]{"parametre2", 2});
        DummyTestData testData = new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteExpectedData();

        Response response =  given().contentType(ContentType.JSON).
                spec(spec03).auth().basic("admin", "password123").
                when().
                delete("/{parametre1}/{parametre2}", new Object[0]);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).
                body("status",
                equalTo(expectedData.getString("status")), new Object[]{"data", equalTo(expectedData.getString("data")),
                                "message", equalTo(expectedData.getString("message"))});
    }




}
