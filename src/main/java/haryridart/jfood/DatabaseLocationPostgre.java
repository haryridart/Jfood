package haryridart.jfood;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This DatabaseLocationPostgre Class is used to precessing database of location
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class DatabaseLocationPostgre extends DatabaseConnectionPostgre{
    public static boolean insertLocation(Location location)
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        //inserting value
        try {
            statement = c.prepareStatement("INSERT INTO location (location_city, location_province, location_description) values (?,?,?) RETURNING id;");
            statement.setString(1,location.getCity());
            statement.setString(2,location.getProvince());
            statement.setString(3,location.getDescription());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return true;
    }

    public static int getLastLocationId()
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        try {
            statement = c.prepareStatement("SELECT id FROM location;");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return id;
    }

    public static Location getLocationByCity(String searchCity)
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        Location location = null;
        String city = null;
        String province = null;
        String description = null;
        try {
            statement = c.prepareStatement("SELECT * FROM location WHERE location_city = ?");
            statement.setString(1, searchCity);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id"); //location_city, location_province, location_description
                city = rs.getString("location_city");
                province = rs.getString("location_province");
                description = rs.getString("location_description");
                location = new Location (city, province, description);
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return location;
    }

    public static ArrayList<Location> getLocationDatabase()
    {
        Connection c = connection();
        PreparedStatement statement = null;
        Location location = null;
        ArrayList<Location> locations = new ArrayList<>();
        int id = 0;
        String city = null;
        String province = null;
        String description = null;
        try {
            statement = c.prepareStatement("SELECT * FROM location;");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                city = rs.getString("location_city");
                province = rs.getString("location_province");
                description = rs.getString("location_description");
                location = new Location(city, province, description);
                locations.add(location);
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return locations;
    }
}
