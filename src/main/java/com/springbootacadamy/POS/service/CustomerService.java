package com.springbootacadamy.POS.service;

import com.springbootacadamy.POS.dto.CustomerDTO;
import com.springbootacadamy.POS.dto.request.RequestUpdatedCustomerDTO;

import java.util.List;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    public  List<CustomerDTO> getAllcustomers();

    String updateCustomer(RequestUpdatedCustomerDTO requestUpdatedCustomerDTO);

    CustomerDTO getCustomerById(int customerId);

    void deleteCustomerById(int customerId);

    CustomerDTO getCustomerByNic(String customerNic);

    List<CustomerDTO> getAllcustomersByStatus(boolean status);

    List<CustomerDTO> getAllcustomersByStatusAndName(boolean status,String name);
}
