import java.util.ArrayList;

/**
 * Write a description of class DatabasePromo here.
 *
 * @author (Hary Ridart)
 * @version (02-04-2020)
 */
public class DatabasePromo {
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }
    public static  Promo getPromoById(int id){
        boolean checker = false;
        for(int i=0;i<PROMO_DATABASE.size();i++){
            if(PROMO_DATABASE.get(i).getId() == id){
                checker = true;
                return PROMO_DATABASE.get(i);

            }

        }

        return null;

    }
    public static Promo getPromoByCode(String code) {
        for (Promo promo: PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }
    public static  boolean addPromo(Promo promo){

        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }
    public static boolean activatePromo(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(true);
            return true;
        }
        return false;
    }
    public static boolean deactivatePromo(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(false);
            return true;
        }
        return false;
    }
    public boolean removePromo (int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            PROMO_DATABASE.remove(promo);
            return true;
        }
        return false;
    }
}
        


    

    


