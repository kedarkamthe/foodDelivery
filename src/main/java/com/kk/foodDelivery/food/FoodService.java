package com.kk.foodDelivery.food;

import com.kk.foodDelivery.food.internal.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Boolean isFoodWithIdAvailable(Long foodId) {
        return foodRepository.findByIdAndReserved(foodId, false).isPresent();
    }

    public void bookFood(Long foodId,Long orderId) {
        foodRepository.bookFoodForOrderId(foodId,orderId );
    }

}
