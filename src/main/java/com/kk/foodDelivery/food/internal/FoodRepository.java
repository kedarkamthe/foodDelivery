package com.kk.foodDelivery.food.internal;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface FoodRepository extends CrudRepository<Food,Long> {
    List<Food> findByReserved(@Param("isReserved") boolean isReserved);
    Optional<Food> findByIdAndReserved(@Param("foodId") Long id,@Param("isReserved") boolean isReserved);

    @Lock(LockModeType.WRITE)
    default void bookFoodForOrderId(Long foodId,Long orderId){
        Food food = findByIdAndReserved(foodId,false).get();
        food.setOrderId(orderId);
        food.setReserved(true);
        save(food);
    }
}
