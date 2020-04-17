package haryridart.jfood.controller;
import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping
public class InvoiceController
{
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }
    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try
        {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getExMessage();
        }
        return invoice;
    }
    @RequestMapping(value = "/invoice/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) {
        Invoice temp;
        if (DatabaseInvoice.changeInvoiceStatus(id, status)){
            try {
                temp = DatabaseInvoice.getInvoiceById(id);
                return temp;
            } catch (InvoiceNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
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
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee") int deliveryFee) throws CustomerNotFoundException {

        ArrayList<Food> foodList = new ArrayList<>();
        Customer customer = null;
        for (Integer temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            customer = DatabaseCustomer.getCustomerById(customerId);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        Invoice input = new CashInvoice(DatabaseInvoice.getLastId() + 1, foodList,
                customer,
                deliveryFee);
        input.setTotalPrice();

        try {
            DatabaseInvoice.addInvoice(input);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }

        Invoice temp;
        try {
            temp = DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId());
            return temp;
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode") String promoCode){

        ArrayList<Food> foodList = new ArrayList<>();
        Customer customer = null;
        for (Integer temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            customer = DatabaseCustomer.getCustomerById(customerId);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        Invoice input = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foodList,
                customer,
                DatabasePromo.getPromoByCode(promoCode));
        input.setTotalPrice();

        try {
            DatabaseInvoice.addInvoice(input);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }

        Invoice temp;
        try {
            temp = DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId());
            return temp;
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
