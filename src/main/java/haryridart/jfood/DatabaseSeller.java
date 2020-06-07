package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This DatabaseSeller Class is used to precessing database of seller
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
import java.util.ArrayList;
public class DatabaseSeller {
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;
    /**
     * This is getSellerDatabase method, that is used to get data of all seller in database
     * @return sellers, return seller object in array list
     */
    public static ArrayList<Seller> getSellerDatabase() {
        return SELLER_DATABASE;
    }

    /**
     * This is getId method, that is used to get last id of seller in database
     * @return lastId, return seller id
     */
    public static int getLastId() {
        return lastId;
    }
    /**
     * This is getSellerById method, that is used to get data of seller in database
     * @params id, this is parameter to select seller by id
     * @return seller, return seller object that is selected
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        boolean checker = false;
        for(int i=0;i<SELLER_DATABASE.size();i++){
            if(SELLER_DATABASE.get(i).getId() == id){
                checker = true;
                return SELLER_DATABASE.get(i);
            }
        }
        checker = false;
        throw new SellerNotFoundException(id);
    }
    /**
     * This is insertSeller method, that is used to add seller in database
     * @params seller, this is parameter to insert seller object into database
     * @return true, if add is succeeded
     * @return false, if add is not succeeded
     */
    public static boolean addSeller(Seller seller) {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    /**
     * This is removeSeller method, that is used to remove data of seller in database
     * @params id, this is parameter to select seller by id
     * @return true, if remove is succeeded
     * @return false, if remove is not succeeded
     */
    public  static boolean removeSeller(int id) throws SellerNotFoundException
    {   boolean checker = false;
        for(int i=0;i<SELLER_DATABASE.size();i++){
            if(SELLER_DATABASE.get(i).getId() == id){
                checker = true;
                SELLER_DATABASE.remove(i);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }
}