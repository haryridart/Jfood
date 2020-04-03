
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hary Ridart
 * @version 2020-03-12
 */

import java.util.*;
import java.text.SimpleDateFormat;   
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
    * Merupakan constructor dari Class Food untuk membuat Food


    */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id,foods,customer);
        setTotalPrice();
    }
    /**
    * Merupakan method overload dari method ClashlessInvoice 

    */
    public CashlessInvoice(int id, ArrayList<Food> food, Customer customer,Promo promo)
    {
        // put your code here
        super(id,food,customer);
        this.promo = promo;
        setTotalPrice();
        
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai PAYMENT_TYPE

    */
    public PaymentType getPaymentType()
    {
         return null;
    }
    /**
    * Method ini digunakan untuk mengembalikan promo

    */
    public Promo getPromo()
    {
        return promo;
    }
    /**
    * Method ini digunakan untuk menetapkan promo

    */
    public void setPromo (Promo promo)
    {
        this.promo = promo;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai dengan ketentuan tertentu

    */
    public void setTotalPrice(){
        int totalFoodPrice =0;
        for(int i=0;i<getFoods().size();i++){
            totalFoodPrice = totalFoodPrice+ getFoods().get(i).getPrice() ;
        }

        if( promo != null){
            if (promo.getActive() == true && totalFoodPrice >promo.getMinPrice()){
                super.totalPrice = (totalFoodPrice - promo.getDiscount() );
            }
            else{
                super.totalPrice = totalFoodPrice;
            }
        }
        else{
            super.totalPrice = totalFoodPrice;
        }
    }
    /**
    * Method ini digunakan untuk mencetak data CashlessInvoice

    */
    
    public String toString()
   
    {
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date1 = format1.format(getDate().getTime());
        String print;
        String foodIn= "";
        for(int i=0;i<getFoods().size();i++){
            foodIn = foodIn+ getFoods().get(i).getName() + " ";
        }
            print  = "=====INVOICE====="+
                   "\nID = "+getId()+
                   "\nFood = "+ foodIn+
                   "\nDate = "+date1+
                   "\nCostumer = "+getCustomer().getName();
                    if(promo != null){
                    print = print+"\nPromo :" + promo.getCode();
                    }
                    print = print + "\nTotal price = "+totalPrice+
                   "\nStatus: "+ getInvoiceStatus()+
                   "\nPayment Type = "+PAYMENT_TYPE+"\n";
        return print;
    }
}
