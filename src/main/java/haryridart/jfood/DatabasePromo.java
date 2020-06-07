package haryridart.jfood;
import java.util.ArrayList;

/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This DatabasePromo Class is used to precessing database of promo
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class DatabasePromo {
    // instance variables
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;
    /**
     * This is getPromoDatabase method, that is used to get data of all promo in database
     * @return PROMO_DATABASE, return promo object in array list
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }
    /**
     * This is getLastId method, that is used to get last id of promo in database
     * @return lastId, return promo id
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * This is getPromoById method, that is used to get data of promo in database
     * @params id, this is parameter to select promo by id
     * @return promo, return promo object that is selected
     */
    public static  Promo getPromoById(int id) throws PromoNotFoundException
    {
        boolean checker = false;
        for(int i=0;i<PROMO_DATABASE.size();i++){
            if(PROMO_DATABASE.get(i).getId() == id){
                checker = true;
                return PROMO_DATABASE.get(i);

            }
        }
        throw new PromoNotFoundException(id);
    }
    /**
     * This is getPromoByCode method, that is used to get data of promo in database
     * @params code, this is parameter to select promo by code
     * @return promo, return promo object that is selected
     */
    public static Promo getPromoByCode(String code) {
        for (Promo promo: PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }
    /**
     * This is addPromo method, that is used to add promo in database
     * @params promo, this is parameter to insert promo object into database
     * @return true, if add is succeeded
     * @return false, if add is not succeeded
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        boolean samePromoCode = false;
        for (Promo buff: PROMO_DATABASE) {
            if (promo.getCode().equals(buff.getCode())) {
                samePromoCode = true;
                break;
            }
        }

        if (!samePromoCode) {
            PROMO_DATABASE.add(promo);
            lastId = promo.getId();
            return true;
        }
        throw new PromoCodeAlreadyExistsException(promo);
    }
    public static boolean activatePromo(int id)
        {
            for(Promo promo : PROMO_DATABASE)
            {
                if (promo.getId() == id)
                {
                    promo.setActive(true);
                }
            }
            return true;
        }
    public static boolean deactivatePromo(int id)
    {
        for (Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                promo.setActive(false);
            }
        }
        return true;
    }
    /**
     * This is removePromo method, that is used to remove data of promo in database
     * @params id, this is parameter to select promo by id
     * @return true, if remove is succeeded
     * @return false, if remove is not succeeded
     */
    public static  boolean removePromo(int id) throws PromoNotFoundException
    {
        boolean checker = false;
        for(int i=0;i<PROMO_DATABASE.size();i++){
            if(PROMO_DATABASE.get(i).getId() == id){
                checker = true;
                PROMO_DATABASE.remove(i);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }
}
        


    

    


