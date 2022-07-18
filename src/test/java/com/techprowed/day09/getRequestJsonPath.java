package com.techprowed.day09;

import com.techprowed.testData.DummyTestData;
import com.testBase.DummyTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class getRequestJsonPath extends DummyTestBase {

    @Test
    public void test() {
        this.spec03.pathParam("parametre1", "employees");
        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Object> expectedDataMap = expectedObje.setUpTestData();
        System.out.println(expectedDataMap);
        Response response = (Response) RestAssured.given().accept("application/json").spec(this.spec03).when().get("/{parametre1}", new Object[0]);
       // response.prettyPrint();
        JsonPath json = response.jsonPath();
        Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());
        Assert.assertEquals(expectedDataMap.get("besincicalisan"), json.getString("data[4].employee_name"));
        Assert.assertEquals(expectedDataMap.get("calisansayisi"), json.getList("data.id").size());
        Assert.assertEquals(expectedDataMap.get("sondanikincicalisanmaasi"), json.getInt("data[-2].employee_salary"));
        Assert.assertTrue(json.getList("data.employee_age").containsAll((List)expectedDataMap.get("arananyaslar")));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("id"), json.getInt("data[10].id"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_name"), json.getString("data[10].employee_name"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_salary"), json.getInt("data[10].employee_salary"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("employee_age"), json.getInt("data[10].employee_age"));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirincicalisan")).get("profile_image"), json.getString("data[10].profile_image"));
    }


}
