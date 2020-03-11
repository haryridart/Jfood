
/**
 * Write a description of class Jfood here.
 *
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Jfood
{
    // instance variables - replace the example below with your own
    public static void main (String [] args){
       
        Location locationObj = new Location("Sukabumi","Jawa Barat", "Rumah Kita Semua" );
        Seller sellerObj = new Seller(1,"Hary","ridarth@gmail.com","6287716381565",locationObj);
        Food foodObj = new Food(1,"Bakso",sellerObj,5000,FoodCategory.Beverages);
        Customer customerObj = new Customer(1,"ukok","ukok@gmail.com","ukok2123","2020-02-27");
        Invoice invoiceObj = new Invoice(1,foodObj.getId(),"2020-02-27",customerObj,foodObj.getPrice(),InvoiceStatus.Finished);
        invoiceObj.printData();

        
        

        
        
        
        
        
        
        
        
        
        

    }
    
}
