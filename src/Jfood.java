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
        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridart", "Ridart@gmail.com", "hary1", new GregorianCalendar(2020, 4, 2)));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Frenzel", "frenzel@gmail.com", "frenly123", new GregorianCalendar(2020, 5, 2)));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Narumikunn", "narumi@gmail.com", "narumi", new GregorianCalendar(2020, 1, 2)));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridart", "Ridart@gmail.com", "hary1", new GregorianCalendar(2020, 4, 2)));

        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SENDNUKE", 2000,15000,false)));
            DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SENDNUKE", 5000,30000,true)));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }

        //System.out.println(DatabaseCustomer.getCustomerDatabase());

        /*for (int i=1; i<DatabaseCustomer.getCustomerDatabase().size();i++) {
            System.out.println(DatabaseCustomer.getCustomerById(i).getName());
        }*/
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Babi Panggang",DatabaseSeller.getSellerById(1),39000,FoodCategory.Noodles));
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(1),13000,FoodCategory.Beverages));
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Mie Ayam", DatabaseSeller.getSellerById(3),16000,FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }

        /*for (int i = 0; DatabaseFood.getFoodByCategory(FoodCategory.Beverages).size() > i; i++){

            System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Beverages).get(i).getName());
        }*/

        try
        {
            DatabaseFood.removeFood(6);
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabasePromo.removePromo(4);
        }
        catch (PromoNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseCustomer.removeCustomer(4);
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        System.out.println("\nDATABASE PROMO YANG MASUK");
        for (Promo promo : DatabasePromo.getPromoDatabase()){
            System.out.println(promo);
        }
        System.out.println("\nDATABASE FOOD YANG MASUK");
        for (Food food : DatabaseFood.getFoodDatabase()){
            System.out.println(food);
        }
        System.out.println("\nDATABASE CUSTOMER YANG MASUK");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()){
            System.out.println(customer);
        }
        try
        {
            ArrayList<Food> food1 = DatabaseFood.getFoodByCategory(FoodCategory.Beverages);
            ArrayList<Food> food2 = DatabaseFood.getFoodByCategory(FoodCategory.Noodles);

            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,
                    food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
            Thread thread1 = new Thread(new PriceCalculator(DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId())));
            thread1.start();
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, food2, DatabaseCustomer.getCustomerById(2)));
            Thread thread2 = new Thread(new PriceCalculator(DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId())));
            thread2.start();
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, food1, DatabaseCustomer.getCustomerById(3)));
            Thread thread3 = new Thread(new PriceCalculator(DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId())));
            thread3.start();
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        catch (PromoNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }


        /*
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
        System.out.println(DatabaseInvoice.getInvoiceDatabase());*/

    }
}