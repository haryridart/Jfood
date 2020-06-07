package haryridart.jfood;
/**
 * Enumeration class PaymentType
 * This PaymentType Enumeration list of payment type
 * @author Hary Ridart
 * @version 2020-03-12
 */
public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");

    private String typePayment;
    /**
     * This is PaymentType method that is used to set payment value, that payment is instance variable
     * @param typePayment set status value in string
     */
    PaymentType(String typePayment)
    {
        this.typePayment = typePayment;
    }
    /**
     * This is toString method that is used to print payment in string
     */
    public String toString()
    {
        return typePayment;
    }
}
