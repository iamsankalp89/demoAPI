import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicPassStaticJsonUsingFile {

    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";


        String body = new String(Files.readAllBytes(Paths.get("RestPracticeGit/src/main/java/ResourecesAndMethods/jsonFile.json")));

        given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .log().all()        //Log all the input only
                .body(body)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .log().all()       //Log all the output only
                .body("scope",equalTo("APP"))   //Body validation
                .body("status", equalTo("OK"))     //Body validation
                .header("Server","Apache/2.4.18 (Ubuntu)");  //header validation



    }
}
