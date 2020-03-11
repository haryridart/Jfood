
/**
 * Enumeration class FoodCategory - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum FoodCategory
{
    Beverages("Beverages"),
    Coffe("Coffee"),
    Western("Western"),
    Snacks("Snacks"),
    Rice("Rice"),
    Noodles("Noodles"),
    Bakery("Bakery"),
    Japanese("Japanese");
    
    private String categoryFood;
    FoodCategory(String categoryFood)
    {
        this.categoryFood = categoryFood;
    }
    public String toString()
    {
        return categoryFood;
    }
    
}
