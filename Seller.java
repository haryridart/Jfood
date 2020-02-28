
/**
 * Class Seller digunakan untuk Merepresentasikan Seller. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Seller
{
    // Mendefinisikan instance variables 
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    Location location;
   
    
    
    /**
    * Merupakan constructor dari Class Seller untuk membuat Seller
    * @param id merupakan id Seller
    * @param name merupakan nama Seller
    * @param email merupakan email Seller
    * @param phoneNumber merupakan Nomor Telepon Seller.
    * @param location merupakan informasi lokasi Seller.
    * @return Constructor tidak mengembalikan nilai.
    */
    public Seller(int id, String name,String email,String phoneNumber,Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;

    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id Seller
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari id.
    */
    public int getId()
    {
        return id;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai nama Seller
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari name.
    */
    public String getName()
    {
        return name;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai email Seller
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari email.
    */
    public String getEmail()
    {
        return email;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai phoneNumber Seller
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari nomor telepon Seller.
    */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai location Seller
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai variable location dari Seller.
    */
    public Location getLocation()
    {
        return location;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai id Seller.
    * @param parameter id merupakan id dari Seller.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setId(int id)
    {
       this.id = id; 
    }
    /**
    * Method ini digunakan untuk menetapkan nilai name Seller
    * @param parameter name merupakan nama dari Seller.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai email Seller
    * @param parameter email merupakan email dari Seller.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai phoneNumber Seller
    * @param parameter phoneNumber merupakan nomor telepon dari Seller.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai location Seller
    * @param parameter location merupakan informasi lokasi dari Seller.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    /**
    * Method ini digunakan untuk mencetak.
    */
    public void printData()
    {
        System.out.println(name);
    }
}
