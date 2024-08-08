package com.kk.foodDelivery.order;

import com.kk.foodDelivery.delivery.DeliveryService;
import com.kk.foodDelivery.food.FoodService;
import com.kk.foodDelivery.order.internal.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
public class OrderService {

    private final FoodService foodService;
    private final DeliveryService deliveryService;
    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderService(FoodService foodService, DeliveryService deliveryService, OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.foodService = foodService;
        this.deliveryService = deliveryService;
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping(path = "/foodOrders")
    @Transactional
    public ResponseEntity bookOrder(@Param("foodId") Long foodId){
        Long currentOrderId = orderRepository.getNextOrderId();
       if(foodService.isFoodWithIdAvailable(foodId)) {
           System.out.println("food is available");
           var agentId = deliveryService.isAgentAvailableForFoodDelivery();
           if (Objects.nonNull(agentId)) {
               FoodOrder order = new FoodOrder(currentOrderId,true);
               foodService.bookFood(foodId,order.id());
               deliveryService.bookFood(agentId,order.id());
               orderRepository.bookOrder(order);
               eventPublisher.publishEvent(new OrderPlaced(currentOrderId));
           }

       }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(currentOrderId).toUri();
       return ResponseEntity.created(location).body("Order "+currentOrderId+" is placed successfully.");

    }


    @GetMapping(path = "/foodOrders/{orderId}")
    public ResponseEntity getOrderById(@PathVariable Long orderId){
         Optional<FoodOrder> foodOrder = orderRepository.getOrderById(orderId);
         if(foodOrder.isPresent()){
             return ResponseEntity.of(foodOrder);
         }
         else{
            return ResponseEntity.notFound().build();
         }
    }


    /*@PostMapping(path = "bookOrders" )
    void bookOrder(@Param("foodId") Long foodId,@Param("orderId") Long orderId){
        List<Agent> availableAgents = agentRepository.findByIsReserved(false);
        Agent firstAgent = availableAgents.getFirst();
        firstAgent.setReserved(true);
        agentRepository.save(firstAgent);
        List<Food> availableFood = foodRepository.findByIsReserved(false);
        Food firstAvailableFood = availableFood.getFirst();
        firstAvailableFood.setReserved(true);
        foodRepository.save(firstAvailableFood);


        KOrder order = new KOrder(orderId);
        System.out.println("order Id "+order.getId());

        List<Agent> reservedAgents = agentRepository.findByIsReserved(true);
        Agent firstReservedAgents = reservedAgents.getFirst();
        firstReservedAgents.setOrderId(order.getId());
        agentRepository.save(firstReservedAgents);
        List<Food> reservedFood = foodRepository.findByIsReserved(true);
        Food firstReservedFood = reservedFood.getFirst();
        firstReservedFood.setOrderId(order.getId());
        foodRepository.save(firstReservedFood);
    }*/

}
