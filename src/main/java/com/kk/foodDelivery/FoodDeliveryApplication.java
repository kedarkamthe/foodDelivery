package com.kk.foodDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kk.foodDelivery.*.*","com.kk.foodDelivery.*.*","com.kk.foodDelivery.order","com.kk.foodDelivery.food","com.kk.foodDelivery.delivery","com.kk.foodDelivery.notification"})
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);
	}

}
