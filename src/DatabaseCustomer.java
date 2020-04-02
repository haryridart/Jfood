import java.util.ArrayList;

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

    public static boolean addCustomer(Customer customer) {
        boolean sameEmailBuff = false;
        for (Customer buff: CUSTOMER_DATABASE) {
            if (customer.getEmail() == buff.getEmail()) {
                sameEmailBuff = true;
            }
        }

        if (!sameEmailBuff) {
            CUSTOMER_DATABASE.add(customer);
            lastId = CUSTOMER_DATABASE.indexOf(customer);
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
