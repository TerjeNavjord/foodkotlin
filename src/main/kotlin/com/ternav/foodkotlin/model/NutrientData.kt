package com.ternav.foodkotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "nutrient_data")
data class NutrientData(
        @Id
        @Column(name = "id")
        val id: Long,

        @Column(name = "ndb_no")
        val ndbNo: String,

        @Column(name = "nutr_no")
        val nutrNo: String,

        @Column(name = "nutr_val")
        val nutrVal: Float,

        @Column(name = "num_data_pts")
        val numDataPts: Int,

        @Column(name = "std_error")
        val stdError: Float?,

        @Column(name = "src_cd")
        val srcCd: String,

        @Column(name = "deriv_cd")
        val derivCd: String?,

        @Column(name = "ref_ndb_no")
        val refNdbNo: String?,

        @Column(name = "add_nutr_mark")
        val addNutrMark: String?,

        @Column(name = "num_studies")
        val numStudies: Int?,

        @Column(name = "min")
        val min: Float?,

        @Column(name = "max")
        val max: Float?,

        @Column(name = "df")
        val df: Int?,

        @Column(name = "low_eb")
        val lowEb: Float?,

        @Column(name = "up_eb")
        val upEb: Float?,

        @Column(name = "stat_cmt")
        val statCmt: String?,

        @Column(name = "cc")
        val cc: String?,

        @Column(name = "usda_status")
        val usdaStatus: String = "active"
)
