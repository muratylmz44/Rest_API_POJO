package com.techprowed.day06;

import com.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class getRequest09 extends DummyTestBase {




    @Test
    public void test(){


        spec03.pathParam("parametre1","employees");
        Response response=given().
                accept("aplication/json").
                spec(spec03).
                when().
                get("/{parametre1}");


        response.prettyPrint();


        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(200,response.statusCode());
       // Assert.assertTrue(response.statusCode()==200); //buda olur

        System.out.println(jsonPath.getList("data.id").size());
        Assert.assertEquals(24,jsonPath.getList("data.id").size());

        Assert.assertEquals("Airi Satou",jsonPath.getString("data[4].employee_name"));

        Assert.assertEquals(372000,jsonPath.getInt("data[5].employee_salary"));


        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));


        //List<Integer>arananyaslar= Arrays.asList(21,23,61);  // ikiside olur



        List<Integer>arananyaslar=new ArrayList<>();  // buda olur
        arananyaslar.add(21);
        arananyaslar.add(23);
        arananyaslar.add(61);


        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(arananyaslar));



    }


}
