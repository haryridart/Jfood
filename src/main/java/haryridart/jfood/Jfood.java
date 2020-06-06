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

        Location locationObj = new Location("Sukabumi", "Jawa Barat", "Kp.Palabuhan Ratu No.7");
        DatabaseSeller.addSeller((new Seller(DatabaseSeller.getLastId()+1 , "Hary", "hary@gmail.com", "085285237993", locationObj)));
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Indomie Babi Gulung",DatabaseSeller.getSellerById(1),39000,FoodCategory.Noodles));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Kopi Tubruk Atlantis",DatabaseSeller.getSellerById(1),39000,FoodCategory.Coffe));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }

        SpringApplication.run(Jfood.class, args);




    }
}