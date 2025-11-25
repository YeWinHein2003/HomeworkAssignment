package com.yewinhein.carsale.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Embeddable

//@NoArgsConstructor
//@AllArgsConstructor
public class CarId {
    @Column(name="car_group_id")
    private Integer carGroupId;
    @Column(name="variant_id")
    private Integer variantId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarId)) return false;
        CarId other = (CarId) o;
        return Objects.equals(carGroupId, other.carGroupId) &&
                Objects.equals(variantId, other.variantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carGroupId, variantId);
    }

    public CarId() {

    }

    public CarId(Integer id, Integer variantId) {
        this.carGroupId = id;
        this.variantId = variantId;
    }

    public Integer getCarGroupId() {
        return carGroupId;
    }

    public void setCarGroupId(Integer carGroupId) {
        this.carGroupId = carGroupId;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }
}
