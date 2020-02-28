
/**
 * Class Customer digunakan untuk Merepresentasikan customer. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Customer
{
    // instance variables - Digunakan pada class Customer
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;
    
    /**
    * Merupakan constructor dari Class Customer untuk membuat Customer
    * @param id merupakan id customer
    * @param name merupakan nama customer
    * @param email merupakan email customer
    * @param password merupakan password customer
    * @param joidDate merupakan tanggal Daftar customer
    * @return Constructor tidak mengembalikan nilai.
    */
    public Customer(int id,String name,String email,String password,String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate  = joinDate;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai Id Customer
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai int dari id.
    */
    public int getId()
    {
        return id;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai nama Customer
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari name.
    */
    public String getName()
    {
        return name;      
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai email Customer
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari email.
    */
    public String getEmail()
    {
        return email;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai password Customer
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari password.
    */
    public String getPassword()
    {
        return password;
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai joinDate Customer
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari joinDate.
    */
    public String getJoinDate()
    {
        return joinDate;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai id Customer
    * @param parameter id merupakan id dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai name Customer
    * @param parameter name merupakan nama dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai email Customer
    * @param parameter email merupakan email dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai password Customer
    * @param parameter password merupakan password dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai joinDate Customer
    * @param parameter joinDate merupakan tanggal Join dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    /**
    * Method ini digunakan untuk mencetak.
    */
    public void printData()
    {
        System.out.println(name);
    }
    
    
    

    
}
