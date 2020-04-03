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
    public static Customer getCustomerById(int id)
    {
        boolean checking = false;
        for(int i=0;i<CUSTOMER_DATABASE.size();i++){
            if(CUSTOMER_DATABASE.get(i).getId() == id){
                checking = true;
                return CUSTOMER_DATABASE.get(i);

            }
        }
        return null;
    }

    public static boolean addCustomer(Customer customer)
    {
        // put your code here
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId()+1;
        return true;
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
