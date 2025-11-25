package com.yewinhein.carsale.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderDetailId {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "car_group_id")
    private Integer carGroupId;

    @Column(name = "variant_id")
    private Integer variantId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailId)) return false;
        OrderDetailId other = (OrderDetailId) o;
        return Objects.equals(orderId, other.orderId) &&
                Objects.equals(carGroupId, other.carGroupId) &&
                Objects.equals(variantId, other.variantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, carGroupId, variantId);
    }

    public OrderDetailId() {}


    public OrderDetailId(Long orderId, Integer carGroupId, Integer variantId) {
        this.orderId = orderId;
        this.carGroupId = carGroupId;
        this.variantId = variantId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCarGroupId() {
        return carGroupId;
    }

    public void setCarGroupId(Integer id) {
        this.carGroupId = id;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }
}
