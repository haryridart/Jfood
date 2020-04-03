
/**
 * Write a description of class DatabaseSeller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class DatabaseSeller {
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;

    public static ArrayList<Seller> getSellerDatabase() {
        return SELLER_DATABASE;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return the sum of x and y
     */
    public static int getLastId() {
        return lastId;
    }

    public static Seller getSellerById(int id){
        boolean checker = false;
        for(int i=0;i<SELLER_DATABASE.size();i++){
            if(SELLER_DATABASE.get(i).getId() == id){
                checker = true;
                return SELLER_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addSeller(Seller seller) {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    /**
     * Method ini digunakan untuk mengembalikan Menghapus Makanan.
     */
    public  static boolean removeSeller(int id)
    {   boolean checker = false;
        for(int i=0;i<SELLER_DATABASE.size();i++){
            if(SELLER_DATABASE.get(i).getId() == id){
                checker = true;
                SELLER_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}