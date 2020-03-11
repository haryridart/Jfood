
/**
 * Class Food digunakan untuk Merepresentasikan Makanan (Food). 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Food
{
    // Mendefinisikan instance variables 
    private int id;
    private String name;
    private int price;
    private FoodCategory category;
    private Seller seller;
    

    /**
    * Merupakan constructor dari Class Food untuk membuat Food
    * @param id merupakan id makanan(Food)
    * @param name merupakan nama dari makanan.
    * @param seller merupakan informasi Seller makanan(Food)
    * @param price merupakan harga dari makanan(Food).
    * @param category merupakan kategori makanan(Food).
    * @return Constructor tidak mengembalikan nilai.
    */
    public Food(int id,String name,Seller seller,int price, FoodCategory category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }
    /**
    * Method ini digunakan untuk mengembalikan seller Food.
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai variable seller Food.
    */
    public Seller getSeller()
    {
        return seller;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id makanan(Food)
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari id makanan(Food).
    */
    public int getId()
    {
        return id;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai nama makanan(Food)
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari name.
    */
    public String getName()
    {
        return name;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai harga makanan(Food)
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari price.
    */
    public int getPrice()
    {
        return price;
    }
    
    /**
    * Method ini digunakan untuk mengembalikan nilai category makanan(Food)
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari category.
    */
    public FoodCategory getCatergory()
    {
        return category;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai id makanan(Food).
    * @param parameter id merupakan id dari makanan(Food).
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai name makanan(Food)
    * @param parameter name merupakan nama dari makanan(Food).
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setName(String name)
    {
        this.name =name;
    }
    /**
    * Method ini digunakan untuk menetapkan variable Seller makanan(Food)
    * @param parameter seller merupakan informasi seller dari makanan(Food).
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setSeller(Seller seller)
    {
        this.seller =seller;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai price makanan(Food).
    * @param parameter price merupakan harga pada makanan(Food).
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setPrice(int price)
    {
        this.price = price;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai category makanan(Food)
    * @param parameter category merupakan ketegori dari makanan(Food).
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setCategory(FoodCategory category)
    {
        this.category = category;
    }
    /**
    * Method ini digunakan untuk mencetak.
    */
    public void printData()
    {
        System.out.println("==============FOOD============");
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
        System.out.println("Seller:" + seller.getName());
        System.out.println("City:" + seller.getLocation().getCity());
        System.out.println("Price:" + price);
        System.out.println("Category" + category);
    }
}
