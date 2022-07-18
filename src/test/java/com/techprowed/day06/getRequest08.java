package com.techprowed.day06;

import com.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class getRequest08 extends DummyTestBase {



    @Test
    public void test(){

        spec03.pathParam("parametre1","employees");


        Response response=given().
                accept("aplication/json").
                spec(spec03).
                when().
                get("/{parametre1}");


       // response.prettyPrint();


        JsonPath jsonPath=response.jsonPath();


        //System.out.println(jsonPath.getList("data.employee_name"));

       // System.out.println(jsonPath.getString("data[2].employee_name"));  // her ikiside uygun
       // System.out.println(jsonPath.getString("data.employee_name[2]")); // olur


        //System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4]")); // buda makul ama dinamik değil
        System.out.println(jsonPath.getString("data.employee_name[-1]"));


        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("Doris Wilder",jsonPath.getString("data.employee_name[-1]"));





    }


}
