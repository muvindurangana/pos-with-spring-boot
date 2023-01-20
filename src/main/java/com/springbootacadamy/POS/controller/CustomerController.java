package com.springbootacadamy.POS.controller;

import com.springbootacadamy.POS.dto.CustomerDTO;
import com.springbootacadamy.POS.dto.request.RequestUpdatedCustomerDTO;
import com.springbootacadamy.POS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/saveuser")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody RequestUpdatedCustomerDTO requestUpdatedCustomerDTO) {


        String updates = customerService.updateCustomer(requestUpdatedCustomerDTO);
        return updates;
    }

    @GetMapping(
            path = "/get-use-id/",
            params = "id"
    )
    //how to send a variable from front end
    //@Requsetparam or @Pathvariable
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        return customerService.getCustomerById(customerId);


    }

    @GetMapping("/getallcustomers")
    public List<CustomerDTO> getAllcutomers() {

        return customerService.getAllcustomers();
    }

    @DeleteMapping(value = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        customerService.deleteCustomerById(customerId);
        return "deleted";
    }

    @GetMapping(
            path = "/get-use-nic/",
            params = "nic"
    )
    //how to send a variable from front end
    //@Requsetparam or @Pathvariable
    public CustomerDTO getCustomerByNic(@RequestParam(value = "nic") String customerNic) {
        return customerService.getCustomerByNic(customerNic);


    }


    @GetMapping("/getallcustomers/{status}")
    public List<CustomerDTO> getAllcutomersByActiveStaus(@PathVariable(value = "status") boolean status) {

        return customerService.getAllcustomersByStatus(status);
    }

    @GetMapping("/getallcustomers-by-state-and-name/{status}/{name}")
    public List<CustomerDTO> getAllcutomersByActiveStausAndName(@PathVariable(value = "status") boolean status,@PathVariable(value = "name") String name) {

        return customerService.getAllcustomersByStatusAndName(status,name);
    }
}
