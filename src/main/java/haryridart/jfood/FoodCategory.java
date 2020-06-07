package haryridart.jfood;
/**
 * Enumeration class FoodCategory 
 * This FoodCategory Enumeration list of food Category
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
    /**
     * FoodCategory method Digunakan untuk set value category
     * @param categoryFood, set category value in string
     */
    FoodCategory(String categoryFood)
    {
        this.categoryFood = categoryFood;
    }
    /**
     * toString Method digunakan untuk mencetak dalam string
     */
    public String toString()
    {
        return categoryFood;
    }
    
}
