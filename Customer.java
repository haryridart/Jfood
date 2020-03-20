
/**
 * Class Customer digunakan untuk Merepresentasikan customer. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
import java.util.Calendar;
import java.util.GregorianCalendar; 
import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Customer
{
    // instance variables - Digunakan pada class Customer
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;
    
    /**
    * Merupakan constructor dari Class Customer untuk membuat Customer
    * @param id merupakan id customer
    * @param name merupakan nama customer
    * @param email merupakan email customer
    * @param password merupakan password customer
    * @param joidDate merupakan tanggal Daftar customer
    * @return Constructor tidak mengembalikan nilai.
    */
    public Customer(int id,String name,String email,String password,Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate  = joinDate;
        setEmail(email);
        setPassword(password);
    }
    public Customer(int id,String name,String email,String password,
    int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = new GregorianCalendar(year,month,dayOfMonth);
        setEmail(email);
        setPassword(password);
        
        
    }
    public Customer(int id,String name,String email,String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        setEmail(email);
        setPassword(password);
        this.joinDate = Calendar.getInstance();
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
    public Calendar getJoinDate()
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
        String expression = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@"
        + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find())
        {
            System.out.println("Email : " + matcher.group());
            this.email = email;
        }
        else
        {
            System.out.println("Email : NULL");
            this.email = email;
        }
    }
    /**
    * Method ini digunakan untuk menetapkan nilai password Customer
    * @param parameter password merupakan password dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setPassword(String password)
    {
        String expression = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(password);
        if(matcher.find())
        {
            System.out.println("Password: " + matcher.group());
            this.password = password;
            
        }
        else
        {
            System.out.println("Password: NULL");
            this.password = password;
        }
        
    }
    /**
    * Method ini digunakan untuk menetapkan nilai joinDate Customer
    * @param parameter joinDate merupakan tanggal Join dari customer.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year,month,dayOfMonth);
    }
    /**
    * Method ini digunakan untuk mencetak.
    */
    public String toString()
    {
        
        return "\nID: " + id +
        "\nNama: " + name +
        "\nEmail: " + email +
        "\nPassword: " + password +
        "\nJoin Date: " + joinDate;
    } 
    
}







