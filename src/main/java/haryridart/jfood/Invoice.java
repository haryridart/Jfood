package haryridart.jfood;
/**
 * Class Invoice digunakan untuk Merepresentasikan Invoice transaksi. 
 * @author Hary Ridart
 * @version 2020-03-12
 */
import java.util.*;
import java.text.SimpleDateFormat;

public abstract class Invoice
{
    // Mendefinisikan instance variables 
    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    private Date dateInsert;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;


    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
        this.id = id;
        this.foods = foods;
        this.date = Calendar.getInstance();
        this.customer = customer;
        this.invoiceStatus = InvoiceStatus.Ongoing;
    }
    public Invoice(int id, ArrayList<Food> foods, Customer customer, InvoiceStatus invoiceStatus, Date date, int totalPrice)
    {
        this.id = id;
        this.foods = foods;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
        this.dateInsert = date;
        this.totalPrice = totalPrice;

    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id Invoice

    * @return Method ini mengembalikan nilai int dari id Invoice.
    */
    public int getId()
    {
        return id;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id makanan Invoice
    * @return Method ini mengembalikan nilai int dari id makanan pada Invoice.
    */
    public ArrayList<Food> getFoods()
    {
        return foods;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai date pada Invoice

    * @return Method ini mengembalikan nilai string dari date Invoice.
    */
    public Calendar getDate()
    {
        return date;
    }
    public Date getDateInsert()
    {
        return dateInsert;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai totalPrice Invoice

    * @return Method ini mengembalikan nilai int dari totalPrice.
    */
    public int getTotalPrice(){ //mengembalikan total harga
        return totalPrice;

    }
    /**
    * Method ini digunakan untuk mengembalikan nilai customer pada Invoice.
    * @return Method ini mengembalikan variable customer pada Invoice.
    */
    public Customer getCustomer()
    {
        return customer;
    }
    /**
    * Abstract Method ini digunakan untuk mendefinisikan method getPaymentType untuk dapat digunakan pada class lain.

    */
    public abstract PaymentType getPaymentType();
    /**
    * Method ini digunakan untuk mengembalikan nilai invoiceStatus pada Invoice.

    * @return Method ini mengembalikan variasetfoodble invoiceStatus pada Invoice.
    */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai id Invoice.

    * @return Method ini tidak mengembalikan nilai.
    */
    public void setId(int id)
    {
        this.id = id;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus= invoiceStatus;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai idFood Invoice.

    * @return Method ini tidak mengembalikan nilai.
    */
    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai date pada Invoice.

    * @return Method ini tidak mengembalikan nilai.
    */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year,month,dayOfMonth);
    }
    /**
    * Method ini digunakan untuk menetapkan nilai totalPrice Invoice.

    * @return Method ini tidak mengembalikan nilai.
    */
    public abstract void setTotalPrice();
    
    /**
    * Method ini digunakan untuk menetapkan customer pada Invoice.

    * @return Method ini tidak mengembalikan nilai.
    */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
    * Method Abstract ini digunakan untuk mencetak dapat digunakan pada class lain.
    */

    public abstract String toString();
    
    
}
