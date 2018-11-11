package com.cernelea.rest;


import com.cernelea.Service.CustomerService;
import com.cernelea.entity.Customer;
import com.cernelea.rest.exceptionHandling.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> customerList() {
        List<Customer> customerList = customerService.getCustomerList();
        return customerList;


    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {

            throw new CustomerNotFoundException("can not find customer with specified id :" + customerId);

        }

        return customer;


    }

    @PostMapping("/customers")

    public Customer addNewCustomer(@RequestBody Customer customer) {

        if (customer == null) {
            try {
                throw new Exception("can not add the specified customer please try again");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        customerService.saveCustomer(customer);

        return customer;
    }


    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.updateCustomer(customer);
        return customer;


    }

    @DeleteMapping("customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {

            throw new CustomerNotFoundException("Can not find and delete customer with Id: " + customerId);

        }

        customerService.deleteCustomer(customerId);

        return "successfully deleted customer :" + customer;


    }


}
