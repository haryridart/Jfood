package haryridart.jfood.controller;
import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InvoiceController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id){
        Invoice invoice = null;
        try{
            invoice = DatabaseInvoice.getInvoiceById(id);
            return invoice;
        }catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }
    @RequestMapping(value = "invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) throws InvoiceNotFoundException
    {
        Invoice invoice = null;
        DatabaseInvoice.changeInvoiceStatus(id,status);
        try{
            invoice = DatabaseInvoice.getInvoiceById(id);
            return invoice;
        }catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        try
        {
            if(DatabaseInvoice.removeInvoice(id))
            {
                return true;
            }
        }
        catch (InvoiceNotFoundException e)
        {
            System.out.println(e.getExMessage());
        }
        return false;
    }
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodListId") ArrayList<Integer> foodListId,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee", required = false) Integer deliveryFee)
    {
        Invoice cashInvoice = null;
        ArrayList<Food> foodList = new ArrayList<>();

        for (Integer foodId : foodListId){
            try{
                foodList.add(DatabaseFood.getFoodById(foodId));
            }catch (FoodNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

        if (deliveryFee != null){
            try{
                cashInvoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, foodList, DatabaseCustomer.getCustomerById(customerId), deliveryFee);
                cashInvoice.setTotalPrice();
            }catch (CustomerNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            try {
                cashInvoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, foodList, DatabaseCustomer.getCustomerById(customerId));
                cashInvoice.setTotalPrice();
            }catch (CustomerNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

        try{
            DatabaseInvoice.addInvoice(cashInvoice);
        }catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        Invoice temp;
        try{
            temp = DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId());
            return temp;
        }catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodListId") ArrayList<Integer> foodListId,
                                      @RequestParam(value="customerId") int customerId,
                                      @RequestParam(value="promoCode") String promoCode)
    {
        Invoice cashlessinvoice = null;
        ArrayList<Food> foodList = new ArrayList<>();

        for (Integer foodId : foodListId){
            try{
                foodList.add(DatabaseFood.getFoodById(foodId));
            }catch (FoodNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

        if (promoCode == null){
            try{
                cashlessinvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foodList, DatabaseCustomer.getCustomerById(customerId));
                cashlessinvoice.setTotalPrice();
            }catch (CustomerNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            try {
                cashlessinvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foodList, DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode)) ;
                cashlessinvoice.setTotalPrice();
            }catch (CustomerNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

        try{
            DatabaseInvoice.addInvoice(cashlessinvoice);
        }catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        Invoice temp;
        try{
            temp = DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId());
            return temp;
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
