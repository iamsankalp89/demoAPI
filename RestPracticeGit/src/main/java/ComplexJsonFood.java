import ResourecesAndMethods.Payload;
import io.restassured.path.json.JsonPath;

import java.util.*;

public class ComplexJsonFood {

    public static void main(String[] args) {

        JsonPath jsonpath = new JsonPath(Payload.nestedFoodJson());

        //You can use any name like data.size for size or directly pass size
        //if there is no parent element
        int noMainArrayElements = jsonpath.getInt("data.size");
        //int noMainArrayElements = jsonpath.getInt("size");
        System.out.println("parent element: " +noMainArrayElements);


//        //1. Select all the batter of the food whose name is Old Fashioned
//        for (int i=0;i<noMainArrayElements;i++)
//        {
//            String nameOfFood = jsonpath.get("["+i+"].name");
//            System.out.println("name Of Food: "+nameOfFood);
//            if(nameOfFood.equals("Old Fashioned"))
//            {
//                int noBatterElements = jsonpath.getInt("["+i+"].batters.batter.size()");  //"["+i+"] for the array of parent
//                System.out.println("no Batter Elements: "+noBatterElements);
//                for ( int j=0;j<noBatterElements;j++) {
//                    //["+i+"] = parent array and batters.batter[" + j + "].type" type of selected array named cake
//                    String nameOfBatterFood = jsonpath.get("["+i+"].batters.batter[" + j + "].type");
//                   System.out.println("name Of Batter Food: "+nameOfBatterFood);
//                }
//                break;  //  if value matched out of the loop
//            }
//        }




        //2. Select all the Toppings ID and type of the food whose name is Cake
        for (int i=0;i<noMainArrayElements;i++)
        {
            String nameOfFood = jsonpath.get("["+i+"].name");
            System.out.println("name Of Food: "+nameOfFood);
            if(nameOfFood.equals("Cake"))
            {
                int noTopingElements = jsonpath.getInt("["+i+"].topping.size()");  //"["+i+"] for the array of parent
                System.out.println("no Batter Elements: "+noTopingElements);
                for ( int j=0;j<noTopingElements;j++) {
                    //["+i+"] = parent array and batters.batter[" + j + "].type" type of selected array named cake
                    String nameOfBatterFood = jsonpath.get("["+i+"].topping[" + j + "].type");
                    String id = jsonpath.get("["+i+"].topping[" + j + "].id");
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put(id,nameOfBatterFood);
                    //System.out.println(hashMap);  //Printing hashmap first way

                    for (Map.Entry entry: hashMap.entrySet())   //second way using map.entry
                    {
                        System.out.println("id: "+entry.getKey()+" - Type: "+entry.getValue());
                    }
                }
                break;  //  if value matched out of the loop
            }
        }


        //2. Select all the Toppings ID and type of the food whose name is Cake
        for (int i=0;i<noMainArrayElements;i++)
        {
            String nameOfFood = jsonpath.get("["+i+"].name");
            System.out.println("name Of Food: "+nameOfFood);
            if(nameOfFood.equals("Cake"))
            {
                int noTopingElements = jsonpath.getInt("["+i+"].topping.size()");  //"["+i+"] for the array of parent
                System.out.println("no Batter Elements: "+noTopingElements);
                for ( int j=0;j<noTopingElements;j++) {
                    //["+i+"] = parent array and batters.batter[" + j + "].type" type of selected array named cake
                    String nameOfBatterFood = jsonpath.get("["+i+"].topping[" + j + "].type");
                    String id = jsonpath.get("["+i+"].topping[" + j + "].id");
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put(id,nameOfBatterFood);
                    //System.out.println(hashMap);  //Printing hashmap first way

                    for (Map.Entry entry: hashMap.entrySet())   //second way using map.entry
                    {
                        System.out.println("id: "+entry.getKey()+" - Type: "+entry.getValue());
                    }
                }
                break;  //  if value matched out of the loop
            }
        }


    }
}
