package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.VariantSpec;

import java.util.List;
import java.util.Optional;

public interface VariantSpecService {
    List<VariantSpec> findAll();
    Optional<VariantSpec> findById(Integer id);
    VariantSpec save(VariantSpec variantSpec);
    void deleteById(Integer id);
}