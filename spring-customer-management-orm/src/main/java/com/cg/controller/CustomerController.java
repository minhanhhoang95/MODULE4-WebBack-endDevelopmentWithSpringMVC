package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.HibernateCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private HibernateCustomerServiceImpl hibernateCustomerService;

    @GetMapping
    public ModelAndView showCustomerListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customers/list");

        List<Customer> customerList = hibernateCustomerService.findAll();

        modelAndView.addObject("customers", customerList);

        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView showCustomerByIdPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customers/info");

        Customer customer = hibernateCustomerService.findOne(id);
        modelAndView.addObject("customer",customer);

        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customers/create");

        Customer customer = new Customer();
        modelAndView.addObject("customer",customer);

        return modelAndView;
    }
    @PostMapping("/update")
    public String doCreate( @ModelAttribute Customer customer){

        hibernateCustomerService.save(customer);

       return "redirect:/customers";
    }

    @PostMapping("/create")
    public String doUpdate(@ModelAttribute Customer customer){

        hibernateCustomerService.save(customer);

        return "redirect:/customers";
    }

}
