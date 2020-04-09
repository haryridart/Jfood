public class PriceCalculator implements Runnable
{
    Invoice input;
    PriceCalculator(Invoice input){
        this.input = input;
    }
    @Override
    public void run()
    {
        System.out.println("Calculating Invoice ID: " + input.getId());
        input.setTotalPrice();
        System.out.println("Finish calculating Invoice ID: " + input.getId());
    }
}

