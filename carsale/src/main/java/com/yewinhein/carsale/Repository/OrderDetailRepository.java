package com.yewinhein.carsale.Repository;

import com.yewinhein.carsale.Entity.OrderDetail;
import com.yewinhein.carsale.Entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

}
