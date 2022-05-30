package ResourecesAndMethods;

public class Payload {

    public static String addPlaceAPIPostPayLoad()
    {
        return "{\n" +
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
                "}";
    }


    public static String updatePlaceAPIPayLoad(String place_ID,String address)
    {
        return "{\n" +
                "\"place_id\":\""+place_ID+"\",\n" +
                "\"address\":\""+address+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }

    public static String nestedCoursePrice()
    {
        String cursePriceString = "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 910,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "}\n" +
                "]\n" +
                "}\n";
        return cursePriceString;
    }

    public static String nestedFoodJson()
    {
        String nestFoodJson = "[\n" +
                "\t{\n" +
                "\t\t\"id\": \"0001\",\n" +
                "\t\t\"type\": \"donut\",\n" +
                "\t\t\"name\": \"Cake\",\n" +
                "\t\t\"ppu\": 0.55,\n" +
                "\t\t\"batters\":\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"batter\":\n" +
                "\t\t\t\t\t[\n" +
                "\t\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                "\t\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
                "\t\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t},\n" +
                "\t\t\"topping\":\n" +
                "\t\t\t[\n" +
                "\t\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                "\t\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "\t\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                "\t\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
                "\t\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
                "\t\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "\t\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"0002\",\n" +
                "\t\t\"type\": \"donut\",\n" +
                "\t\t\"name\": \"Raised\",\n" +
                "\t\t\"ppu\": 0.55,\n" +
                "\t\t\"batters\":\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"batter\":\n" +
                "\t\t\t\t\t[\n" +
                "\t\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" }\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t},\n" +
                "\t\t\"topping\":\n" +
                "\t\t\t[\n" +
                "\t\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                "\t\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "\t\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                "\t\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "\t\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"0003\",\n" +
                "\t\t\"type\": \"donut\",\n" +
                "\t\t\"name\": \"Old Fashioned\",\n" +
                "\t\t\"ppu\": 0.55,\n" +
                "\t\t\"batters\":\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"batter\":\n" +
                "\t\t\t\t\t[\n" +
                "\t\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                "\t\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" }\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t},\n" +
                "\t\t\"topping\":\n" +
                "\t\t\t[\n" +
                "\t\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                "\t\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "\t\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "\t\t\t]\n" +
                "\t}\n" +
                "]";
        return nestFoodJson;
    }


    public static String bookAddJson(String nameBook,
                                     String isbn, String aisle, String author)
    {
        String addBookPayload ="{\n" +
                "\"name\":\""+nameBook+"\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+author+"\"\n" +
                "}\n";
        return addBookPayload;

    }

    public static String deleteAddJson(String idBook)
    {
        String deleteBookPayload ="{\n" +
                "    \"ID\": \""+idBook+"\"\n" +
                "}";
        return deleteBookPayload;

    }
}
