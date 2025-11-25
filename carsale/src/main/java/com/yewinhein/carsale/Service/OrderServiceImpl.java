package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.Order;
import com.yewinhein.carsale.Entity.OrderDetail;
import com.yewinhein.carsale.Entity.OrderDetailId;
import com.yewinhein.carsale.Repository.OrderDetailRepository;
import com.yewinhein.carsale.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAllWithDetails() {
        return orderRepository.findAllWithDetails();
    }
}