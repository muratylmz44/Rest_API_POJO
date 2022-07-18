package com.techprowed.testData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {


    public HashMap<String, Object> setUpTestData() {
        List<Integer> yaslar = new ArrayList();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);
        HashMap<String, Object> onbirinci = new HashMap();
        onbirinci.put("id", 11);
        onbirinci.put("employee_name", "Jena Gaines");
        onbirinci.put("employee_salary", 90560);
        onbirinci.put("employee_age", 30);
        onbirinci.put("profile_image", "");
        HashMap<String, Object> expectedData = new HashMap();
        expectedData.put("statusCode", 200);
        expectedData.put("besincicalisan", "Airi Satou");
        expectedData.put("calisansayisi", 24);
        expectedData.put("sondanikincicalisanmaasi", 106450);
        expectedData.put("arananyaslar", yaslar);
        expectedData.put("onbirincicalisan", onbirinci);
        return expectedData;


    }

    public HashMap<String, Integer> setUpTestData02() {
        HashMap<String, Integer> expectedData = new HashMap();
        expectedData.put("statusCode", 200);
        expectedData.put("enYuksekMaas", 725000);
        expectedData.put("enKucukYas", 19);
        expectedData.put("ikinciYuksekMaas", 675000);
        return expectedData;
    }
    public HashMap<String, String> setupRequestBody() {
        HashMap<String, String> requestBody = new HashMap();
        requestBody.put("name", "batch30");
        requestBody.put("salary", "123000");
        requestBody.put("age", "20");
        return requestBody;
    }

    public HashMap<String, Object> setUpExpectedData() {
        HashMap<String, Object> expectedData = new HashMap();
        expectedData.put("statusCode", 200);
        expectedData.put("status", "success");
        expectedData.put("message", "Successfully! Record has been added.");
        return expectedData;
    }
    public JSONObject setUpDeleteExpectedData() {
        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", "2");
        expectedData.put("message", "Successfully! Record has been deleted");
        return expectedData;
    }


}