package com.techprowed.day08;

import com.techprowed.testData.DummyTestData;
import com.testBase.DummyTestBase;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class getRequest13 extends DummyTestBase {


    @Test
    public void test(){





        spec03.pathParam("parametre1","employees");

        DummyTestData expectedObje=new DummyTestData();
        HashMap<String,Object>expectedDataMap=expectedObje.setUpTestData();
        System.out.println(expectedDataMap) ;


        Response response=given().
                accept("Application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

            //response.prettyPrint();

            HashMap<String,Object>actualDataMap=response.as(HashMap.class);

        System.out.println(actualDataMap);


       Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());


        Assert.assertEquals(expectedDataMap.get("besincicalisan"), ((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));

        Assert.assertEquals(expectedDataMap.get("calisansayisi"), ((List)actualDataMap.get("data")).size());

        int datasize = ((List)actualDataMap.get("data")).size();
        Assert.assertEquals(expectedDataMap.get("sondanikincicalisanmaasi"), ((Map)((List)actualDataMap.get("data")).get(datasize - 2)).get("employee_salary"));



        List<Integer> actualYasListesi = new ArrayList<Integer>();


        for(int i = 0; i < datasize; ++i) {
            actualYasListesi.add((Integer)((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age"));
        }

       // Assert.assertTrue(actualYasListesi.containsAll((List)expectedDataMap.get("arananyaslar")));


        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_name"),
                ((Map)((List)actualDataMap.get("data")).get(10)).get("employee_name"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_salary"),
                ((Map)((List)actualDataMap.get("data")).get(10)).get("employee_salary"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_age"), ((Map)((List)actualDataMap.get("data")).get(10)).get("employee_age"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("profile_image"), ((Map)((List)actualDataMap.get("data")).get(10)).get("profile_image"));




    }




}
