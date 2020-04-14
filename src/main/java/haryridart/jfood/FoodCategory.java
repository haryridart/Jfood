package haryridart.jfood;
/**
 * Enumeration class FoodCategory 
 * Digunakan untuk dipanggil terhadap jenis makanan yang akan digunakan
 * @author Hary Ridart
 * @version 2020-03-12
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
