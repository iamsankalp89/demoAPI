import ResourecesAndMethods.Payload;
import groovy.json.JsonParser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import javax.xml.bind.util.JAXBSource;

public class ComplexJsonCoursePrice {

    public static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(Payload.nestedCoursePrice());

        //1. Size - Print No of courses returned by API - () is optional
        //int noOfCourses =  jsonPath.getInt("courses.size");
        int noOfCourses =  jsonPath.getInt("courses.size()");
        System.out.println("No of courses: "+noOfCourses);

        //2. Print Purchase Amount
        //purchaseAmount parent is Dashboard so dashboard.purchaseAmount
        int purchaseAmount =  jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("purchase Amount: "+purchaseAmount);

        //3. Print Title of the first course, as course is array so we need to
        //use courses.title[0] as it is on zeroth position
        String firstTitle =  jsonPath.get("courses[0].title");
       // String firstTitle =  jsonPath.get("courses.title[0]");
        System.out.println("Title of the first course: "+firstTitle);

        //4. Print All course titles and their respective Prices
        for (int i=0;i<noOfCourses;i++)
        {
            //String title =  jsonPath.get("courses["+i+"].title");
            String title =  jsonPath.get("courses.title["+i+"]");
            System.out.println("Title of the ["+i+"] course: "+title);
        }

        //5. Print no of copies sold by RPA Course
        int  priceRPA =  jsonPath.get("courses[2].price");
        System.out.println("Print no of copies sold by RPA Course: "+priceRPA);

        //if you don't know index
        for (int i=0;i<noOfCourses;i++)
        {
            String title =  jsonPath.get("courses.title["+i+"]");
            if(title.equals("RPA")) {
                int priceRPA1 = jsonPath.get("courses["+i+"].price");
                System.out.println("Print no of copies sold by RPA Course: " + priceRPA1);
                break; //because we dont want extra itrations once RPA found
            }
        }

        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int sumPrice = 0;
        for (int i=0;i<noOfCourses;i++)
        {
            int price = jsonPath.get("courses["+i+"].price");
            sumPrice = sumPrice+price;
        }
        System.out.println(sumPrice);
        Assert.assertEquals(sumPrice,purchaseAmount,"sumPrice and purchaseAmount are not equal");
        }


    }

