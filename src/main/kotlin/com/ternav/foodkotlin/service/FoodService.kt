package com.ternav.foodkotlin.service

import com.ternav.foodkotlin.repository.FoodDescRepository
import com.ternav.foodkotlin.repository.NutrientDataRepository
import com.ternav.foodkotlin.repository.NutrientDefsRepository
import org.springframework.stereotype.Service

@Service
class FoodService(
        private val foodDescRepository: FoodDescRepository,
        private val nutrientDataRepository: NutrientDataRepository,
        private val nutrientDefsRepository: NutrientDefsRepository
) {

    fun searchFoodByName(foodName: String): List<Pair<String, String>> {
        val foods = foodDescRepository.findByShortDescContainingIgnoreCase(foodName)
        return foods.map { food -> Pair( food.ndbNo, food.longDesc )}
    }

    data class NutrientInfo(
        val nutrientDesc: String,
        val nutrientValue: Float,
        val units: String
    )

    fun getFoodNutrients(foodId: String): List<NutrientInfo> {
        val nutrientInfoList = mutableListOf<NutrientInfo>()

        val nutrientDataList = nutrientDataRepository.findByNdbNo(foodId)
        val nutrientDefMap = nutrientDefsRepository.findAllByNutrNoIn(
            nutrientDataList.map { it.nutrNo }
        ).associateBy { it.nutrNo }

        for (nutrientData in nutrientDataList) {
            val nutrientDef = nutrientDefMap[nutrientData.nutrNo]
            nutrientDef?.let {
                val nutrientInfo = NutrientInfo(
                    nutrientDesc = nutrientDef.nutrDesc,
                    nutrientValue = nutrientData.nutrVal,
                    units = nutrientDef.units
                )
                nutrientInfoList.add(nutrientInfo)
            }
        }

        return nutrientInfoList
    }
}