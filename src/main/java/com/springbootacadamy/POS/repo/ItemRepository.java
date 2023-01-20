package com.springbootacadamy.POS.repo;

import com.springbootacadamy.POS.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    Page<Item> findAllByActiveStateEquals(boolean activeStatus, Pageable pageable);

    long countAllByActiveStateEquals(boolean activeStatus);
}
