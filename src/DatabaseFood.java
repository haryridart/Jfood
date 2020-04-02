
/**
 * Class DatabaseFood digunakan untuk Merepresentasikan Database Makanan. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class DatabaseFood
{
    // Mendefinisikan instance variables 
    private static String listFood[];

    /**
    * Method ini digunakan untuk mengembalikan penambahan Makanan.
    * @param food merupakan parameter makanan yang ditambahkan.
    * @return Method ini mengembalikan nilai boolen.
    */
    public static boolean addFood(Food food)
    {
        return true;
        
    }
    /**
    * Method ini digunakan untuk mengembalikan Menghapus Makanan.
    * @param food merupakan parameter makanan yang ditambahkan.
    * @return Method ini mengembalikan nilai boolen.
    */
    public static boolean removeFood(Food food)
    {
        return false;
    }
    /**
    * Method ini digunakan untuk mengembalikan Makanan pada DatabaseFood .
    * @param Belum ada parameter yang digunakan pada method ini.
    * @return Method ini belum mengembalikan nilai.
    */
    public static Food getFood()
    {
        return null;
    }
    /**
    * Method ini digunakan untuk mengembalikan List Makanan pada DatabaseFood.
    * @param Belum ada parameter yang digunakan pada method ini.
    * @return Method ini belum mengembalikan nilai.
    */
    public static String[] getListFood()
    {
        return listFood;
    }
    
}
