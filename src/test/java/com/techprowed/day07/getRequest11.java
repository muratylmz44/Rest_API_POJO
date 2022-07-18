package com.techprowed.day07;

import com.testBase.JsonPlaceHolderTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class getRequest11 extends JsonPlaceHolderTestBase {





    @Test
    public void test(){



        spec01.pathParams("parametre1","todos",
                "parametre2",2);



        HashMap<String,Object>expectedData=new HashMap<String,Object>();


        expectedData.put("statusCode",200);
        expectedData.put("via","1.1 vegur");
        expectedData.put("Server","cloudflare");
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);


        System.out.println(expectedData);

        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

        Response response=given().
                accept("aplication/json").
                spec(spec01).
                when().
                get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        //  1.yöntem Matchers class ile assert işlemi

        response.then().
                assertThat().
                statusCode(response.statusCode()).
                headers("via", equalTo(expectedData.get("via")),
                        "Server", equalTo(expectedData.get("Server"))).
                body("userId", equalTo(expectedData.get("userId")),
                        "title", equalTo(expectedData.get("title")),
                                "completed",
                                equalTo(expectedData.get("completed")));

        //2. Yöntem

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("statusCode"), response.statusCode());
        Assert.assertEquals(expectedData.get("via"), response.getHeader("via"));
        Assert.assertEquals(expectedData.get("Server"), response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"), jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"), jsonPath.getString("title"));
        Assert.assertEquals(expectedData.get("completed"), jsonPath.getBoolean("completed"));


        //3.Yöntem




    }
}
