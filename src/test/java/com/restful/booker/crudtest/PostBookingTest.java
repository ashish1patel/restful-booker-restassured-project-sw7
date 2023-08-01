package com.restful.booker.crudtest;

import com.restful.booker.model.CreatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostBookingTest extends TestBase {
    @Test
            public void createBookingTest() {

        HashMap<Object, Object> bookingDates = new HashMap<Object, Object>();
    bookingDates.put("checkin","2024-01-01");
    bookingDates.put("checkout", "2024-02-01");

        CreatePojo createPojo = new CreatePojo();
        createPojo.setFirstname("prime");
        createPojo.setLastname("tesing");
        createPojo.setTotalprice(1000);
        createPojo.setDepositpaid(true);
        createPojo.setBookingdates(bookingDates);
        createPojo.setAdditionalneeds("Breakfast");

       Response response = given()
               .header("Content-Type","application/json; charset=utf-8")
               .body(createPojo)

                .when()
               .post("/booking");

       response.then().statusCode(200);
       response.prettyPrint();

    }
}
