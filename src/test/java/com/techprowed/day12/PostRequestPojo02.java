package com.techprowed.day12;

import com.techprowed.pojos.BookingPojo;
import com.techprowed.pojos.BookingDatesPojo;
import com.techprowed.pojos.BookingResponsePojo;
import com.testBase.HerokuAppTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestPojo02 extends HerokuAppTestBase {



    @Test
    public void test() {
        this.spec02.pathParam("parametre1", "booking");
        BookingDatesPojo bookingdates = new BookingDatesPojo("2020-09-09", "2020-09-21");
        System.out.println(bookingdates);
        BookingPojo bookingPojo = new BookingPojo("Selim", "Ak", 15000, true, bookingdates);
        System.out.println(bookingPojo);
        Response response = given().
                contentType(ContentType.JSON).
                spec(spec02).
                auth().basic("admin", "password123").
                body(bookingPojo).when().post("/{parametre1}", new Object[0]);
        response.prettyPrint();



        BookingResponsePojo actualData = (BookingResponsePojo)response.as(BookingResponsePojo.class);
        Assert.assertEquals(200, (long)response.getStatusCode());
        Assert.assertEquals(bookingPojo.getFirstname(), actualData.getBooking().getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(), actualData.getBooking().getLastname());
        Assert.assertEquals(bookingPojo.getTotalprizce(),actualData.getBooking().getTotalprizce());
        Assert.assertEquals(bookingPojo.isDepositpaid(), actualData.getBooking().isDepositpaid());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());



    }
}
