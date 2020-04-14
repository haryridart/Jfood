package haryridart.jfood;
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");
    
    private String typePayment;
    PaymentType(String typePayment)
    {
        this.typePayment = typePayment;
    }
    public String toString()
    {
        return typePayment;
    }
}
