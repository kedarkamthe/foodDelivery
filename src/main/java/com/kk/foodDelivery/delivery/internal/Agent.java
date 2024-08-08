package com.kk.foodDelivery.delivery.internal;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
class Agent{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="AGENT_ID_GENERATOR" )
    @SequenceGenerator(name = "AGENT_ID_GENERATOR", sequenceName = "AGENT_SEQ", allocationSize = 1)
    Long id;
    boolean reserved;
    Long orderId;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Agent(){}

    public Agent(String name, boolean reserved, Long orderId) {
        setName(name);
        setReserved(reserved);
        setOrderId(orderId);
    }


    public Long getId() {
        return id;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
