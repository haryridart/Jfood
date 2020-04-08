import java.util.ArrayList;
import java.util.Objects;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (Hary Ridart)
 * @version (02-04-2020)
 */
public class DatabaseCustomer
{
    // Mendefinisikan instance variables
    private static ArrayList<Customer> CUSTOMER_DATABASE= new ArrayList<Customer>();
    private static int lastId=0;

    public DatabaseCustomer(){

    }
    public static ArrayList<Customer> getCustomerDatabase(){
        //return customer;
        return CUSTOMER_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }
    public static Customer getCustomerById(int id){
        for (Customer customer : CUSTOMER_DATABASE){
            if (customer.getId() == id ){
                return customer;
            }
        }
        return null;
    }

    public static boolean addCustomer(Customer customer) {
        boolean sameEmailBuff = false;
        for (Customer buff: CUSTOMER_DATABASE) {
            if (customer.getEmail().equals(buff.getEmail())) {
                sameEmailBuff = true;
                break;
            }
        }

        if (!sameEmailBuff) {
            CUSTOMER_DATABASE.add(customer);
            lastId = customer.getId();
        }
        return false;
    }
    public static boolean removeCustomer(int id){
        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(customer.getId()==id)
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;

    }


}
