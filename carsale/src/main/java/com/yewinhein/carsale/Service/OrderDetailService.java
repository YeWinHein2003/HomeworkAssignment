package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.OrderDetail;
import com.yewinhein.carsale.Entity.OrderDetailId;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(OrderDetailId id);
    OrderDetail save(OrderDetail orderDetail);
    void deleteById(OrderDetailId id);
}
