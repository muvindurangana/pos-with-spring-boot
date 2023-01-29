package com.springbootacadamy.POS.service;

import com.springbootacadamy.POS.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
