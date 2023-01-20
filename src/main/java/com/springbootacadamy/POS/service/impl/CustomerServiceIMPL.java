package com.springbootacadamy.POS.service.impl;

import com.springbootacadamy.POS.dto.CustomerDTO;
import com.springbootacadamy.POS.dto.request.RequestUpdatedCustomerDTO;
import com.springbootacadamy.POS.entity.Customer;
import com.springbootacadamy.POS.repo.CustomerRepositoty;
import com.springbootacadamy.POS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    CustomerRepositoty customerRepositoty;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.isActiveState()
        );

        if (!customerRepositoty.existsById(customer.getCustomerId())) {
            customerRepositoty.save(customer);
        } else {
            throw new DuplicateKeyException("Customer Alreday Exists");
        }
        return customer.getCustomerName() + "saved";
    }

    @Override
    public List<CustomerDTO> getAllcustomers() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> getcustomer = customerRepositoty.findAll();

        for (Customer customer : getcustomer) {

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()

            );
            customerDTOList.add(customerDTO);

        }
        return customerDTOList;
    }

    @Override
    public String updateCustomer(RequestUpdatedCustomerDTO requestUpdatedCustomerDTO) {

        if (customerRepositoty.existsById(requestUpdatedCustomerDTO.getCustomerId())) {

            Customer customer = customerRepositoty.getById(requestUpdatedCustomerDTO.getCustomerId());
            customer.setCustomerName(requestUpdatedCustomerDTO.getCustomerName());
            customer.setCustomerAddress(requestUpdatedCustomerDTO.getCustomerAddress());
            customer.setCustomerSalary(requestUpdatedCustomerDTO.getCustomerSalary());
            customerRepositoty.save(customer);

            return "Saved " + customer.getCustomerName() + " " + customer.getCustomerId();
        } else {
            throw new RuntimeException("customer not in database");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Optional<Customer> customer = customerRepositoty.findById(customerId);

        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveState()
            );
            return customerDTO;


        } else {
            throw new RuntimeException("customer is not here");
        }

    }

    @Override
    public void deleteCustomerById(int customerId) {
        if(customerRepositoty.existsById(customerId)) {
            customerRepositoty.deleteById(customerId);
        }
        else throw new RuntimeException("Customer Not Found");
    }

    @Override
    public CustomerDTO getCustomerByNic(String customerNic) {
        Optional<Customer> customer = customerRepositoty.findByNicEquals(customerNic);
              if(customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveState()
            );
            return customerDTO;


        } else {
            throw new RuntimeException("customer id not here");
        }
    }

    @Override
    public List<CustomerDTO> getAllcustomersByStatus(boolean status) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> getcustomer = customerRepositoty.findAllByActiveState(status);

        for (Customer customer : getcustomer) {

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()

            );
            customerDTOList.add(customerDTO);

        }
        return customerDTOList;
    }

    @Override
    public List<CustomerDTO> getAllcustomersByStatusAndName(boolean status,String name) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> getcustomer = customerRepositoty.findAllByActiveStateAndCustomerName(status,name);

        for (Customer customer : getcustomer) {

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()

            );
            customerDTOList.add(customerDTO);

        }
        return customerDTOList;
    }


}
