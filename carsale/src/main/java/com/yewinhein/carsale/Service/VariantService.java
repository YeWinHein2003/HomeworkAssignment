package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {
    List<Variant> findAll();
    Optional<Variant> findById(Integer id);
    Variant save(Variant variant);
    void deleteById(Integer id);
}