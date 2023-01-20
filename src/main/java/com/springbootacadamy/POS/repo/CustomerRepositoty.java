package com.springbootacadamy.POS.repo;

import com.springbootacadamy.POS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepositoty extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByNicEquals(String customerNic);
    List<Customer> findAllByActiveState(boolean status);
    List<Customer> findAllByActiveStateAndCustomerName(boolean status,String name);
}
