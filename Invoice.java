
/**
 * Class Invoice digunakan untuk Merepresentasikan Invoice transaksi. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Invoice
{
    // Mendefinisikan instance variables 
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
    * Merupakan constructor dari Class Invoice untuk membuat Invoice
    * @param id merupakan id Invoice
    * @param idFood merupakan id dari makanan (Food).
    * @param date merupakan tanggal transaksi Invoice
    * @param customer merupakan customer pada Invoice.
    * @param totalPrice merupakan total harga pada Invoice.
    * @return Constructor tidak mengembalikan nilai.
    */
    public Invoice(int id,int idFood,String date,Customer customer,int totalPrice, 
    InvoiceStatus status)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = status;
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
    public int getIdFood()
    {
        return idFood;
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
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
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
    public void setIdFoods(int idFood)
    {
        this.idFood = idFood;
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
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice =totalPrice;
    }
    /**
    * Method ini digunakan untuk menetapkan customer pada Invoice.
    * @param parameter customer merupakan customer dari Invoice.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    /**
    * Method ini digunakan untuk mencetak.
    */
    public void printData()
    {
        System.out.println("==========INVOICE=========");
        System.out.println("ID: " + id);
        System.out.println("Foood ID: " + idFood);
        System.out.println("Date: " + date);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Status: "+ status);
        
    }
    
}
