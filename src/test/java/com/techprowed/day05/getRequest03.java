package com.techprowed.day05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getRequest03 {



    @Test
    public void test() {
        String url = "https://restful-booker.herokuapp.com/booking/7";


       Response response= given().
               accept("application/json").
               when().get(url);



       response.prettyPrint();




       response.then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON).
               body("firstname", equalTo("Mary")).
               body("lastname", equalTo("Brown")).
               body("totalprice", equalTo(745)).
               body("depositpaid", equalTo(true)).
               body("bookingdates.checkin", equalTo("2017-11-06")).
               body("bookingdates.checkout", equalTo("2020-09-27"));










    }

    }