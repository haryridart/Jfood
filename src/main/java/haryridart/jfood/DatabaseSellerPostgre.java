package haryridart.jfood;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DatabaseSellerPostgre extends DatabaseConnectionPostgre{
    public static boolean insertSeller(Seller seller)
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        //inserting value
        try {
            statement = c.prepareStatement("INSERT INTO seller (seller_name, seller_email, seller_phonenumber, seller_location) values (?,?,?,?) RETURNING id;");
            statement.setString(1,seller.getName());
            statement.setString(2,seller.getEmail());
            statement.setString(3,seller.getPhoneNumber());
            statement.setString(4,seller.getLocation().getCity());
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

    public static int getLastSellerId()
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        try {
            statement = c.prepareStatement("SELECT id FROM seller;");
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

    public static Seller getSellerById(int sellerId) throws SellerNotFoundException
    {
        Connection c = connection();
        PreparedStatement statement = null;
        Seller seller = null;
        int id = 0;
        String sellerName = null;
        String sellerEmail = null;
        String phoneNumber = null;
        Location location = null;
        try {
            statement = c.prepareStatement("SELECT * FROM seller WHERE id=?;");
            statement.setInt(1,sellerId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                sellerName = rs.getString("seller_name");
                sellerEmail = rs.getString("seller_email");
                phoneNumber = rs.getString("seller_phonenumber");
                location = DatabaseLocationPostgre.getLocationByCity(rs.getString("seller_location"));
                seller = new Seller (id, sellerName, sellerEmail, phoneNumber, location);
            }
            statement.close();
            c.close();
            //throw new SellerNotFoundException(id)
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        if(seller == null){
            throw new SellerNotFoundException(sellerId);
        }
        return seller;
    }

    public static ArrayList<Seller> getSellerDatabase()
    {
        Connection c = connection();
        PreparedStatement statement = null;
        Seller seller = null;
        ArrayList<Seller> sellers = new ArrayList<>();
        int id = 0;
        String sellerName = null;
        String sellerEmail = null;
        String phoneNumber = null;
        Location location = null;
        try {
            statement = c.prepareStatement("SELECT * FROM seller;");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                sellerName = rs.getString("seller_name");
                sellerEmail = rs.getString("seller_email");
                phoneNumber = rs.getString("seller_phonenumber");
                location = DatabaseLocationPostgre.getLocationByCity(rs.getString("seller_location"));
                seller = new Seller (id, sellerName, sellerEmail, phoneNumber, location);
                sellers.add(seller);
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return sellers;
    }
}
