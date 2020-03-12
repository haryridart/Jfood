
/**
 * Enumeration class InvoiceStatus 
 * Digunakan untuk dipanggil terhadap invoiceStatus yang akan digunakan
 * @author Hary Ridart
 * @version 2020-03-12
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String statusInvoice;
    InvoiceStatus(String statusInvoice)
    {
        this.statusInvoice = statusInvoice;
    }
    public String toString()
    {
        return statusInvoice;
    }
}
