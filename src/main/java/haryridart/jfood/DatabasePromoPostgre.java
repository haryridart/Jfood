package haryridart.jfood;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DatabasePromoPostgre extends DatabaseConnectionPostgre {
    public static boolean insertPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        for (Promo i : getPromoDatabase())
        {
            if(i.getCode().equals(promo.getCode()))
            {
                throw new PromoCodeAlreadyExistsException(promo);
                //return false;
            }
        }
        //inserting value
        try {
            statement = c.prepareStatement("INSERT INTO promo (promo_code, promo_discount, promo_minPrice, promo_active) values (?,?,?,?) RETURNING id;");
            statement.setString(1,promo.getCode());
            statement.setInt(2,promo.getDiscount());
            statement.setInt(3,promo.getMinPrice());
            statement.setString(4, (Boolean.toString(promo.getActive())));
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

    public static Promo getPromoByCode(String code) throws PromoNotFoundException
    {
        Connection c = connection();
        PreparedStatement statement = null;
        Promo promo = null;
        int id = 0;
        String promoCode = null;
        int promoDiscount = 0;
        int promoMinPrice = 0;
        Boolean promoActive = null;
        try {
            statement = c.prepareStatement("SELECT * FROM promo WHERE promo_code=?;");
            statement.setString(1,code);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                promoCode = rs.getString("promo_code");
                promoDiscount = rs.getInt("promo_discount");
                promoMinPrice = rs.getInt("promo_minprice");
                promoActive = Boolean.parseBoolean(rs.getString("promo_active"));
                promo = new Promo (id, promoCode, promoDiscount, promoMinPrice, promoActive);
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return promo;
    }

    public static Promo getPromoById(int codeId) throws PromoNotFoundException
    {
        Connection c = connection();
        PreparedStatement statement = null;
        Promo promo = null;
        int id = 0;
        String promoCode = null;
        int promoDiscount = 0;
        int promoMinPrice = 0;
        Boolean promoActive = null;
        try {
            statement = c.prepareStatement("SELECT * FROM promo WHERE id=?;");
            statement.setInt(1,codeId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                promoCode = rs.getString("promo_code");
                promoDiscount = rs.getInt("promo_discount");
                promoMinPrice = rs.getInt("promo_minprice");
                promoActive = Boolean.parseBoolean(rs.getString("promo_active"));
                promo = new Promo (id, promoCode, promoDiscount, promoMinPrice, promoActive);
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return promo;
    }

    public static ArrayList<Promo> getPromoDatabase()
    {
        Connection c = connection();
        PreparedStatement statement = null;
        Promo promo = null;
        ArrayList<Promo> promos = new ArrayList<>();
        int id = 0;
        String promoCode = null;
        int promoDiscount = 0;
        int promoMinPrice = 0;
        Boolean promoActive = null;
        try {
            statement = c.prepareStatement("SELECT * FROM promo;");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                promoCode = rs.getString("promo_code");
                promoDiscount = rs.getInt("promo_discount");
                promoMinPrice = rs.getInt("promo_minprice");
                promoActive = Boolean.parseBoolean(rs.getString("promo_active"));
                promo = new Promo (id, promoCode, promoDiscount, promoMinPrice, promoActive);
                promos.add(promo);
            }
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return promos;
    }

    public static int getLastPromoId()
    {
        Connection c = connection();
        PreparedStatement statement = null;
        int id = 0;
        try {
            statement = c.prepareStatement("SELECT id FROM promo;");
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
}
