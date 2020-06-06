package haryridart.jfood.controller;
import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This PromoController Class is used to access JFood database at seller table
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
@RequestMapping("/seller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SellerController
{
    /**
     * This is getAllSeller method, that is used to access and get data of all seller in database
     * @return sellerList, return seller object in array list
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSellerPostgre.getSellerDatabase();
    }
    /**
     * This is getSellerByCode method, that is used to get data of seller in database
     * @params id, this is parameter to select seller by id
     * @return sellerId, return seller object that is selected
     */
    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) {
        Seller seller = null;
        try
        {
            seller = DatabaseSellerPostgre.getSellerById(id);
        }
        catch (SellerNotFoundException e)
        {
            e.getExMessage();
        }
        return seller;
    }
    /**
     * This is addSeller method, that is used to access and add seller in database
     * @params name, this is parameter of seller name
     * @params email, this is parameter of seller email
     * @params phoneNumber, this is parameter of seller phone number
     * @params province, this is parameter of seller province
     * @params description, this is parameter of seller description
     * @params city, this is parameter of seller city
     * @return seller, return seller in array list that is selected
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value="name") String name,
                              @RequestParam(value="email") String email,
                              @RequestParam(value="phoneNumber") String phoneNumber,
                              @RequestParam(value="province") String province,
                              @RequestParam(value="description") String description,
                              @RequestParam(value="city") String city)
    {
        Seller seller = new Seller(DatabaseSellerPostgre.getLastSellerId()+1,name,email,phoneNumber,DatabaseLocationPostgre.getLocationByCity(city));
        DatabaseSellerPostgre.insertSeller(seller);
        return seller;
    }
}
