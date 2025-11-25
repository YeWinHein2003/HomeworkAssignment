package com.yewinhein.carsale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

        @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "car_group_id", referencedColumnName = "car_group_id", insertable = false, updatable = false),
            @JoinColumn(name = "variant_id", referencedColumnName = "variant_id", insertable = false, updatable = false)
    })
    private Car car;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderDetail() {

    }

    public OrderDetail(OrderDetailId id, Order order, Car car, Integer quantity) {
        this.id = id;
        this.order = order;
        this.car = car;
        this.quantity = quantity;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
