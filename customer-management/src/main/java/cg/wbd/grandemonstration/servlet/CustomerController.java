package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
//    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @Autowired
    private CustomerService customerService;
    @GetMapping()
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
//        req.setAttribute("customers",customers);
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @PostMapping()
    public String update(  Long id,
                                 String name,
                                 String email,
                                 String address
    )
    {
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        return "redirect:/customers";}
//        ModelAndView modelAndView = new ModelAndView("list");
//        List<Customer> customers = customerService.findAll();
//        Customer customer = new Customer();
//        customer.setName(req.getParameter("name"));
//        customer.setEmail(req.getParameter("email"));
//        customer.setAddress(req.getParameter("address"));
//
//        Long id = Long.valueOf(req.getParameter("id"));
//        customer.setId(id);
//        customerService.save(customer);
//        modelAndView.addObject("customers",customers);
//        return modelAndView;


    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
