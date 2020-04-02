/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hary Ridart
 * @version 2020-03-12
 */
import java.util.*;
import java.text.SimpleDateFormat;
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
    * Merupakan constructor dari Class Food untuk membuat Food


    */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id,foods,customer);
        setTotalPrice();
        
    }
    /**
    * Merupakan method overload dari method ClashlessInvoice 


    */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        // put your code here
        super(id,foods,customer);
        this.deliveryFee = deliveryFee;
        setTotalPrice();
        
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai PAYMENT_TYPE

    * @return Method ini mengembalikan nilai PAYMENT_TYPE
    */
    public PaymentType getPaymentType()
    {
         return PAYMENT_TYPE;
    }
    /**
    * Method ini digunakan untuk mengembalikan promo

    * @return Method ini mengembalikan nilai promo
    */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    /**
    * Method ini digunakan untuk menetapkan promo

    * @return Method ini tidak mengembalikan nilai.
    */
    public void setDeliveryFee (int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai dengan ketentuan tertentu

    * @return Method ini tidak mengembalikan nilai.
    */
    public void setTotalPrice(){
        int totalFoodPrice =0;
        for(int i=0;i<getFoods().size();i++){
            totalFoodPrice = totalFoodPrice+ getFoods().get(i).getPrice() ;
        }

        if( deliveryFee != -1  ){
            super.totalPrice = totalFoodPrice + deliveryFee;
        }
        else{
            super.totalPrice = totalFoodPrice;
        }
    }
    /**
    * Method ini digunakan untuk mencetak data CashlessInvoice

    * @return Method ini tidak mengembalikan nilai.
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
            print  = "======INVOICE======"+
                   "\nID = "+super.getId()+
                   "\nFood = " +foodIn +
                   "\nDate = "+date1+
                   "\nCustomer = "+super.getCustomer().getName()+
                   "\nDelivery Fee = "+deliveryFee+
                   "\nTotal Price = "+super.totalPrice+
                   "\nStatus : " + super.getInvoiceStatus()+
                   "\nPayment Type : "+ PAYMENT_TYPE;
            //System.out.println(print);
            return print;      

    }
}

