package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This InvoiceStatus Enumeration list of status invoice
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String statusInvoice;
    /**
     * This is InvoiceStatus method that is used to set status value, that status is instance variable
     * @param statusInvoice, set status value in string
     */
    InvoiceStatus(String statusInvoice)
    {
        this.statusInvoice = statusInvoice;
    }
    /**
     * This is toString method that is used to print status in string
     */
    public String toString()
    {
        return statusInvoice;
    }
}
