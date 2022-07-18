package com.techprowed.day05;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getRequest05 {






    @Test
    public void test(){

        String url ="https://dummy.restapiexample.com/api/v1/employees";


        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

       response.then().
               assertThat().
               statusCode(200).
               contentType("application/json").
               body("data.profile_image", hasSize(24),
                       "data.employee_name",
                       hasItem("Ashton Cox"),
                       "data.employee_age",
                       Matchers.hasItems(21, 61, 23));
    }





    }

