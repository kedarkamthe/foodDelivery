package com.kk.foodDelivery.delivery.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
//@Repository
public interface AgentRepository extends CrudRepository<Agent,Long> {

    List<Agent> findByReserved(@Param("isReserved") boolean isReserved);
    default Long findByFirstAvailableAgentId(){
        return findByReserved(false).getFirst().getId();
    }

    default void bookAgentForOrderId(Long agentId, Long orderId){
        Agent agent = findById(agentId).get();
      //  agent.setName("test"+agentId);
        agent.setOrderId(orderId);
        agent.setReserved(true);
        save(agent);
    }


}

