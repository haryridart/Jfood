
/**
 * Write a description of class Promo here.
 *
 * @author Hary Ridart
 * @version 2020-03-12
 */
public class Promo
{
    // instance variables - replace the example below with your own
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
    * Merupakan constructor dari Class Promo untuk membuat Promo
    * @param id merupakan id promo
    * @param code merupakan code promo
    * @param discount merupakan nilai discount promo
    * @param minPrice merupakan minimal harga untuk mendapat promo
    * @param active merupakan nilai promo apakah aktif atau tidak
    * @return Constructor tidak mengembalikan nilai.
    */
    public Promo(int id, String code, int discount, int minPrice,
    boolean active)
    {
        // initialise instance variables
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id Promo
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari id Promo
    */
    public int getId()
    {
        return id;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai code Promo
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai String code promo
    */
    public String getCode()
    {
        return code;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai discount
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai discount promo
    */
    public int getDiscount()
    {
        return discount;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai minPrice
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai minimal harga untuk promo
    */
    public int getMinPrice()
    {
        return minPrice;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai active
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai apakah promo aktif
    */
    public boolean getActive()
    {
        return active;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai id promo
    * @param parameter id merupakan id dari promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai code promo
    * @param parameter code merupakan code dari promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setCode(String code)
    {
        this.code = code;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai discount promo
    * @param parameter discount merupakan discount promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai minPrice promo
    * @param parameter minPrice merupakan harga minimal untuk mendapat promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai active promo
    * @param parameter active merupakan nilai aktif dari promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    /**
    * Method ini digunakan untuk mencetak data Promo
    * @param method ini tidak memiliki parameter
    * @return Method ini tidak mengembalikan nilai.
    */
    public void printData()
    {
        System.out.println(id);
        System.out.println(code);
        System.out.println(discount);
        System.out.println(minPrice);
        System.out.println(active);
    }
        
}
