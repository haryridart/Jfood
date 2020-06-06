package haryridart.jfood;
import java.util.ArrayList;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This DatabaseFood Class is used to precessing database of food
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class DatabaseFood
{
    // Mendefinisikan instance variables 
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId=0;
    /**
     * This is constructor for object of class DatabaseFood
     */
    public DatabaseFood()
    {
        // initialise instance variables
    }
    /**
     * This is getFoodDatabase method, that is used to get data of all food in database
     * @return FOOD_DATABASE, return food object in array list
     */
    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }
    /**
     * This is getLastId method, that is used to get last id of food in database
     * @return lastid, return food id
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * This is getFoodById method, that is used to get data of food in database
     * @params id, this is parameter to select food by id
     * @return food, return food object that is selected
     */
    public  static  Food getFoodById(int id) throws FoodNotFoundException
    {

        boolean checker = false;
        for(int i=0;i<FOOD_DATABASE.size();i++){
            if(FOOD_DATABASE.get(i).getId() == id){
                checker = true;
                return FOOD_DATABASE.get(i);
            }
        }
        throw new FoodNotFoundException(id);
    }
    /**
     * This is getFoodByCategiry method, that is used to get data of food in database
     * @params category, this is parameter to select food by food category
     * @return i, return food in array list that is selected
     */
    public  static  ArrayList<Food> getFoodByCategory(FoodCategory foodCategory)
    {
        boolean checker = false;
        ArrayList<Food> temp  = new ArrayList<Food>();
        for(int i=0;i<FOOD_DATABASE.size();i++){
            if(FOOD_DATABASE.get(i).getCategory() == foodCategory){

                temp.add(FOOD_DATABASE.get(i));
            }
        }
        return(temp);
    }
    /**
     * This is getFoodBySellerId method, that is used to get data of food in database
     * @params sellerId, this is parameter to select food by seller id
     * @return i, return food in array list that is selected
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        ArrayList<Food> ret = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                ret.add(food);
            }
        }
        return ret;
    }
    /**
     * This is addFood method, that is used to add food in database
     * @params food, this is parameter to insert food object into database
     * @return true, if add is succeeded
     * @return false, if add is not succeeded
     */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    /**
     * This is removeFood method, that is used to remove data of food in database
     * @params id, this is parameter to select food by id
     * @return true, if remove is succeeded
     * @return false, if remove is not succeeded
     */
    public static  boolean removeFood(int id) throws FoodNotFoundException
    {
        boolean checker = false;
        for(int i=0;i<FOOD_DATABASE.size();i++){
            if(FOOD_DATABASE.get(i).getId() == id){
                checker = true;
                FOOD_DATABASE.remove(i);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }


}
