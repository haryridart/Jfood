/**
 * Write a description of class Jfood here.
 *
 * @author Hary Ridart
 * @version 2020-02-27
 */
package haryridart.jfood;
import java.io.*;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.GregorianCalendar;
@SpringBootApplication
public class Jfood
{
    public static void main(String[] args) {

        Location locationObj = new Location("Sukabumi", "Jawa Barat", "Rumah Kita Semua");
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Hary", "hary@gmail.com", "085285237993", locationObj)));
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Ridart", "ridart@gmail.com", "085285237993", locationObj)));
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Frenze", "frenzel@gmail.com", "085285237993", locationObj)));
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Babi Panggang",DatabaseSeller.getSellerById(1),39000,FoodCategory.Noodles));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"ES Teler",DatabaseSeller.getSellerById(1),39000,FoodCategory.Coffe));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(1),13000,FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Mie Ayam", DatabaseSeller.getSellerById(1),16000,FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        SpringApplication.run(Jfood.class, args);


        /*Location locationObj = new Location("Sukabumi", "Jawa Barat", "Rumah Kita Semua");
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Narumi", "narumi@gmail.com", "085285237993", locationObj)));*/
        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridart", "Ridart@gmail.com", "hary1", new GregorianCalendar(2020, 4, 2)));
        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Frenzel", "frenzel@gmail.com", "frenly123", new GregorianCalendar(2020, 5, 2)));
        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }/*
        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Narumikunn", "narumi@gmail.com", "narumi", new GregorianCalendar(2020, 1, 2)));
        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridart", "Ridart@gmail.com", "hary1", new GregorianCalendar(2020, 4, 2)));
        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SENDNUKE", 2000,15000,false)));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabasePromo.addPromo((new Promo(DatabasePromo.getLastId()+1,"SENDNUKE", 5000,30000,true)));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Babi Panggang",DatabaseSeller.getSellerById(1),39000,FoodCategory.Noodles));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"ES Teler",DatabaseSeller.getSellerById(1),39000,FoodCategory.Coffe));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(1),13000,FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1,"Mie Ayam", DatabaseSeller.getSellerById(3),16000,FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
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

        ArrayList<Food> food1 = DatabaseFood.getFoodByCategory(FoodCategory.Beverages);
        ArrayList<Food> food2 = DatabaseFood.getFoodByCategory(FoodCategory.Noodles);
        ArrayList<Food> food3 = DatabaseFood.getFoodByCategory(FoodCategory.Coffe);
        *//*try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1)));
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, food2, DatabaseCustomer.getCustomerById(2)));

        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, food2, DatabaseCustomer.getCustomerById(3)));
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            new Thread(new PriceCalculator(invoice)).start();
        }*//*

        //POST TEST
        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, food2, DatabaseCustomer.getCustomerById(3)));
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, food3, DatabaseCustomer.getCustomerById(3)));
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseInvoice.removeInvoice(6);
        }
        catch (InvoiceNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }

        System.out.println("\nDATABASE INVOICE YANG MASUK");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoice);
        }*/

    }
}