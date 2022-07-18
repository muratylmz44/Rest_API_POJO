package com.techprowed.day07;

import com.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class getRequest10  extends DummyTestBase {


    @Test
    public void test() {


        spec03.pathParam("parametre1", "employees");
        Response response = given().
                accept("aplication/json").
                spec(spec03).
                when().
                get("/{parametre1}");


        response.prettyPrint();


        JsonPath jsonPath=response.jsonPath();



        Assert.assertEquals(200,response.statusCode());


        //Groovy language javanın bir alt dilidir.
        // Groovy ile loop kullanmadan hallettik data.findAll{it.id>10}.id


        List<Integer>  idlist=jsonPath.getList("data.findAll{it.id>10}.id");

        System.out.println(idlist);
        Assert.assertEquals(14,idlist.size());

        List<Integer>  yaslistesi=jsonPath.getList("data.findAll{it.employee_age<30}.employee_age");

        System.out.println(yaslistesi);

        List<String>  isimlistesi=jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");

        System.out.println(isimlistesi );


        Assert.assertTrue(isimlistesi.contains("Charde Marshall"));

        System.out.println(isimlistesi.contains("Charde Marshall"));


    }

}