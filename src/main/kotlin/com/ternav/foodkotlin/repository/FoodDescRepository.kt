package com.ternav.foodkotlin.repository

import com.ternav.foodkotlin.model.FoodDesc
// import org.springframework.cache.annotation.CacheEvict
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodDescRepository : JpaRepository<FoodDesc, String> {
    fun findByShortDescContainingIgnoreCase(foodName: String): List<FoodDesc>

//    @CacheEvict("foodDescCache", allEntries = true)
//    override fun <S : FoodDesc?> save(entity: S): S
}
