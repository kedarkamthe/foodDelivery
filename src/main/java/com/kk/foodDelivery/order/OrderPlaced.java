package com.kk.foodDelivery.order;

import org.springframework.modulith.events.Externalized;

@Externalized(target = "FoodOrderPlaced")
public record OrderPlaced(Long orderId) {
}
