
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

    public static Seller getSellerById(int id) {
        Seller value = null;
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == lastId) {
                value = seller;
            } else {
                return value;
            }
        }

        return value;
    }

    public static boolean addSeller(Seller seller) {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    /**
     * Method ini digunakan untuk mengembalikan Menghapus Makanan.
     */
    public static boolean removeSeller(int id) {
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == id) {
                SELLER_DATABASE.remove(seller);
                return true;
            }
        }
        return false;

    }
}