package com.techprowed.testData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {






    public HashMap<String, Object>  setUpTestData(){


        HashMap<String, Object> bookingdates = new HashMap<String, Object>();

        bookingdates.put("checkin","2022-03-24");
        bookingdates.put("checkout","2022-05-04");

        HashMap<String, Object> expectedData  = new HashMap<String, Object>();
        expectedData.put("firstname","Susan");
        expectedData.put("lastname","Ericsson");
        expectedData.put("totalprice",724);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdates);
        return expectedData;

    }

    public JSONObject setUpTestAndRequestData() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-01-05");
        bookingdates.put("checkout", "2021-01-10");
        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("firstname", "murat");
        expectedRequest.put("lastname", "yılmaz");
        expectedRequest.put("totalprice", 150000);
        expectedRequest.put("depositpaid", false);
        expectedRequest.put("bookingdates", bookingdates);
        return expectedRequest;
    }



}
