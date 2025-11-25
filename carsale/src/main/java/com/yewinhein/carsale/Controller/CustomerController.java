package com.yewinhein.carsale.Controller;

import com.yewinhein.carsale.Entity.Customer;
import com.yewinhein.carsale.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }
    @GetMapping("/new")
    public String newCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }
    @PostMapping
    public String saveCustomer(@Valid @ModelAttribute Customer customer, @RequestParam(required = false) Long customerId) {

        // Explicitly set ID for updates to ensure save() updates instead of inserts
        if (customerId != null) {
            customer.setCustomerId(customerId);
        }

        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        customerService.findById(id).ifPresent(customer -> model.addAttribute("customer", customer));
        return "customer/form";
    }
    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}


