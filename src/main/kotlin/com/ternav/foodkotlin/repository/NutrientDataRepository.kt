package com.ternav.foodkotlin.repository

import com.ternav.foodkotlin.model.NutrientData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NutrientDataRepository : JpaRepository<NutrientData, Long> {
    fun findByNdbNo(foodId: String): List<NutrientData>
}
