package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.CarGroup;

import java.util.List;
import java.util.Optional;

public interface CarGroupService {
    List<CarGroup> findAll();
    Optional<CarGroup> findById(Integer id);
    CarGroup save(CarGroup carGroup);
    void deleteById(Integer id);
}