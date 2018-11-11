package com.cernelea.controller;

import com.cernelea.Service.CustomerService;
import com.cernelea.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")

    public String getCustomers(Model model) {
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customerList", customerList);

        return "customer-list";


    }

    @GetMapping("/addForm")
    public String showAddForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("newCustomer", customer);
        return "add-form";


    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer) {
        List<Customer> customers = customerService.getCustomerList();
        if (customers.contains(customer)) {

            customerService.updateCustomer(customer);
        } else {

            customerService.saveCustomer(customer);
        }
        return "redirect:/customer/list";


    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,
                                    Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("newCustomer", customer);


        return "add-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";


    }


}
