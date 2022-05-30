import ResourecesAndMethods.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddGetCheckAPI {
    public static void main(String[] args) {

        //1. Add a place - 2.Update place with new address - 3.get place to validate the new address
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //1. Add a place
        //How to get response in the string using extract().response().asString
        String apiResponse = given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .log().all()        //Log all the input only
                .body(Payload.addPlaceAPIPostPayLoad())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))   //Body validation
                .extract().response().asString();

        //System.out.println(apiResponse);

        //Parsing Json - JsonPath take input as String
        JsonPath jsonPath = new JsonPath(apiResponse);
       //as place ID is string , place id have no parent so direct pass and we store in variable
       String placeID=  jsonPath.getString("place_id");
        //System.out.println(placeID);

        //2.Update place with new address = now update the address using PUT Api

        String newAddress = "Somerset, East Street, USA";
       given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .log().all()        //Log all the input only
                .body(Payload.updatePlaceAPIPayLoad(placeID,newAddress))  //passing placeID to update on the address on given id
                .when().put("maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .log().all()        //Log all the Output only
                .body("msg", equalTo("Address successfully updated"));

        //3.get place to validate the new address
      String getAPIResponse =   given().queryParam("key","qaclick123")
                .queryParam("place_id",placeID )
                .when().get("maps/api/place/get/json") //no body of get right now
                .then().assertThat().statusCode(200)
                .log().all()    //Log all the Output only
              //  .body("address",equalTo(newAddress)); // one way to match
                .extract().response().asString();

        JsonPath jsonPath1 = new JsonPath(getAPIResponse);
        String actualAddress = jsonPath1.getString("address");

        Assert.assertEquals(actualAddress,newAddress,"Address are not same");
    }
}
