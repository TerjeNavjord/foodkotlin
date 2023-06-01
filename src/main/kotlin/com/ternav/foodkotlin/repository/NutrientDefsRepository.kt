package com.ternav.foodkotlin.repository

import com.ternav.foodkotlin.model.NutrientDefs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NutrientDefsRepository : JpaRepository<NutrientDefs, Long> {
    fun findByNutrNo(nutrNo: String): NutrientDefs?
    fun findAllByNutrNoIn(nutrNos: List<String>): List<NutrientDefs>
}
