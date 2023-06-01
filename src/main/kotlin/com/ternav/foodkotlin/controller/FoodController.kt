package com.ternav.foodkotlin.controller

import com.ternav.foodkotlin.service.FoodService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/foods")
class FoodController(private val foodService: FoodService) {
    @GetMapping("/{foodName}")
    fun searchFood(@PathVariable foodName: String): List<Pair<String, String>> {
        // Logic to search for a food by name and return the results
        // Implement your database query here
        // Return the search results as a response
    return foodService.searchFoodByName(foodName)
    }

    @GetMapping("/{foodId}/nutrients")
    fun getFoodNutrients(@PathVariable foodId: String): List<FoodService.NutrientInfo> {
        // Logic to retrieve the nutrients of a given food
        // Implement your database query here
        // Return the nutrients as a response
        return foodService.getFoodNutrients(foodId)
    }


}