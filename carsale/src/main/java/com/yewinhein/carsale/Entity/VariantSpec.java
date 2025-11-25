package com.yewinhein.carsale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "variant_spec")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class VariantSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_spec_id")
    private Integer variantSpecId;

    @Column(name = "color")
    private String color;



    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "motor_type")
    private String motorType;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "drive")
    private String drive;

    @Column(name = "engine")
    private String engine;

    @OneToOne
    @JoinColumn(name = "variant_id",referencedColumnName = "variant_id", nullable = false)
    private Variant variant;

    public VariantSpec() {

    }

    public VariantSpec(Integer variantSpecId, String color, Integer capacity, String motorType, String transmission, Integer productionYear, String drive, String engine, Variant variant) {
        this.variantSpecId = variantSpecId;
        this.color = color;
        this.capacity = capacity;
        this.motorType = motorType;
        this.transmission = transmission;
        this.productionYear = productionYear;
        this.drive = drive;
        this.engine = engine;
        this.variant = variant;
    }

    public Integer getVariantSpecId() {
        return variantSpecId;
    }

    public void setVariantSpecId(Integer variantSpecId) {
        this.variantSpecId = variantSpecId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }
}
