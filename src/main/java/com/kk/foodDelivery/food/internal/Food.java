package com.kk.foodDelivery.food.internal;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
class Food {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="FOOD_ID_GENERATOR" )
    @SequenceGenerator(name = "FOOD_ID_GENERATOR", sequenceName = "FOOD_SEQ", allocationSize = 1)
    Long id;
    boolean reserved;
    String name;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    Long orderId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

}
