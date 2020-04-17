package haryridart.jfood.controller;
import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SellerController
{
    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSeller.getSellerDatabase();
    }

    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) {
        Seller seller = null;
        try
        {
            seller = DatabaseSeller.getSellerById(id);
        }
        catch (SellerNotFoundException e)
        {
            e.getExMessage();
        }
        return seller;
    }

    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value="name") String name,
                              @RequestParam(value="email") String email,
                              @RequestParam(value="phoneNumber") String phoneNumber,
                              @RequestParam(value="province") String province,
                              @RequestParam(value="description") String description,
                              @RequestParam(value="city") String city)
    {
        Seller seller = new Seller(DatabaseSeller.getLastId()+1,name,email,phoneNumber,new Location(city,province,description));
        DatabaseSeller.addSeller(seller);
        return seller;
    }
}