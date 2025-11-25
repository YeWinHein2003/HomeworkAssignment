package com.yewinhein.carsale.Repository;

import com.yewinhein.carsale.Entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {

}
