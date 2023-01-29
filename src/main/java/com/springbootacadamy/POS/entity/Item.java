package com.springbootacadamy.POS.entity;

import com.springbootacadamy.POS.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {

    @Id
    @Column(name = "item_id", length = 45)
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @SequenceGenerator(name = "item_generator", sequenceName = "item_sequence", allocationSize = 1)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 100, nullable = false)
    private MeasuringUnitType measureType;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private Double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    private Double supplierPrice;

    @Column(name = "selling_price", length = 100, nullable = false)
    private Double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;
}
