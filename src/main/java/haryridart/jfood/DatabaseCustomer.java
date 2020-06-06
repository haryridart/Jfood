package haryridart.jfood;
import java.util.ArrayList;
import java.util.Objects;

/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This DatabaseCostumer Class is used to precessing database of customer
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class DatabaseCustomer
{
    //instance variables
    private static ArrayList<Customer> CUSTOMER_DATABASE= new ArrayList<Customer>();
    private static int lastId=0;
    /**
     * Constructor for objects of class DatabaseCustomer
     */
    public DatabaseCustomer(){

    }
    /**
     * This is getCustomerDatabase method, that is used to get data of all customer in database
     * @return CUSTOMER_DATABASE, return costumer object in array list
     */
    public static ArrayList<Customer> getCustomerDatabase(){
        //return customer;
        return CUSTOMER_DATABASE;
    }
    /**
     * This is getLastCustomerId method, that is used to get last id of customer in database
     * @return lasId, return costumer id
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * This is getCustomerById method, that is used to get data of customer in database
     * @params id, this parameter to select customer by id
     * @return customer, return costumer object that is selected
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        for (Customer customer : CUSTOMER_DATABASE){
            if (customer.getId() == id ){
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }
    /**
     * This is addCustomer method, that is used to add customer in database
     * @params customer, this is parameter to insert customer object into database
     * @return true, if add is succeeded
     * @return false, if add is not succeeded
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException{
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
            return true;
        }
        throw new EmailAlreadyExistsException(customer);
    }
    /**
     * This is removeCustomer method, that is used to remove data of customer in database
     * @params customerId, this parameter to select customer by id
     * @return true, if remove is succeeded
     * @return false, if remove is not succeeded
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(customer.getId()==id)
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }
    /**
     * This is getCustomerLogin method, that is used to get data of customer in database
     * @params email, this is first parameter to select customer data by email
     * @params password, this is second parameter to select customer data by password
     * @return customer, return costumer object that is selected
     */
    public static Customer getCustomerLogin(String email, String password){
        for(Customer customer : CUSTOMER_DATABASE){
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                return customer;
            }
        }
        return null;
    }
}
