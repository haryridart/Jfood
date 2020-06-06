package haryridart.jfood.controller;

import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * FoodController Class is used to access JFood database at food table
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
import java.util.ArrayList;
@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FoodController
{
    /**
     * This is getAllFood method, that is used to access and get data of all food in database
     * @return foods, return food object in array list
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        ArrayList<Food> foods;
        try {
            foods = DatabaseFoodPostgre.getFoodDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return foods;
    }
    /**
     * This is getFoodById method, that is used to access and get data of food in database
     * @params id_food, this is parameter to select food by id
     * @return food, return food object that is selected
     */
    @RequestMapping(value = "/{id_food}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id_food) {
        Food food = null;
        try
        {
            food =  DatabaseFoodPostgre.getFoodById(id_food);
        }
        catch (FoodNotFoundException e)
        {
            e.getExMessage();
            return null;
        }
        return food;
    }
    /**
     * This is getFoodBySellerId method, that is used to access and get data of food in database
     * @params sellerId, this is parameter to select food by seller id
     * @return foods, return food in array list that is selected
     */
    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        return DatabaseFoodPostgre.getFoodBySellerId(sellerId);
    }
    /**
     * This is getFoodByCategory method, that is used to access and get data of food in database
     * @params category, this is parameter to select food by category
     * @return food, return food in array list that is selected
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        ArrayList<Food> food = null;
        food = DatabaseFoodPostgre.getFoodByCategory(category);
        return food;
    }
    /**
     * This is addFood method, that is used to access and add food in database
     * @params food, this is parameter to insert food object into database
     * @return food, return food in array list that is selected
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                                     @RequestParam(value="price") int price,
                                     @RequestParam(value="category") FoodCategory category,
                                     @RequestParam(value="sellerId") int sellerId)
    {
        Food food = null;
        try {
            food = new Food(DatabaseFoodPostgre.getLastFoodId() + 1, name, DatabaseSellerPostgre.getSellerById(sellerId), price, category);
        }catch(SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFoodPostgre.insertFood(food);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return food;
    }
}
