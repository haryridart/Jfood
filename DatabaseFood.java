
/**
 * Class DatabaseFood digunakan untuk Merepresentasikan Database Makanan. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class DatabaseFood
{
    // Mendefinisikan instance variables 
    private String listFood[];


    /**
    * Merupakan constructor dari Class DatabaseFood untuk membuat Database
    * makanan.
    * @return Constructor tidak mengembalikan nilai.
    */
    public DatabaseFood()
    {
        // untuk menuliskan instance variables
    }

    /**
    * Method ini digunakan untuk mengembalikan penambahan Makanan.
    * @param food merupakan parameter makanan yang ditambahkan.
    * @return Method ini mengembalikan nilai boolen.
    */
    public boolean addFood(Food food)
    {
        return true;
        
    }
    /**
    * Method ini digunakan untuk mengembalikan Menghapus Makanan.
    * @param food merupakan parameter makanan yang ditambahkan.
    * @return Method ini mengembalikan nilai boolen.
    */
    public boolean removeFood(Food food)
    {
        return false;
    }
    /**
    * Method ini digunakan untuk mengembalikan Makanan pada DatabaseFood .
    * @param Belum ada parameter yang digunakan pada method ini.
    * @return Method ini belum mengembalikan nilai.
    */
    public Food getFood()
    {
        return null;
    }
    /**
    * Method ini digunakan untuk mengembalikan List Makanan pada DatabaseFood.
    * @param Belum ada parameter yang digunakan pada method ini.
    * @return Method ini belum mengembalikan nilai.
    */
    public String[] getListFood()
    {
        return null;
    }
    
}
