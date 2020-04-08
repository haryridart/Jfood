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
import java.util.*;
public class Jfood {
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        Location locationObj = new Location("Sukabumi", "Jawa Barat", "Rumah Kita Semua");
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Narumi", "narumi@gmail.com", "085285237993", locationObj)));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hary", "hary@gmail.com", "hary1", new GregorianCalendar(2020, 4, 2)));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hary", "hary@gmail.com", "hary2", new GregorianCalendar(2020, 5, 2)));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Frenzel", "frenzel@gmail.com", "frenly123", new GregorianCalendar(2020, 5, 2)));
        System.out.println(DatabaseCustomer.getCustomerDatabase());

        for (int i=1; i<DatabaseCustomer.getCustomerDatabase().size();i++) {
            System.out.println(DatabaseCustomer.getCustomerById(i).getName());
        }

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Babi Panggang",DatabaseSeller.getSellerById(1),39000,FoodCategory.Noodles));
        DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(1),13000,FoodCategory.Beverages));
        DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Mie Ayam", DatabaseSeller.getSellerById(1),16000,FoodCategory.Beverages));

        for (int i = 0; DatabaseFood.getFoodByCategory(FoodCategory.Beverages).size() > i; i++){

            System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Beverages).get(i).getName());
        }

        DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SENDNUKE", 2000,15000,false)));
        DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SENDNUKE", 5000,30000,true)));

        for (Promo promo : DatabasePromo.getPromoDatabase()){
            System.out.println(promo);
        }

        ArrayList<Food> food1 = new ArrayList<Food>();
        food1.add(DatabaseFood.getFoodById(1));

        ArrayList<Food> food2 = new ArrayList<Food>();
        food2.add(DatabaseFood.getFoodById(2));
        food2.add(DatabaseFood.getFoodById(3));
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,
                food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));

        for (Invoice invoiceLoop : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            if(invoiceLoop.getId() == DatabaseInvoice.getLastId())
            {
                invoiceLoop.setTotalPrice();
            }
        }

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1,
                food2, DatabaseCustomer.getCustomerById(1),5000 ));

        for (Invoice invoiceLoop : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            if(invoiceLoop.getId() == DatabaseInvoice.getLastId())
            {
                invoiceLoop.setTotalPrice();
            }
        }
        System.out.println(DatabaseInvoice.getInvoiceDatabase());
        DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getLastId(), InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1)));
        DatabasePromo.activatePromo(1);

        for (Invoice invoiceLoop : DatabaseInvoice.getInvoiceDatabase())
        {
            invoiceLoop.setTotalPrice();
        }
        System.out.println(DatabaseInvoice.getInvoiceDatabase());
    }
}