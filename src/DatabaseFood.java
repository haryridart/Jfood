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
    public static Food getFoodById(int id)
    {
        Food value=null;
        for(Food food : FOOD_DATABASE)
        {
            if(food.getId()==lastId)
            {
                value=food;
            }
            else
            {
                return value;
            }
        }

        return value;
    }
    public  static  ArrayList<Food> getFoodByCategory(FoodCategory foodCategory){

        boolean checker = false;
        ArrayList<Food> temp  = new ArrayList<Food>();
        for(int i=0;i<FOOD_DATABASE.size();i++){
            if(FOOD_DATABASE.get(i).getCategory() == foodCategory){

                temp.add(FOOD_DATABASE.get(i));

            }

        }
        return(temp);
    }
    public static ArrayList<Food> getFoodByCategory(Food category){
        ArrayList<Food> value=new ArrayList<>();
        for(Food foodDB : FOOD_DATABASE)
        {
            if(foodDB.getCategory()==category.getCategory())
            {
                value.add(foodDB);
            }
        }
        return value;
    }
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    public static boolean removeFood(int id)
    {
        for(Food foodDB : FOOD_DATABASE)
        {
            if(foodDB.getId()==id)
            {
                FOOD_DATABASE.remove(foodDB);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}
