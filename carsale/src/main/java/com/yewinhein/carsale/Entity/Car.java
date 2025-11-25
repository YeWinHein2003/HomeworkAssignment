package com.yewinhein.carsale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Car {
    @EmbeddedId
    private CarId id;

    @ManyToOne
    @MapsId("carGroupId")
    @JoinColumn(name = "car_group_id", referencedColumnName = "car_group_id",insertable = false, updatable = false)
    private CarGroup carGroup;

    @ManyToOne
    @MapsId("variantId")
    @JoinColumn(name = "variant_id", referencedColumnName = "variant_id" , insertable = false, updatable = false)
    private Variant variant;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;

    public Car() {

    }

    public Car(CarId id, CarGroup carGroup, Variant variant, String carName, Integer unitPrice) {
        this.id = id;
        this.carGroup = carGroup;
        this.variant = variant;
        this.carName = carName;
        this.unitPrice = unitPrice;
    }



    public CarId getId() {
        return id;
    }

    public void setId(CarId id) {
        this.id = id;
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(CarGroup carGroup) {
        this.carGroup = carGroup;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
}
