/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hary Ridart
 * @version 2020-03-12
 */

public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
    * Merupakan constructor dari Class Food untuk membuat Food
    * @param id merupakan id makanan(Food)
    * @param name merupakan nama dari makanan.
    * @param seller merupakan informasi Seller makanan(Food)
    * @param price merupakan harga dari makanan(Food).
    * @param category merupakan kategori makanan(Food).
    * @return Constructor tidak mengembalikan nilai.
    */
    public CashInvoice(int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        // initialise instance variables
        super(id,food,date,customer,invoiceStatus);
    }
    /**
    * Merupakan method overload dari method ClashlessInvoice 
    * @param id merupakan id Invoice
    * @param date merupakan date dari makanan.
    * @param customerr merupakan customer yang dicatat invoice
    * @param invoiceStatus merupakan status Invoice
    * @param promo merupakan objek promo yang digunakan
    * @return Constructor tidak mengembalikan nilai.
    */
    public CashInvoice(int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus, int deliveryFee)
    {
        // put your code here
        super(id,food,date,customer,invoiceStatus);
        this.deliveryFee = deliveryFee;
        
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai PAYMENT_TYPE
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai PAYMENT_TYPE
    */
    public PaymentType getPaymentType()
    {
         return PAYMENT_TYPE;
    }
    /**
    * Method ini digunakan untuk mengembalikan promo
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai promo
    */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    /**
    * Method ini digunakan untuk menetapkan promo
    * @param parameter promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setDeliveryFee (int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai dengan ketentuan tertentu
    * @param tidak ada parameter yang digunakan
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setTotalPrice()
    {
        if(deliveryFee >=0)
        {
             
            super.totalPrice = getFood().getPrice() + getDeliveryFee();
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    /**
    * Method ini digunakan untuk mencetak data CashlessInvoice
    * @param tidak ada parameter yang digunakan
    * @return Method ini tidak mengembalikan nilai.
    */
    @Override
    public void printData()
    {
        if(deliveryFee >= 0)
        {
            System.out.println("=========INVOICE=========");
            System.out.println("ID: " + getId());
            System.out.println("Food: " + getFood().getName());
            System.out.println("Date: " + super.getFood().getName());
            System.out.println("Customer: "+ super.getCustomer().getName());
            System.out.println("Delivery Fee: " + getDeliveryFee());
            System.out.println("Total Price: " + getTotalPrice() );
            System.out.println("Status: " + getInvoiceStatus());
            System.out.println("Payment: " + getPaymentType());
            
        }
        else
        {
            System.out.println("=========INVOICE=========");
            System.out.println("ID: " + getId());
            System.out.println("Date: " + super.getFood().getName());
            System.out.println("Customer: "+ super.getCustomer().getName());
            System.out.println("Total Price: " + getTotalPrice());
            System.out.println("Status: " + getInvoiceStatus());
            System.out.println("Payment: " + getPaymentType());
        }
    }
}

