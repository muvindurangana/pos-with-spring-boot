package com.springbootacadamy.POS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOderDetailsSave {

    private String itemName;
    private double quentity;
    private Double total;
    private int items;
}
