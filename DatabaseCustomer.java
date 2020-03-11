
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer
{
    // Mendefinisikan instance variables 
    private static String listCustomer[];

    /**
    * Method ini digunakan untuk mengembalikan penambahan Makanan.
    * @param food merupakan parameter makanan yang ditambahkan.
    * @return Method ini mengembalikan nilai boolen.
    */
    public static boolean addCustomer(Customer customer)
    {
        return true;
        
    }
    /**
    * Method ini digunakan untuk mengembalikan Menghapus Makanan.
    * @param food merupakan parameter makanan yang ditambahkan.
    * @return Method ini mengembalikan nilai boolen.
    */
    public static boolean removeCustomer(Customer customer)
    {
        return false;
    }
    /**
    * Method ini digunakan untuk mengembalikan Makanan pada DatabaseFood .
    * @param Belum ada parameter yang digunakan pada method ini.
    * @return Method ini belum mengembalikan nilai.
    */
    public static Customer getCustomer()
    {
        return null;
    }
    /**
    * Method ini digunakan untuk mengembalikan List Makanan pada DatabaseFood.
    * @param Belum ada parameter yang digunakan pada method ini.
    * @return Method ini belum mengembalikan nilai.
    */
    public static String[] getListCustomer()
    {
        return listCustomer;
    }
    
}
