package com.yewinhein.carsale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "variant",
        uniqueConstraints = @UniqueConstraint(columnNames = {"brand","model","grade"}))
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    private Integer variantId;

    private String brand;
    private String model;
    private String grade;

    @OneToOne(mappedBy = "variant",cascade = CascadeType.ALL, orphanRemoval = true)
    private VariantSpec variantSpec;

    @OneToMany(mappedBy = "variant",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    public Variant() {

    }

    public Variant(List<Car> cars, VariantSpec variantSpec, String grade, String model, String brand, Integer variantId) {
        this.cars = cars;
        this.variantSpec = variantSpec;
        this.grade = grade;
        this.model = model;
        this.brand = brand;
        this.variantId = variantId;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public VariantSpec getVariantSpec() {
        return variantSpec;
    }

    public void setVariantSpec(VariantSpec variantSpec) {
        this.variantSpec = variantSpec;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
