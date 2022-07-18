package com.techprowed.day09;

import com.techprowed.testData.DummyTestData;
import com.testBase.DummyTestBase;

import io.restassured.response.Response;


import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


public class getRequest13MatcherClass extends DummyTestBase {


    @Test
    public void test() {


        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Object> expectedDataMap = expectedObje.setUpTestData();
        System.out.println(expectedDataMap);


        Response response = given().
                accept("Application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

        //response.prettyPrint();

        response.then().assertThat().statusCode((Integer)expectedDataMap.get("statusCode")).body("data[4].employee_name", equalTo(expectedDataMap.get("besincicalisan")),
             //   "data.id", Matchers.hasSize((Integer)expectedDataMap.get("calisansayisi")),
                "data[-2].employee_salary", equalTo(expectedDataMap.get("sondanikincicalisanmaasi")),
               "data.employee_age",  hasItems(((List)expectedDataMap.get("arananyaslar")).get(0),
                        ((List<?>)expectedDataMap.get("arananyaslar")).get(1),
                        ((List<?>)expectedDataMap.get("arananyaslar")).get(2)),
                "data[10].employee_name", equalTo(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_name")),
                "data[10].employee_salary",equalTo(((Map<?, ?>)expectedDataMap.get("onbirincicalisan")).get("employee_salary")),
                 "data[10].employee_age", equalTo(((Map<?, ?>)expectedDataMap.get("onbirincicalisan")).get("employee_age")),
                "data[10].profile_image", equalTo(((Map<?, ?>)expectedDataMap.get("onbirincicalisan")).get("profile_image")));






    }

}