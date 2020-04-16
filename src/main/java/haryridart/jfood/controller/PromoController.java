package haryridart.jfood.controller;
import haryridart.jfood.*;
import haryridart.jfood.DatabaseSeller;
import haryridart.jfood.Seller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
@RestController
public class PromoController
{
    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        Promo promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "/promo", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                          @RequestParam(value="discount") int discount,
                          @RequestParam(value="minPrice") int minPrice,
                          @RequestParam(value="active") boolean active)
    {
        Promo promo = new Promo(DatabasePromo.getLastId()+1,code,discount,minPrice,active);
        try
        {
            DatabasePromo.addPromo(promo);
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
            return null;
        }
        return promo;

    }
}
