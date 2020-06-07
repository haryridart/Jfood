package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This PriceCalculator Class is used to calculate price in thread mode
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class PriceCalculator implements Runnable
{
    Invoice input;
    /**
     * This is constructor for object of class Invoice
     * <p>
     * Updates or changes value of invoice
     * @param input - first parameter value of constructor
     */
    PriceCalculator(Invoice input){
        this.input = input;
    }
    /**
     * This is run method that used to run calculate price
     */
    @Override
    public void run()
    {
        System.out.println("Calculating Invoice ID: " + input.getId());
        input.setTotalPrice();
        System.out.println("Finish calculating Invoice ID: " + input.getId());
    }
}
