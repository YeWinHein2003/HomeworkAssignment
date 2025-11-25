package com.yewinhein.carsale.Service;


import com.yewinhein.carsale.Entity.OrderDetail;
import com.yewinhein.carsale.Entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    void deleteById(Long id);
    List<Order> findAllWithDetails();
}
