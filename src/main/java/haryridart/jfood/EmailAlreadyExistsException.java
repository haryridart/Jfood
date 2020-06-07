package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This EmailAlreadyExistsException Class is used to handle error input if email already exist in database
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class EmailAlreadyExistsException extends Exception
{
    private Customer customer_error;
    /**
     * This is constructor for object of class EmailAlreadyExistsException
     * <p>
     * Updates or changes value of customer_error when create objects
     * @param customer_input - first parameter value of constructor
     */
    public EmailAlreadyExistsException(Customer customer_input){
        super("Customer Email: ");
        this.customer_error = customer_input;
    }
    /**
     * This is getMesage method that is used to print error message
     * @return about error message
     */
    public String getExMessage()
    {
        return super.getMessage() + customer_error.getEmail() + " already exists.";
    }
}
