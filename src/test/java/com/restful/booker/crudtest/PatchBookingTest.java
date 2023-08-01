package com.restful.booker.crudtest;

import com.restful.booker.model.CreatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {

    @Test
    public void partialUpdateBooking(){
        CreatePojo createPojo = new CreatePojo();

        HashMap<Object, Object> bookingDates = new HashMap<Object, Object>();
        bookingDates.put("checkin","2024-02-01");
        bookingDates.put("checkout", "2024-03-01");

        createPojo.setFirstname("Amisha");
        createPojo.setLastname("Patel");
        createPojo.setTotalprice(1500);
        createPojo.setDepositpaid(true);
        createPojo.setBookingdates(bookingDates);
        createPojo.setAdditionalneeds("bad & Breakfast");

        Response response = given()
                .header( "Cookie", "token=c0ed97d09491f69")
                .header("Content-Type","application/json; charset=utf-8")
                .header("Accept", "application/json")
                .pathParam("id", "1077")
                .body(createPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
