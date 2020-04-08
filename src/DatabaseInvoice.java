import java.util.ArrayList;
public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId=0;


    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }
    public static int getLastId(){
        return lastId;
    }


    public static boolean addInvoice(Invoice invoice)  {
        boolean sameStatusBuff = false;
        for (Invoice buff: INVOICE_DATABASE) {
            if (invoice.getInvoiceStatus().equals(InvoiceStatus.Ongoing)) {
                sameStatusBuff = true;
                break;
            }
        }
        if (!sameStatusBuff) {
            INVOICE_DATABASE.add(invoice);
            lastId = invoice.getId();
            return true;
        }
        return false;
    }
    public static Invoice getInvoiceById(int id){
        Invoice value=null;
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId()==id)
            {
                value=invoice;
            }
        }
        return value;

    }
    public  static  ArrayList<Invoice> getInvoiceByCustomer(int customerId){

        boolean checker = false;
        ArrayList<Invoice> temp  = new ArrayList<Invoice>();
        for(int i=0;i<INVOICE_DATABASE.size();i++){
            if(INVOICE_DATABASE.get(i).getCustomer().getId() == customerId){
                temp.add(INVOICE_DATABASE.get(i));
                checker = true;
            }
        }
        if (checker) {
            return temp;
        }
        return temp;

    }

    public static  boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice temp : INVOICE_DATABASE)
        {
            if(temp.getId() == id)
            {
                if(temp.getInvoiceStatus() == InvoiceStatus.Ongoing)
                {
                    temp.setInvoiceStatus(InvoiceStatus.Finished);
                    return true;
                }
            }
        }
        return false;
    }
    public  static boolean removeInvoice(int id)
    {   boolean checker = false;
        for(int i=0;i<INVOICE_DATABASE.size();i++){
            if(INVOICE_DATABASE.get(i).getId() == id){
                checker = true;
                INVOICE_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }


}

