
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hary Ridart
 * @version 2020-03-12
 */
package haryridart.jfood;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * * <h1>Food Order App with Object Oriented Programming<h1>
 * CashlessInvoice Class digunakan untuk processing invoice data jika custonmer menggunakan cashless untuk pembayra
 * CashlessInvoice merupakan subclass dari Invoice Class
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Merupakan constructor dari Class Food untuk membuat Cashless Invoice
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
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo, InvoiceStatus invoiceStatus, Date date, int total_price)
    {
        super(id, foods, customer, invoiceStatus, date, total_price);
        this.promo = promo;
    }
    /**
     * Method ini digunakan untuk mengembalikan nilai PAYMENT_TYPE
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
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

    public String toString() {

        String string = "";
        for (int i = 0; i <= getFoods().size(); i++) {

            if (getPromo() != null && getPromo().getActive() == true && getFoods().get(i).getPrice() > getPromo().getMinPrice()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                LocalDateTime now = LocalDateTime.now();
                string =
                        ("================INVOICE================" +
                                "\nID: " + super.getId() +
                                "\nFood: " + super.getFoods().get(i).getName() +
                                "\nDate: " + dtf.format(now) +
                                "\nCustomer: " + super.getCustomer().getName() +
                                "\nTotal Price: " + getFoods().get(i).getPrice() +
                                "\nPromo:" +getPromo().getCode() +
                                "\nStatus: " + super.getInvoiceStatus() +
                                "\nPayment Type: " + PAYMENT_TYPE + "\n");
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                LocalDateTime now = LocalDateTime.now();
                string =
                        ("================INVOICE================" +
                                "\nID: " + super.getId() +
                                "\nFood: " + super.getFoods().get(i).getName() +
                                "\nDate: " + dtf.format(now) +
                                "\nCustomer: " + super.getCustomer().getName() +
                                "\nTotal Price: " + super.getTotalPrice() +
                                "\nStatus: " + super.getInvoiceStatus() +
                                "\nPayment Type: " + PAYMENT_TYPE + "\n");
            }

        }
        return string;
    }
}
