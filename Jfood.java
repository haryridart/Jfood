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
public class Jfood
{
    // instance variables - replace the example below with your own
    public static void main (String [] args){
       
        Location locationObj = new Location("Sukabumi","Jawa Barat", "Rumah Kita Semua" );
        Seller sellerObj = new Seller(1,"Hary","ridarth@gmail.com","6287716381565",locationObj);
        
      
        Calendar joinDate = new GregorianCalendar(2020,01,20);
        System.out.println("====Sebelum Diubah Email dan Password====");
        Customer customerObj1 = new Customer (1,"Hary", "ridarth@gmail.com", "hehe",joinDate);
        Customer customerObj2 = new Customer (1,"Hary", "ridarth@gmail.com", "Tangina123", 2020,03,19);
        Customer customerObj3 = new Customer (1,"Hary", "ridarth@gmail.com", "hehe" );
        
        System.out.println("====Pengubahan Email dan Password====");

        customerObj1.setEmail(",haryridart1@gmail.com");
        customerObj1.setEmail("a,haryridart2@-gmail.com");
        customerObj1.setEmail("haryridart3@gmail.com");

        
        customerObj1.setPassword("1998");
        customerObj1.setPassword("Narumi123");
        customerObj1.setPassword("tesakhir3");
        
         customerObj1.toString();
        // customerObj2.toString();
        // customerObj3.toString();
        
        //Invoice invoiceObj = new Invoice(1,foodObj.getId(),"2020-02-27",customerObj,foodObj.getPrice(),InvoiceStatus.Finished);
        //invoiceObj.printData();
        //Customer customerObj = new Customer(1,"Ridart","ridarth@gmail.com","tanginabobo","2020-03-12");
        // Promo promoObj = new Promo(1,"ASUKABEH",5000,20000,true);
        // Food foodObj = new Food(1,"Bakso",sellerObj,12000,FoodCategory.Beverages);
        // Food foodObj1 = new Food(1,"Mie Ayam",sellerObj,16000,FoodCategory.Beverages);
        // Food foodObj2 = new Food(1,"Babi Panggang",sellerObj,46000,FoodCategory.Beverages);
        
        // CashlessInvoice cashlessInvoiceObj = new CashlessInvoice(
        // 1, foodObj, "12/3/2020", customerObj,InvoiceStatus.Ongoing,promoObj);
        // cashlessInvoiceObj.setTotalPrice();
        // cashlessInvoiceObj.printData();
        
        // CashlessInvoice cashlessInvoiceObj1 = new CashlessInvoice(
        // 2, foodObj1, "12/3/2020", customerObj,InvoiceStatus.Finished);
        // cashlessInvoiceObj1.setTotalPrice();
        // cashlessInvoiceObj1.printData();

        // CashlessInvoice cashlessInvoiceObj2 = new CashlessInvoice(
        // 3, foodObj1, "12/3/2020", customerObj,InvoiceStatus.Finished,promoObj);
        // cashlessInvoiceObj2.setTotalPrice();
        // cashlessInvoiceObj2.printData();
        
        // CashlessInvoice cashlessInvoiceObj3 = new CashlessInvoice(
        // 4, foodObj2, "12/3/2020", customerObj,InvoiceStatus.Finished,promoObj);
        // cashlessInvoiceObj3.setTotalPrice();
        // cashlessInvoiceObj3.printData();
        



        // CashInvoice cashInvoiceObj = new CashInvoice(
        // 1, foodObj, "12/3/2020", customerObj,InvoiceStatus.Finished);
        // cashInvoiceObj.setTotalPrice();
        // cashInvoiceObj.printData();
        
        
        // CashInvoice cashInvoiceObj1 = new CashInvoice(
        // 1, foodObj, "12/3/2020", customerObj,InvoiceStatus.Finished);
        // cashInvoiceObj1.setTotalPrice();
        // cashInvoiceObj1.printData();
        
        // cashInvoiceObj1.setDeliveryFee(6000);
        // CashInvoice cashInvoiceObj2 = new CashInvoice(
        // 1, foodObj, "12/3/2020", customerObj,InvoiceStatus.Finished,cashInvoiceObj1.getDeliveryFee());
        // cashInvoiceObj1.setTotalPrice();
        
        // cashInvoiceObj1.printData();
        
        
        
        
        
        
        
        
        

    }
    
    
    
}









