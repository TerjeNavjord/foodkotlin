package com.ternav.foodkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
//@EntityScan("com.ternav.foodkotlin.model")
class FoodKotlinApplication

fun main(args: Array<String>) {
    runApplication<FoodKotlinApplication>(*args)
}
