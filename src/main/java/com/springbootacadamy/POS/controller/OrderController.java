package com.springbootacadamy.POS.controller;

import com.springbootacadamy.POS.dto.request.RequestOrderSaveDTO;
import com.springbootacadamy.POS.service.OrderService;
import com.springbootacadamy.POS.util.StandaredResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandaredResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
           String id=orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandaredResponse>(new StandaredResponse(201,
                "success", id), HttpStatus.OK);
    }

}
