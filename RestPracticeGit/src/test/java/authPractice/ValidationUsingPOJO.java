package authPractice;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourses;

import static io.restassured.RestAssured.given;


public class ValidationUsingPOJO {


    public static void main(String[] args) throws InterruptedException {


        //use to get the code
//        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//        driver.findElement(By.id("identifierId")).sendKeys("sankalp.test1@gmail.com");
//        driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
//        Thread.sleep(5);
//        driver.findElement(By.name("password")).sendKeys("sis1234!");
//        driver.findElement(By.id("password")).sendKeys("sankalp.test1@gmail.com");
//        Thread.sleep(5);
//        String url = driver.getCurrentUrl();


        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgK4EQU2KcZ6V7xCdlVuLjsEFFkpPy_W9mgGjHGVXFGuodTEKIRhYcZAyV0yd0Vug&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
        String partialCode= url.split("code=")[1];
        String code = partialCode.split("&")[0];

        System.out.println("code= "+code);

        //Get access code
        String accessTokenResponse =   given().urlEncodingEnabled(false)  //not convert any value in numeric and other of the code
                .queryParam("code",code)
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type","authorization_code")
                .when()
                .log().all()
                .post("https://www.googleapis.com/oauth2/v4/token")
                .asString();

        JsonPath jsonPath = new JsonPath(accessTokenResponse);
        String accessToken =  jsonPath.getString("access_token");



        GetCourses gc = given().queryParam("access_token",accessToken)
                .expect().defaultParser(Parser.JSON)
                .when()//require for the parsing resposne as Json
                .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class); //expecting response as json

        System.out.println("Linked URL"+gc.getLinkedIn());
        System.out.println("Instructor"+gc.getInstructor());
    }

}
