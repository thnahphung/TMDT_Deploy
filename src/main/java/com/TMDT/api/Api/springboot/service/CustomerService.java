package com.TMDT.api.Api.springboot.service;

import com.TMDT.api.Api.springboot.dto.UpdateCustomerDTO;
import com.TMDT.api.Api.springboot.dto.UpdateCustomerPasswordDTO;
import com.TMDT.api.Api.springboot.models.Customer;
import com.TMDT.api.Api.springboot.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

    public List<Customer> getAllCustomer() {
        return clearProperties(customerRepository.findAll());
    }

    public Customer get(int id) {
        return clearProperty(customerRepository.findById(id).orElse(null));
    }

    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer login(String email, String password) {
        Customer foundUser = customerRepository.findByEmail(email);
        return foundUser != null && foundUser.getPassword().equals(password) ? foundUser : null;
    }

    public Customer register(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean isExistEmail(String email) {
        return customerRepository.findByEmail(email) != null;
    }

    public String generateVerificationCode() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateInfo(UpdateCustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getId()).orElse(null);
        if (customer == null) {
            return null;
        }
        customer.setUsername(customerDTO.getUserName());
        customer.setPhone(customerDTO.getPhone());
        return clearProperty(customerRepository.save(customer));
    }

    public Customer updatePassword(UpdateCustomerPasswordDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getId()).orElse(null);
        if (customer == null) {
            return null;
        }
        if (!customer.getPassword().equals(customerDTO.getPassword())) {
            return null;
        }
        customer.setPassword(customerDTO.getNewPassword());
        return clearProperty(customerRepository.save(customer));
    }

    public Customer clearProperty(Customer customer) {
        customer.setOrders(null);
        if (customer.getOrders() != null) {
            customer.getCartDetails().forEach(cartDetail -> {
                cartDetail.setCustomer(null);
                cartDetail.setPhoneCategory(null);
                cartDetail.getProduct().setCategory(null);
                if (cartDetail.getProduct().getProductPhoneCategories() != null) {
                    cartDetail.getProduct().getProductPhoneCategories().clear();
                }
            });
        }
        return customer;
    }

    public List<Customer> clearProperties(List<Customer> customers) {
        for (Customer customer : customers) {
            clearProperty(customer);
        }
        return customers;
    }
}
