package com.kk.foodDelivery.notification;

import com.kk.foodDelivery.order.OrderPlaced;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificationService {

        @EventListener
        void orderPlacedListener(OrderPlaced orderPlaced){
            System.out.println("Orderplace notification sent for order id "+orderPlaced.orderId());
        }
}
