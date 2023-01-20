package com.springbootacadamy.POS.repo;

import com.springbootacadamy.POS.entity.Customer;
import lombok.Builder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.*;
import java.util.ArrayList;

import java.util.Optional;

@DataJpaTest
@Builder
class CustomerRepositotyTest {

    @Autowired
    private CustomerRepositoty customerRepositoty;
    Customer customer;

    @BeforeEach
    void setUp() {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("31313");
        phoneNumbers.add("4234324");
        customer = new Customer(1, "Muvindu", "Galle", 120000, "234260217V", phoneNumbers, true);
        customerRepositoty.save(customer);
    }
    // methodOne(input){
    //    stat1;
    //   stat2;
    //  output
    //}
    @AfterEach
    void tearDown() {
     customer =null;
     customerRepositoty.deleteAll();
    }

    @Test
    void findByNicEquals() {
        Optional<Customer> customers = customerRepositoty.findByNicEquals("23234242V");

//  provided / given - when there is exp- then ans/out

    }

}