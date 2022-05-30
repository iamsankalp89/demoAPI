import ResourecesAndMethods.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumPurchaseTestNG {

    @Test
    public void sumAssertion()
    {
        JsonPath jsonPath = new JsonPath(Payload.nestedCoursePrice());

        int purchaseAmount =  jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("purchase Amount: "+purchaseAmount);

        int noOfCourses =  jsonPath.getInt("courses.size()");
        System.out.println("No of courses: "+noOfCourses);

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
