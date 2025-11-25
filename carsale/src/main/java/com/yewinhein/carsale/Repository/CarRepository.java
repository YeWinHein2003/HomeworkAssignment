package com.yewinhein.carsale.Repository;

import com.yewinhein.carsale.Entity.Car;
import com.yewinhein.carsale.Entity.CarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, CarId> {
    @Query("SELECT c FROM Car c LEFT JOIN FETCH c.carGroup LEFT JOIN FETCH c.variant LEFT JOIN FETCH c.variant.variantSpec")
    List<Car> findAllWithDetails();
}
