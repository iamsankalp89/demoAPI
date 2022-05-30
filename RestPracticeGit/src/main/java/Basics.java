import io.restassured.RestAssured;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*; //add manually for given
import  static org.hamcrest.Matchers.*; //import static hamcrest for equal method

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .log().all()        //Log all the input only
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .log().all()       //Log all the output only
                .body("scope",equalTo("APP"))   //Body validation
                .body("status", equalTo("OK"))     //Body validation
                .header("Server","Apache/2.4.18 (Ubuntu)");  //header validation



    }
}
