package com.yewinhein.carsale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car_group_table")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class CarGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_group_id")
    private Integer id;

    @Column(name = "car_group", nullable = false, unique = true)
    private String carGroup;

    @OneToMany(mappedBy = "carGroup",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    public CarGroup() {

    }

    public CarGroup(Integer id, String carGroup, List<Car> cars) {
        this.id = id;
        this.carGroup = carGroup;
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(String carGroup) {
        this.carGroup = carGroup;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
