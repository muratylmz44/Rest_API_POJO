package com.techprowed.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getRequest04 {





    @Test
    public void test(){




        String url = "https://restful-booker.herokuapp.com/booking/6";


        Response response= given().
                accept("application/json").
                when().get(url);



        response.prettyPrint();




      response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Mark")).
                body("lastname", equalTo("Ericsson")).
                body("totalprice", equalTo(208)).
                body("depositpaid", equalTo(true)).
                body("bookingdates.checkin", equalTo("2016-04-13")).
                body("bookingdates.checkout", equalTo("2018-06-24"));





    }
}
