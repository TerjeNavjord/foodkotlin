package com.ternav.foodkotlin.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FoodDescTest {

    @Test
    fun testFoodDescFields() {
        val id = 1
        val ndbNo = "12345"
        val fdgrpCd = "GROUP1"
        val longDesc = "Long Description"
        val shortDesc = "Short Description"
        val comname = "Common Name"
        val manufacname = "Manufacturer Name"
        val survey = "Survey"
        val refDesc = "Reference Description"
        val refuse = 0
        val sciname = "Scientific Name"
        val nFactor = 1.0f
        val proFactor = 2.0f
        val fatFactor = 3.0f
        val choFactor = 4.0f
        val popularity = 10
        val usdaStatus = "Approved"

        val foodDesc = FoodDesc(
            id = id,
            ndbNo = ndbNo,
            fdgrpCd = fdgrpCd,
            longDesc = longDesc,
            shortDesc = shortDesc,
            comname = comname,
            manufacname = manufacname,
            survey = survey,
            refDesc = refDesc,
            refuse = refuse,
            sciname = sciname,
            nFactor = nFactor,
            proFactor = proFactor,
            fatFactor = fatFactor,
            choFactor = choFactor,
            popularity = popularity,
            usdaStatus = usdaStatus
        )

        assertEquals(id, foodDesc.id)
        assertEquals(ndbNo, foodDesc.ndbNo)
        assertEquals(fdgrpCd, foodDesc.fdgrpCd)
        assertEquals(longDesc, foodDesc.longDesc)
        assertEquals(shortDesc, foodDesc.shortDesc)
        assertEquals(comname, foodDesc.comname)
        assertEquals(manufacname, foodDesc.manufacname)
        assertEquals(survey, foodDesc.survey)
        assertEquals(refDesc, foodDesc.refDesc)
        assertEquals(refuse, foodDesc.refuse)
        assertEquals(sciname, foodDesc.sciname)
        assertEquals(nFactor, foodDesc.nFactor)
        assertEquals(proFactor, foodDesc.proFactor)
        assertEquals(fatFactor, foodDesc.fatFactor)
        assertEquals(choFactor, foodDesc.choFactor)
        assertEquals(popularity, foodDesc.popularity)
        assertEquals(usdaStatus, foodDesc.usdaStatus)
    }
}
