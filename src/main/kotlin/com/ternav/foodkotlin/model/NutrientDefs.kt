package com.ternav.foodkotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "nutrient_defs")
data class NutrientDefs(
        @Id
        @Column(name = "id")
        val id: Long,

        @Column(name = "nutr_no")
        val nutrNo: String,

        @Column(name = "units")
        val units: String,

        @Column(name = "tagname")
        val tagName: String,

        @Column(name = "nutrdesc")
        val nutrDesc: String,

        @Column(name = "num_dec")
        val numDec: String,

        @Column(name = "sr_order")
        val srOrder: Int,

        @Column(name = "is_default")
        val isDefault: Boolean?,

        @Column(name = "usda_status")
        val usdaStatus: String = "active"
)
