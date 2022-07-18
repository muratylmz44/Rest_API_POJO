package com.techprowed.day06;

import com.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class getRequest07 extends HerokuAppTestBase {






    @Test
    public void test(){

        spec02= spec02.pathParams("parametre1","booking","parametre2","6" );


        Response response=given().
                accept("application/json").
                spec(spec02).
                when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();


        JsonPath jsonPath=response.jsonPath();

       // response.then().assertThat().statusCode(200).contentType(ContentType.JSON); istersen böyle

        assertEquals(200,response.statusCode()); // ister böyle

        //NOT assert kullanırken JUnit ve TestNG de expected ve actual sırası farklı olabilir
        // expected ilk sonra actual yada tam tersi olabilir.

        assertEquals("Eric",jsonPath.getString("firstname"));
        assertEquals("Jackson",jsonPath.getString("lastname"));
        assertEquals(182,jsonPath.getInt("totalprice"));
        assertFalse(jsonPath.getBoolean("depositpaid"));
        assertEquals("2016-11-11",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2021-11-04",jsonPath.getString("bookingdates.checkout"));





    }
}
