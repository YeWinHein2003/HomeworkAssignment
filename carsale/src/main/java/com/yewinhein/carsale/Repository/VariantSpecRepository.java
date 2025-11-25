package com.yewinhein.carsale.Repository;

import com.yewinhein.carsale.Entity.VariantSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantSpecRepository extends JpaRepository<VariantSpec, Integer> {

}