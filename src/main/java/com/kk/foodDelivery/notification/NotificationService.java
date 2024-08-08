package com.kk.foodDelivery.notification;

import com.kk.foodDelivery.order.OrderPlaced;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificationService {

        @ApplicationModuleListener
        void orderPlacedListener(OrderPlaced orderPlaced){
            System.out.println("orderPlacedListener : Orderplace notification sent for order id "+orderPlaced.orderId());
        }
}
