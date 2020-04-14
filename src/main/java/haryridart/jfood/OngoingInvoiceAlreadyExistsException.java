package haryridart.jfood;
public class OngoingInvoiceAlreadyExistsException extends Exception
{
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super(" Ongoing Invoice : ");
        this.invoice_error=invoice_input;
    }


    public String getExMessage(){
        return super.getMessage() + invoice_error.getFoods()
                + " already Exist and ordered by: " + invoice_error.getCustomer().getName();
    }
}
