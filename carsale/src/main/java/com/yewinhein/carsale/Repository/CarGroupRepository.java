package com.yewinhein.carsale.Repository;

import com.yewinhein.carsale.Entity.CarGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarGroupRepository extends JpaRepository<CarGroup, Integer> {

}
