package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.CarGroup;
import com.yewinhein.carsale.Repository.CarGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarGroupServiceImpl implements CarGroupService {
    @Autowired
    private CarGroupRepository carGroupRepository;
    @Override
    public List<CarGroup> findAll() {
        return carGroupRepository.findAll();
    }
    @Override
    public Optional<CarGroup> findById(Integer id) {
        return carGroupRepository.findById(id);
    }
    @Override
    public CarGroup save(CarGroup carGroup) {
        return carGroupRepository.save(carGroup);
    }
    @Override
    public void deleteById(Integer id) {
        carGroupRepository.deleteById(id);
    }
}