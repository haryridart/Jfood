
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
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
