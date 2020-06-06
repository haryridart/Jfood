package haryridart.jfood.controller;
import haryridart.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This CostumerController Class is used to access JFood database at customer table
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomer() {
        return DatabaseCustomerPostgre.getCustomerDatabase();
    }
    /**
     * This is getCustomerById method, that is used to get data of customer in database
     * @params id, this parameter to select customer by id
     * @return customer, return costumer object that is selected
     */
    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = DatabaseCustomerPostgre.getCustomerById(id);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return customer;
    }
    /**
     * This is registerCustomer method
     * @params name, this is parameter name of customer
     * @params email, this is parameter email of customer
     * @params password, this is parameter password of customer
     * @return customer, return costumer object that is selected
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                     @RequestParam(value="email") String email,
                                     @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomerPostgre.getLastCustomerId()+1, name, email, password);
        try {
            DatabaseCustomerPostgre.insertCustomer(customer);
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
            //return null;
        }
        return customer;
    }
    /**
     * This is loginCustomer method
     * @params email, this is parameter email of customer
     * @params password, this is parameter password of customer
     * @return customer, return costumer object that is selected
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value = "password") String password)
    {
        return DatabaseCustomerPostgre.getCustomer(email,password);
    }

}
