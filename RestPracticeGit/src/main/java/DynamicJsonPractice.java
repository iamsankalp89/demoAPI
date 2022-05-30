import ResourecesAndMethods.Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpHeaders;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DynamicJsonPractice {
    String bookID;
    Random rand = new Random(); //generate randomm number

    /*
    1. Add a book
    2. Check book added or not
    3. Delete book
    4. Check book deleted or not using get
     */
    @Test(priority = 1)
    public void addBook() {

        //Add a book with parameterization
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String addBookResponse = given()
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .log().all()
                .body(Payload.bookAddJson("Automation", "bcd",
                        "" + rand.nextInt(10000), "John K"))
                .when().post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .log().all()
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(addBookResponse);
        bookID = jsonPath.getString("ID");
        System.out.println(bookID);
    }

    @Test(priority = 2)
    public void getBook() {
        //Check the book added or not using GET
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String getBookResponse = given().log().all()
                .queryParam("ID", bookID)
                .when().get("/Library/GetBook.php")
                .then().assertThat().statusCode(200)
                .log().all().extract().response().asString();

        JsonPath jsonPath1 = new JsonPath(getBookResponse);
        String[] resGetList = new String[]
                {jsonPath1.getString("book_name"),
                        jsonPath1.getString("isbn"),
                        jsonPath1.getString("aisle"),
                        jsonPath1.getString("author")
                };

        //concat the isbn and aisle look like [isbn][aisle]
        String actualBcdID=  resGetList[1].concat(resGetList[2]);

        //Remove [] using replace
        actualBcdID =actualBcdID.replace("[","").replace("]","");
        System.out.println(actualBcdID);
        Assert.assertEquals(actualBcdID,bookID);
    }


    @Test(priority = 3)
    public void deleteBook() {
        //Check the book added or not using GET
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String deleteBookResponse = given().log().all()
                .body(Payload.deleteAddJson(bookID))
                .when().delete("/Library/DeleteBook.php")
                .then().assertThat().statusCode(200)
                .log().all().extract().response().asString();


        JsonPath jsonPath = new JsonPath(deleteBookResponse);
        String msg = jsonPath.getString("msg");
        Assert.assertEquals("book is successfully deleted", msg);
    }

    @Test(priority = 4)
    public void checkGetBookAfterDeletion() {
        //Check the book added or not using GET
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String getBookResponse = given().log().all()
                .queryParam("ID", bookID)
                .when().get("/Library/GetBook.php")
                .then().assertThat().statusCode(404)
                .log().all().extract().response().asString();

        JsonPath jsonPath1 = new JsonPath(getBookResponse);


        String actualMsg=  jsonPath1.getString("msg");

        System.out.println(actualMsg);
        Assert.assertEquals(actualMsg,"The book by requested bookid / author name does not exists!");
    }

}
