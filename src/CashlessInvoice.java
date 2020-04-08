
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
        String foodName= "";
        for(int i=0;i<getFoods().size();i++){
            foodName = foodName+ getFoods().get(i).getName() + " ";
        }
        String a = "======INVOICE======\n" +
                "Food :" + foodName;
        if(super.getDate() != null){
            a = a+ "\nDate :" + super.getDate().get(Calendar.DAY_OF_MONTH) + "-" + super.getDate().get(Calendar.MONTH) + "-"+ super.getDate().get(Calendar.YEAR) ;

        }
        a = a+
                "\nCustomer :" + super.getCustomer().getName();
        if(promo != null){
            a = a+"\nPromo :" + promo.getCode();
        }
        a = a+ "\nTotal price :" + getTotalPrice()+
                "\nStatus :" + super.getInvoiceStatus() +
                "\nPayment Type :" + PAYMENT_TYPE;

        return a;
    }
}
