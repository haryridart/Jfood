package haryridart.jfood.controller;

import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FoodController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/{id_food}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id_food) {
        Food food = null;
        try
        {
            food =  DatabaseFood.getFoodById(id_food);
        }
        catch (FoodNotFoundException e)
        {
            e.getExMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        return DatabaseFood.getFoodBySeller(sellerId);
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        ArrayList<Food> food = null;
        food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                                     @RequestParam(value="price") int price,
                                     @RequestParam(value="category") FoodCategory category,
                                     @RequestParam(value="sellerId") int sellerId)
    {
        try
        {
            Food food = new Food(DatabaseFood.getLastId()+1,name,DatabaseSeller.getSellerById(sellerId),price,category);
            DatabaseFood.addFood(food);
            return food;
        }
        catch (SellerNotFoundException e)
        {
            e.getExMessage();
            return null;
        }


    }
}
