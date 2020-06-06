package haryridart.jfood.controller;
import haryridart.jfood.*;
import haryridart.jfood.DatabaseSeller;
import haryridart.jfood.Seller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This PromoController Class is used to access JFood database at promo table
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
@RequestMapping("/promo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PromoController
{
    /**
     * This is getAllPromo method, that is used to access and get data of all promo in database
     * @return return promo object in array list
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromoPostgre.getPromoDatabase();
    }
    /**
     * This is getPromoByCode method, that is used to get data of promo in database
     * @params code, this is parameter to select promo by code
     * @return promoCode, return promo object that is selected
     */
    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        Promo promoCode = null;
        try{
            promoCode = DatabasePromoPostgre.getPromoByCode(code);
        } catch (PromoNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
        return promoCode;
    }

    /**
     * This is addPromo method, that is used to access and add promo in database
     * @params code, this is parameter of promo code
     * @params discount, this is parameter of promo discount
     * @params minPrice, this is parameter of minimal price
     * @params active, this is parameter of promo active or inactive
     * @return food, return food in array list that is selected
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                          @RequestParam(value="discount") int discount,
                          @RequestParam(value="minPrice") int minPrice,
                          @RequestParam(value="active") boolean active)
    {
        Promo promo = new Promo(DatabasePromoPostgre.getLastPromoId()+1,code,discount,minPrice,active);
        try
        {
            DatabasePromoPostgre.insertPromo(promo);
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
            return null;
        }
        return promo;

    }
}
