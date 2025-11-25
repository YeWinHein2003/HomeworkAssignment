package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.Variant;

import com.yewinhein.carsale.Repository.VariantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    private VariantRepository variantRepository;
    @Override
    public List<Variant> findAll() {
        return variantRepository.findAll();
    }
    @Override
    public Optional<Variant> findById(Integer id) {
        return variantRepository.findById(id);
    }
    @Override
    public Variant save(Variant variant) {
        return variantRepository.save(variant);
    }
    @Override
    public void deleteById(Integer id) {
        variantRepository.deleteById(id);
    }
}