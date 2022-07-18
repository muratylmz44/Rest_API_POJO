package com.techprowed.day09;

import com.techprowed.testData.DummyTestData;
import com.testBase.DummyTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class getRequest14 extends DummyTestBase {

    @Test
    public void test() {
        this.spec03.pathParam("parametre1", "employees");
        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Integer> expectedDataMap = expectedObje.setUpTestData02();
        System.out.println(expectedDataMap);
        Response response =  RestAssured.given().accept("application/json").spec(this.spec03).when().get("/{parametre1}", new Object[0]);
        HashMap<String, Object> actualDataMap = (HashMap)response.as(HashMap.class);
        System.out.println(actualDataMap);
        Assert.assertEquals(expectedDataMap.get("statusCode"),(Integer) response.getStatusCode());
        List<Integer> maasListesi = new ArrayList();
        int datasize = ((List)actualDataMap.get("data")).size();

        for(int i = 0; i < datasize; ++i) {
            maasListesi.add((Integer)((Map)((List)actualDataMap.get("data")).get(i)).get("employee_salary"));
        }

        Collections.sort(maasListesi);
        Assert.assertEquals(expectedDataMap.get("enYuksekMaas"), maasListesi.get(maasListesi.size() - 1));
        Assert.assertEquals(expectedDataMap.get("ikinciYuksekMaas"), maasListesi.get(maasListesi.size() - 2));
        List<Integer> yasListesi = new ArrayList();

        for(int i = 0; i < datasize; ++i) {
            yasListesi.add((Integer)((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age"));
        }

        Collections.sort(yasListesi);
        Assert.assertEquals(expectedDataMap.get("enKucukYas"), yasListesi.get(0));
        JsonPath json = response.jsonPath();
        List<Integer> maasListesijson = json.getList("data.employee_salary");
        Collections.sort(maasListesijson);
        Assert.assertEquals(expectedDataMap.get("enYuksekMaas"), maasListesijson.get(maasListesijson.size() - 1));
        Assert.assertEquals(expectedDataMap.get("ikinciYuksekMaas"), maasListesijson.get(maasListesijson.size() - 2));
        List<Integer> yasListesijson = json.getList("data.employee_age");
        Collections.sort(yasListesijson);
        Assert.assertEquals(expectedDataMap.get("enKucukYas"), yasListesijson.get(0));
    }


}
