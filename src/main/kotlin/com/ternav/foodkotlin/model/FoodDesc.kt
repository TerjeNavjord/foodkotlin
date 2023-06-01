package com.ternav.foodkotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "food_descs")
data class FoodDesc(
        @Id
        @Column(name = "id")
        val id: Int,

        @Column(name = "ndb_no")
        val ndbNo: String,

        @Column(name = "fdgrp_cd")
        val fdgrpCd: String,

        @Column(name = "long_desc")
        val longDesc: String,

        @Column(name = "shrt_desc")
        val shortDesc: String,

        @Column(name = "comname")
        val comname: String,

        @Column(name = "manufacname")
        val manufacname: String,

        @Column(name = "survey")
        val survey: String,

        @Column(name = "ref_desc")
        val refDesc: String,

        @Column(name = "refuse")
        val refuse: Int,

        @Column(name = "sciname")
        val sciname: String,

        @Column(name = "n_factor")
        val nFactor: Float,

        @Column(name = "pro_factor")
        val proFactor: Float,

        @Column(name = "fat_factor")
        val fatFactor: Float,

        @Column(name = "cho_factor")
        val choFactor: Float,

        @Column(name = "popularity")
        val popularity: Int?,

        @Column(name = "usda_status")
        val usdaStatus: String
)