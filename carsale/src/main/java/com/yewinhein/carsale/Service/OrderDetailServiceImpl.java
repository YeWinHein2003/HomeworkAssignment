package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.OrderDetail;
import com.yewinhein.carsale.Entity.OrderDetailId;
import com.yewinhein.carsale.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(OrderDetailId id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteById(OrderDetailId id) {
        orderDetailRepository.deleteById(id);

    }
}
