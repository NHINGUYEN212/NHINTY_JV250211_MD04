package com.ra.session10.controller;

import com.ra.session10.model.dto.CustomerDTO;
import com.ra.session10.model.dto.CustomerUpdateDTO;
import com.ra.session10.model.entity.Customer;
import com.ra.session10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String customers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/listCustomer";
    }

    @GetMapping("/add")
    public String formAdd(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "customer/addCustomer";
    }

    @PostMapping("/add")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO,
                               BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customerDTO);
            return "customer/addCustomer";
        }

        boolean rs = customerService.save(customerDTO);
        if (rs) {
            redirectAttributes.addFlashAttribute("Thêm mới khách hàng thành công !");
        }else {
            redirectAttributes.addFlashAttribute("Thêm mơi khách hành thất bại");
        }
        return "redirect:/customers/";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        if(customer != null){
            model.addAttribute("customer", customerService.convertCustomerToCustomerUpdateDTO(customer));
            model.addAttribute("customerId", customer.getId());
            return "customer/editCustomer";
        }
        return "redirect:/customers/";
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@Valid @ModelAttribute("customer") CustomerUpdateDTO customerUpdateDTO, BindingResult bindingResult
            , RedirectAttributes redirectAttributes, @PathVariable long id, Model model) {
        Customer customer = customerService.findById(id);


        if(customer != null){
            if (customerService.checkUsernameExist(customerUpdateDTO.getUsername()) && !customerUpdateDTO.getUsername().equals(customer.getUsername())) {
                bindingResult.rejectValue("username", "error.username","username đã tồn tại");
            }
            if (customerService.checkEmailExist(customerUpdateDTO.getEmail()) && !customerUpdateDTO.getEmail().equals(customer.getEmail())) {
                bindingResult.rejectValue("email","error.email", "email đã tồn tại");
            }
            if (customerService.checkPhoneExist(customerUpdateDTO.getPhone()) && !customerUpdateDTO.getPhone().equals(customer.getPhone())) {
                bindingResult.rejectValue("phone", "error.phone","phone đã tồn tại");
            }

            if (bindingResult.hasErrors()) {
                model.addAttribute("customer", customerUpdateDTO);
                return "customer/editCustomer";
            }
            boolean rs = customerService.update(id, customerUpdateDTO);
            if (rs) {
                redirectAttributes.addFlashAttribute("message", "Cập nhật thành công !");
            }else {
                redirectAttributes.addFlashAttribute("message","Cập nhật thất bại !");
            }
        }else {
            redirectAttributes.addFlashAttribute("message", "Khách hàng không tồn tại !");
        }
        return "redirect:/customers/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        String rs = customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message" , rs) ;
        return "redirect:/customers/";
    }

}
