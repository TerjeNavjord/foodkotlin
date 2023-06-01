package com.ternav.foodkotlin.controller

import com.ternav.foodkotlin.service.FoodService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status



@SpringBootTest
@AutoConfigureMockMvc
class FoodControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var foodService: FoodService

    @Test
    fun testSearchFoodByName() {
        val foods = listOf(Pair("123", "Apple"), Pair("456", "Green Apple"))
        `when`(foodService.searchFoodByName("apple")).thenReturn(foods)

        val result = mockMvc.perform(get("/foods/apple")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", hasSize<Any>(foods.size)))
            .andExpect(jsonPath("$[0].first", equalTo("123")))
            .andExpect(jsonPath("$[0].second", equalTo("Apple")))
            .andExpect(jsonPath("$[1].first", equalTo("456")))
            .andExpect(jsonPath("$[1].second", equalTo("Green Apple")))
            .andReturn()

        val responseBody = result.response.contentAsString
        // Assert that the response body contains the expected values
        assertThat(responseBody, containsString("Apple"))
        assertThat(responseBody, containsString("Green Apple"))

        // Logging statements to capture information during the test
        println("Test executed successfully.")

        // Add more test methods as needed
    }



    // Add more test methods as needed
}
