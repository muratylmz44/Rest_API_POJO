package com.techprowed.day05;

import com.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class   getRequest06  extends JsonPlaceHolderTestBase {


    @Test
    public void test() {
        spec01.pathParams("parametre1", "todos",
                "parametre2", 123);



        Response response = given().
                accept(ContentType.JSON).
                spec(spec01).
                when().
                get("/{parametre1}/{parametre2}");


        response.prettyPrint();




        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                header("Server", equalTo("cloudflare")).body("userId", equalTo((7)),
                "title" , equalTo("esse et quis iste est earum aut impedit"),
                "completed" ,equalTo(false));


    }

}