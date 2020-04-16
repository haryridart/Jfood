package haryridart.jfood;
import java.util.ArrayList;

/**
 * Class DatabaseFood digunakan untuk Merepresentasikan Database Makanan. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class DatabaseFood
{
    // Mendefinisikan instance variables 
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId=0;
    /**
    * Method ini digunakan untuk mengembalikan penambahan Makanan.
    */
    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }

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

    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        ArrayList<Food> ret = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                ret.add(food);
            }
        }
        return ret;
    }

    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
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
