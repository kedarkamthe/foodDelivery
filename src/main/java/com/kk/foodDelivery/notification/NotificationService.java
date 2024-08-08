package com.kk.foodDelivery.notification;

import com.kk.foodDelivery.order.OrderPlaced;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Transactional
public class NotificationService {

        @ApplicationModuleListener
        void orderPlacedListener(OrderPlaced orderPlaced){
            System.out.println("orderPlacedListener : Orderplace notification sent for order id "+orderPlaced.orderId());
        }

        @TransactionalEventListener
        void orderPlacedsmsListener(OrderPlaced orderPlaced){
            System.out.println("orderPlacedsmsListener : Orderplace notification sent for order id "+orderPlaced.orderId());
        }

        // For each listener annotated with  @ApplicationModuleListener/@TransactionalEventListener it created one entry in event_publication table
        // When we use simple @EventListener it doesn't create entry in event_publication table
}
