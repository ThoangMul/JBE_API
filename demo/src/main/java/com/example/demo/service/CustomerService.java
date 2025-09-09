package com.example.demo.service;

import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.entity.Customers;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Lấy toàn bộ customers (List)
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Lấy toàn bộ customers (Pageable)
    public Page<CustomerResponse> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(CustomerMapper::toDTO);
    }

    // Lấy 1 customer theo ID
    public CustomerResponse getCustomerById(int id) {
        Customers customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return CustomerMapper.toDTO(customer);
    }

    // Tạo mới customer
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customers customer = CustomerMapper.toEntity(customerRequest);
        Customers createdCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(createdCustomer);
    }

    // Cập nhật customer
    public CustomerResponse updateCustomer(int id, CustomerRequest customerRequest) {
        Customers customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));

        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setContactName(customerRequest.getContactName());
        customer.setAddress(customerRequest.getAddress());
        customer.setCity(customerRequest.getCity());
        customer.setPostalCode(customerRequest.getPostalCode());
        customer.setCountry(customerRequest.getCountry());

        Customers updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    // Xóa customer
    public void deleteCustomer(int id) {
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        customerRepository.deleteById(id);
    }
}
