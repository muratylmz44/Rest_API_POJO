package com.techprowed.day12;

import com.techprowed.pojos.TodosPojo;
import com.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class postRequestWithPojo01 extends JsonPlaceHolderTestBase {




    @Test
    public void test(){




        spec01.pathParam("parametre1","todos");


        //Pojo ile Test datası Hem expected data request data olusmus oldu

        TodosPojo requestExpected =new TodosPojo(21,201,"Tidy your room",false);

        System.out.println(requestExpected);


        Response response=given().contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin","password123").
                body(requestExpected).
                when().
                post("/{parametre1}");
            response.prettyPrint();


            //De Serialization

        TodosPojo actualData=response.as(TodosPojo.class);

        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(requestExpected.getUserId(),actualData.getUserId());
        Assert.assertEquals(requestExpected.getId(),actualData.getId());
        Assert.assertEquals(requestExpected.getTitle(),actualData.getTitle());
        Assert.assertEquals(requestExpected.isCompleted(),actualData.isCompleted());



    }
}
