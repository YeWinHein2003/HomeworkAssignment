package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.Car;
import com.yewinhein.carsale.Entity.CarId;



import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(CarId id);
    Car save(Car car);
    void deleteById(CarId id);



}
