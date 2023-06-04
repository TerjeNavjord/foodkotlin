package com.ternav.foodkotlin.controller

import com.ternav.foodkotlin.service.FoodService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class FoodController(private val foodService: FoodService) {
    @GetMapping("/{foodName}")
    fun searchFood(@PathVariable foodName: String): List<Pair<String, String>> {
        return foodService.searchFoodByName(foodName)
    }

    @GetMapping("/{foodId}/nutrients")
    fun getFoodNutrients(@PathVariable foodId: String): List<FoodService.NutrientInfo> {
        return foodService.getFoodNutrients(foodId)
    }


}