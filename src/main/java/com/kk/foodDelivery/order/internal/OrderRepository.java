package com.kk.foodDelivery.order.internal;

import com.kk.foodDelivery.order.FoodOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface OrderRepository  extends CrudRepository<KOrder,Long> {

    default void bookOrder(FoodOrder order){
        this.save(new KOrder(order.id(),order.booked()));
    }

    default Optional<FoodOrder> getOrderById(Long orderId){
       Optional<KOrder> order = this.findById(orderId);
       return order.map(kOrder -> new FoodOrder(kOrder.getId(),kOrder.isBooked()));
    }

    @Query(value = "SELECT NEXTVAL('FOOD_ORDER_SEQ')", nativeQuery = true)
    Long getNextOrderId();
}

