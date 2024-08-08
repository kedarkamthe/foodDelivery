package com.kk.foodDelivery.delivery;

import com.kk.foodDelivery.delivery.internal.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final AgentRepository agentRepository;

    @Autowired
    public DeliveryService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Long isAgentAvailableForFoodDelivery() {
         return agentRepository.findByFirstAvailableAgentId();
    }

    public void bookFood(Long agentId,Long orderId) {
        agentRepository.bookAgentForOrderId(agentId,orderId );
    }
}
