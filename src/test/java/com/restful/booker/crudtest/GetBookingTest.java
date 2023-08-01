package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingTest extends TestBase {

    @Test
    public void getAllBookingData(){
       Response response = given()

                .when()
               .get("/booking");


       response.prettyPrint();
       response.then().statusCode(200);
    }

    @Test
    public void getSingleBookingData(){
        Response response = given()
                .pathParam("id", "311")

                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
       // response.body("200");

    }

//    @Test
//    public void get(){
//        Response response = given()
//                //.pathParam("id", "49")
//                .pathParam("firstname", "john")
//
//                .when()
//                .get("/firstname}");
//        response.then().statusCode(200);
//        response.prettyPrint();
//    }
}
