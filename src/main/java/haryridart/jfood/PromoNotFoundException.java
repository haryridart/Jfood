package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This PromoNotFoundException  Class is used to handle error input if promo not found
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class PromoNotFoundException extends Exception
{
    private int promo_error;
    /**
     * This is constructor for object of class PromoNotFoundException
     * <p>
     * Updates or changes value of promo_error when create objects
     * @param promo_input - first parameter value of constructor
     */
    public PromoNotFoundException(int promo_input) {

        super("Promo ID: ");
        this.promo_error = promo_input;
    }
    /**
     * This is getMesage method that is used to print error message
     * @return about error message
     */
    public String getExMessage()
    {
        return super.getMessage() + promo_error + " not found.";
    }
}
