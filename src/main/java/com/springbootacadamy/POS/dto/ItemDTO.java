package com.springbootacadamy.POS.dto;

import com.springbootacadamy.POS.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measureType;
    private Double balanceQty;
    private Double supplierPrice;
    private Double sellingPrice;
    private boolean activeState;
}
