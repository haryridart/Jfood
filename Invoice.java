
/**
 * Class Invoice digunakan untuk Merepresentasikan Invoice transaksi. 
 * @author Hary Ridart
 * @version 2020-03-12
 */
public abstract class Invoice
{
    // Mendefinisikan instance variables 
    private int id;
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;

    /**
    * Merupakan constructor dari Class Invoice untuk membuat Invoice
    * @param id merupakan id Invoice
    * @param idFood merupakan id dari makanan (Food).
    * @param date merupakan tanggal transaksi Invoice
    * @param customer merupakan customer pada Invoice.
    * @param invoiceStatus merupakan status Invoice pada Invoice.
    * @return Constructor tidak mengembalikan nilai.
    */
    public Invoice(int id,Food food,String date,Customer customer, 
    InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id Invoice
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari id Invoice.
    */
    public int getId()
    {
        return id;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id makanan Invoice
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari id makanan pada Invoice.
    */
    public Food getFood()
    {
        return food;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai date pada Invoice
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari date Invoice.
    */
    public String getDate()
    {
        return date;
    }    
    /**
    * Method ini digunakan untuk mengembalikan nilai totalPrice Invoice
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari totalPrice.
    */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai customer pada Invoice.
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan variable customer pada Invoice.
    */
    public Customer getCustomer()
    {
        return customer;
    }
    /**
    * Abstract Method ini digunakan untuk mendefinisikan method getPaymentType untuk dapat digunakan pada class lain.
    * @param Tidak ada parameter yang digunakan pada method ini.
    */
    public abstract PaymentType getPaymentType();
    /**
    * Method ini digunakan untuk mengembalikan nilai invoiceStatus pada Invoice.
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan variable invoiceStatus pada Invoice.
    */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai id Invoice.
    * @param parameter id merupakan id dari Invoice.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai idFood Invoice.
    * @param parameter idFood merupakan id dari Food pada Invoice.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setFood(Food food)
    {
        this.food = food;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai date pada Invoice.
    * @param parameter date merupakan tanggal pada Invoice.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setDate(String date)
    {
        this.date = date;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai totalPrice Invoice.
    * @param parameter totalPrice merupakan total harga pada Invoice.
    * @return Method ini tidak mengembalikan nilai.
    */
    public abstract void setTotalPrice();
    
    /**
    * Method ini digunakan untuk menetapkan customer pada Invoice.
    * @param parameter customer merupakan customer dari Invoice.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    /**
    * Method Abstract ini digunakan untuk mencetak dapat digunakan pada class lain.
    */

    public abstract void printData();
    
    
}
