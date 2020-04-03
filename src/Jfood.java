/**
 * Write a description of class Jfood here.
 *
 * @author Hary Ridart
 * @version 2020-02-27
 */
import java.text.SimpleDateFormat;  
import java.util.GregorianCalendar; 
import java.util.Calendar;
import java.util.Date;  
public class Jfood {
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        /*Location locationObj = new Location("Sukabumi", "Jawa Barat", "Rumah Kita Semua");
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Narumi", "narumi@gmail.com", "085285237993", locationObj)));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId(), "Hary", "hary@gmail.com", "hary1", new GregorianCalendar(2020, 4, 2)));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId(), "Hary", "hary@gmail.com", "hary2", new GregorianCalendar(2020, 5, 2)));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId(), "Frenzel", "frenzel@gmail.com", "frenly123", new GregorianCalendar(2020, 5, 2)));
        System.out.println(DatabaseCustomer.getCustomerDatabase());

        for (int i=0; i<DatabaseCustomer.getCustomerDatabase().size();i++)
            System.out.println(DatabaseCustomer.getCustomerById(i).getName());

        DatabaseFood.addFood(new Food( DatabaseFood.getLastId(),"Bakso", DatabaseSeller.getSellerById(0),13000,FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId(),"Mie Ayam",DatabaseSeller.getSellerById(0),1500,FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId(),"Babi Panggang",DatabaseSeller.getSellerById(0),39000,FoodCategory.Noodles));

        for (int i = 0; DatabaseFood.getFoodByCategory(FoodCategory.Beverages).size() > i; i++){

            System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Beverages).get(i).getName());
        }*/

        DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SALAHLOH", 2000,15000,false))))
        DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"BENERLOH", 5000,17000,true))))

        for (Promo promo : DatabasePromo.getPromoDatabase()){
            System.out.println(promo);
        }

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Mozarella", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()),10000,FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Sate", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()),22000,FoodCategory.Beverages));

    }
}










