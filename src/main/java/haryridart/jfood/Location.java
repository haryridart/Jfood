package haryridart.jfood;
/**
 * Class Location digunakan untuk Merepresentasikan Lokasi. 
 * @author Hary Ridart
 * @version 2020-02-27
 */
public class Location
{
    // Mendefinisikan instance variables 
    private String province;
    private String description;
    private String city;
    

    /**
    * Merupakan constructor dari Class Location untuk membuat lokasi.
    * @param city merupakan kota pada Location.
    * @param province merupakan provinsi pada Location.
    * @param description merupakan deskripsi pada Location.
    * @return Constructor tidak mengembalikan nilai.
    */
    public Location(String city,String province,String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
    * Method ini digunakan untuk mengembalikan province Location.
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari province Location.
    */
    public String getProvince()
    {
        return province;
    }
    /**
    * Method ini digunakan untuk mengembalikan city Location.
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari city Location.
    */
    public String getCity()
    {
        return city;
    }
    /**
    * Method ini digunakan untuk mengembalikan description Location.
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai string dari description Location.
    */
    public String getDescription()
    {
        return description;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai province Location.
    * @param parameter province merupakan provinsi dari Location.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setProvince(String province)
    {
        this.province = province;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai city Location.
    * @param parameter city merupakan kota dari Location.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai description Location.
    * @param parameter description merupakan deskripsi dari Location.
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
    * Method ini digunakan untuk mencetak.
    */
    public String toString()
    {
        return "\nProvince: " + province +
        "\nCity: " + city +
        "\nDescription: " + description;     
    }
}
