package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.Car;
import com.yewinhein.carsale.Entity.CarId;
import com.yewinhein.carsale.Entity.Order;
import com.yewinhein.carsale.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> findAll() {
        return carRepository.findAllWithDetails();
    }
    @Override
    public Optional<Car> findById(CarId id) {
        return carRepository.findById(id);
    }
    @Override
    public Car save(Car car) {
        // Add validation, e.g., check if carGroup and variant exist
        return carRepository.save(car);
    }
    @Override
    public void deleteById(CarId id) {
        carRepository.deleteById(id);
    }




}