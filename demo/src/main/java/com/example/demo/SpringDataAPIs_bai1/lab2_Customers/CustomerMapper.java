package com.example.demo.SpringDataAPIs_bai1.lab2_Customers;

public class CustomerMapper {

    // từ CustomerRequest (client gửi lên) sang Entity
    public static Customers toEntity(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        Customers customer = new Customers();

        customer.setCustomerName(request.getCustomerName());
        customer.setContactName(request.getContactName());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setPostalCode(request.getPostalCode());
        customer.setCountry(request.getCountry());

        return customer;
    }

    // từ Entity sang CustomerResponse (trả về cho client)
    public static CustomerResponse toDTO(Customers customer) {
        if (customer == null) {
            return null;
        }
        CustomerResponse dto = new CustomerResponse();

        dto.setCustomerId(customer.getCustomerId());
        dto.setCustomerName(customer.getCustomerName());
        dto.setContactName(customer.getContactName());
        dto.setAddress(customer.getAddress());
        dto.setCity(customer.getCity());
        dto.setPostalCode(customer.getPostalCode());
        dto.setCountry(customer.getCountry());

        return dto;
    }
}
