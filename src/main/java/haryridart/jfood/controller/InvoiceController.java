package haryridart.jfood.controller;
import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * InvoiceController Class is used to access JFood database at invoice table
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InvoiceController
{
    /**
     * This is getAllInvoice method, that is used to access and get data of all invoice in database
     * @return invoice, return invoice object in array list
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoicePostgre.getInvoiceDatabase();
    }
    /**
     * This is getInvoiceById method, that is used to access and get data of food in database
     * @params id, this is parameter to select invoice by id
     * @return invoice, return invoice object that is selected
     */
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id){
        Invoice invoice = null;
        try{
            invoice = DatabaseInvoicePostgre.getInvoiceById(id);
            return invoice;
        }catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * This is getInvoiceByCustomer method, that is used to access and get data of invoice in database
     * @params customerId, this is parameter to select invoice by customer id
     * @return invoice, return invoice object that is selected
     */
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        return DatabaseInvoicePostgre.getInvoiceByCustomer(customerId);
    }
    /**
     * This is changeInvoiceStatus method, that is used to change invoice status in database
     * @params id, this is parameter to select invoice by invoice id
     * @params status, this is parameter to update value of status (new value)
     * @return invoice, return invoice object that is selected
     */
    @RequestMapping(value = "invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) throws InvoiceNotFoundException
    {
        Invoice invoice = null;
        DatabaseInvoicePostgre.changeInvoiceStatus(id,status);
        try{
            invoice = DatabaseInvoicePostgre.getInvoiceById(id);
            return invoice;
        }catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    /**
     * This is removeInvoice method, that is used to access and remove data of invoice in table invoice
     * @params id, this parameter to select food invoice by invoice id
     * @return true, if remove is succeeded
     * @return false, if remove is not succeeded
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        try{
            if(DatabaseInvoicePostgre.removeInvoice(id))
            {
                return true;
            }
        } catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
            //return null;
        }
        return false;
    }
    /**
     * This is addCashInvoice method, that is used to add cash invoice in database
     * @params foodListId, this is parameter of food id in list
     * @params customerId, this is parameter of customer id
     * @params deliveryFee, this is parameter of deliveryFee
     * @return invoice, return invoice object that is selected
     */
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodListId") ArrayList<Integer> foodListId,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee", defaultValue = "0") int deliveryFee)
    {
        ArrayList<Food> foodList = new ArrayList<>();
        for (int food : foodListId) {
            try {
                foodList.add(DatabaseFoodPostgre.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {

            CashInvoice invoice = new CashInvoice(DatabaseInvoicePostgre.getLastInvoiceId()+1, foodList, DatabaseCustomerPostgre.getCustomerById(customerId), deliveryFee);
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertCashInvoice(invoice);
            return invoice;
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

        catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    /**
     * This is addCashlessInvoice method, that is used to add cash invoice in database
     * @params foodListId, this is parameter of food id in list
     * @params customerId, this is parameter of customer id
     * @params promoCode, this is parameter of promo code
     * @return invoice, return invoice object that is selected
     */
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodListId") ArrayList<Integer> foodListId,
                                      @RequestParam(value="customerId") int customerId,
                                      @RequestParam(value="promoCode") String promoCode)
    {
        ArrayList<Food> foodList = new ArrayList<>();
        for (int food : foodListId) {
            try {
                foodList.add(DatabaseFoodPostgre.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {

            CashlessInvoice invoice = new CashlessInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, foodList, DatabaseCustomerPostgre.getCustomerById(customerId),  DatabasePromoPostgre.getPromoByCode(promoCode));
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertCashlessInvoice(invoice);
            return invoice;
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

        catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
            return null;
        }
        catch (PromoNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
