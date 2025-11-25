package com.yewinhein.carsale.Service;

import com.yewinhein.carsale.Entity.VariantSpec;
import com.yewinhein.carsale.Repository.VariantSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantSpecServiceImpl implements VariantSpecService {
    @Autowired
    private VariantSpecRepository variantSpecRepository;
    @Override
    public List<VariantSpec> findAll() {
        return variantSpecRepository.findAll();
    }
    @Override
    public Optional<VariantSpec> findById(Integer id) {
        return variantSpecRepository.findById(id);
    }
    @Override
    public VariantSpec save(VariantSpec variantSpec) {
        return variantSpecRepository.save(variantSpec);
    }
    @Override
    public void deleteById(Integer id) {
        variantSpecRepository.deleteById(id);
    }
}
