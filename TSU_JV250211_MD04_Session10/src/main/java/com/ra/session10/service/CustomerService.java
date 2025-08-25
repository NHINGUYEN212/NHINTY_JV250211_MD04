package com.ra.session10.service;

import com.ra.session10.model.dto.CustomerDTO;
import com.ra.session10.model.dto.CustomerUpdateDTO;
import com.ra.session10.model.entity.Customer;
import com.ra.session10.model.entity.Role;
import com.ra.session10.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public boolean save(CustomerDTO customerDTO) {
        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        return customerRepository.save(customer);
    }

    @Transactional
    public boolean update(long id ,CustomerUpdateDTO customerUpdateDTO) {
        Customer customer = convertUpdateCustomerDTOToCustomer(customerUpdateDTO);
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Transactional
    public String deleteById(long id) {
        Customer customer = findById(id);
        if(customer != null) {
            if(customer.getRole().toString().equals("ADMIN")){
                return "Không thể xóa admin !";
            }else {
                customerRepository.delete(customer);
                return "Xóa thành công khách hàng !" ;
            }
        }else {
            return "Khách hàng không tồn tại !" ;
        }
    }

    @Transactional
    public boolean checkEmailExist(String email) {
        return customerRepository.checkEmailExisted(email);
    }

    @Transactional
    public boolean checkUsernameExist(String username) {
        return customerRepository.checkUsernameExisted(username);
    }

    @Transactional
    public boolean checkPhoneExist(String phone) {
        return customerRepository.checkPhoneExisted(phone);
    }

    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        return Customer
                .builder()
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .password(customerDTO.getPassword())
                .username(customerDTO.getUsername())
                .status(customerDTO.getStatus())
                .role(Role.valueOf(customerDTO.getRole()))
                .build();
    }

    public CustomerDTO convertCustomerToCustomerDTO(Customer customer) {
        return CustomerDTO
                .builder()
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .password(customer.getPassword())
                .username(customer.getUsername())
                .status(customer.getStatus())
                .role(customer.getRole().toString())
                .build();
    }

    public Customer convertUpdateCustomerDTOToCustomer(CustomerUpdateDTO customerUpdateDTODTO) {
        return Customer
                .builder()
                .email(customerUpdateDTODTO.getEmail())
                .phone(customerUpdateDTODTO.getPhone())
                .password(customerUpdateDTODTO.getPassword())
                .username(customerUpdateDTODTO.getUsername())
                .status(customerUpdateDTODTO.getStatus())
                .role(Role.valueOf(customerUpdateDTODTO.getRole()))
                .build();
    }

    public CustomerUpdateDTO convertCustomerToCustomerUpdateDTO(Customer customer) {
        return CustomerUpdateDTO
                .builder()
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .password(customer.getPassword())
                .username(customer.getUsername())
                .status(customer.getStatus())
                .role(customer.getRole().toString())
                .build();
    }

}
