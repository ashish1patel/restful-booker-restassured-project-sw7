package com.restful.booker.crudtest;

import com.restful.booker.model.CreatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutBookingTest extends TestBase {
@Test
    public void updateBookingData(){

    HashMap<Object, Object> bookingDates = new HashMap<Object, Object>();
    bookingDates.put("checkin","2024-02-01");
    bookingDates.put("checkout", "2024-03-01");

    CreatePojo createPojo = new CreatePojo();
    createPojo.setFirstname("xyz");
    createPojo.setLastname("abc");
    createPojo.setTotalprice(1500);
    createPojo.setDepositpaid(false);
    createPojo.setBookingdates(bookingDates);
    createPojo.setAdditionalneeds("bad & Breakfast");

    Response response = given()
            .header("Content-Type","application/json; charset=utf-8")
            .header("Accept", "application/json")
            .header( "Cookie", "token=c0ed97d09491f69")

            .pathParam("id","1250")//2113
            .body(createPojo)

            .when()
            .put("/booking/{id}");

    response.then().statusCode(200);
    response.prettyPrint();

}
}
