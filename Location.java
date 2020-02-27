
/**
 * Write a description of class Location here.
 *
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String province;
    private String description;
    private String city;
    

    /**
     * Constructor for objects of class Location
     */
    public Location(String city,String province,String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getProvince()
    {
        return province;
    }
    public String getCity()
    {
        return city;
    }
    public String getDescription()
    {
        return description;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void printData()
    {
        System.out.println(province);
    }
}
