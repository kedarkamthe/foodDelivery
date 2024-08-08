package com.kk.foodDelivery.order.internal;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "foodorder")
class KOrder {
    @Id Long id;

    public KOrder(Long orderId){
        id = orderId;
    }

    public KOrder(Long orderId,Boolean booked){
       setId(orderId);
        setBooked(booked);
    }

    public KOrder(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    boolean booked;
}
