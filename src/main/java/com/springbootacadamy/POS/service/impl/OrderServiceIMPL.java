package com.springbootacadamy.POS.service.impl;

import com.springbootacadamy.POS.dto.request.RequestOrderSaveDTO;
import com.springbootacadamy.POS.entity.OrderDetails;
import com.springbootacadamy.POS.entity.Orders;
import com.springbootacadamy.POS.repo.CustomerRepositoty;
import com.springbootacadamy.POS.repo.ItemRepository;
import com.springbootacadamy.POS.repo.OrderDetailsRepo;
import com.springbootacadamy.POS.repo.OrderRepo;
import com.springbootacadamy.POS.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepositoty customerRepositoty;
    @Autowired
    private OrderRepo orderRepo;
   @Autowired
   private ItemRepository itemRepository;
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders orders = new Orders(customerRepositoty.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(), requestOrderSaveDTO.getTotal());
        orderRepo.save(orders);
        if (orderRepo.existsById(orders.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>() {
                    }.getType()
            );
            for(int i = 0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrders(orders);
                orderDetails.get(i).setItems(itemRepository.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if (orderDetails.size() > 0) {
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "order saved";
        }
        return null;
    }
}