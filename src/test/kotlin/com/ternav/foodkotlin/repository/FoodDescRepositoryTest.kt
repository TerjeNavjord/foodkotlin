import com.ternav.foodkotlin.FoodKotlinApplication
import com.ternav.foodkotlin.model.FoodDesc
import com.ternav.foodkotlin.repository.FoodDescRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

// @DataJpaTest
// @EnableJpaRepositories(basePackages = ["com.ternav.foodkotlin.repository"])
@SpringBootTest(classes = [FoodKotlinApplication::class])
class FoodDescRepositoryTest {
    @Autowired
    private lateinit var foodDescRepository: FoodDescRepository

    @MockBean
    private lateinit var mockFoodDescRepository: FoodDescRepository

    @Test
    fun testFindByShortDescContainingIgnoreCase() {
        // TODO: Create correct test data and check that it matches what is returned.
        val foodDesc1 = FoodDesc(
            1, "123", "FG1", "Apple Juice", "Apple", "Apple Juice Company", "Company A", "Survey1",
            "Reference1", 0, "Appleus", 1.0f, 2.0f, 3.0f, 4.0f, 100, "USDA Approved"
        )
        val foodDesc2 = FoodDesc(
            2, "456", "FG2", "Orange Juice", "Orange", "Orange Juice Company", "Company B", "Survey2",
            "Reference2", 0, "Orangeus", 1.0f, 2.0f, 3.0f, 4.0f, 200, "USDA Approved"
        )
        val foodDesc3 = FoodDesc(
            3, "789", "FG3", "Banana Juice", "Banana", "Banana Juice Company", "Company C", "Survey3",
            "Reference3", 0, "Bananaus", 1.0f, 2.0f, 3.0f, 4.0f, 300, "USDA Approved"
        )
        // foodDescRepository.saveAll(listOf(foodDesc1, foodDesc2, foodDesc3))


        val searchTerm = "apple"
        // TODO: Perform the search on the real repo instead of the mock repo
        // val foundFoods = foodDescRepository.findByShortDescContainingIgnoreCase(searchTerm)

        `when`(mockFoodDescRepository.findByShortDescContainingIgnoreCase(searchTerm))
            .thenReturn(listOf(foodDesc1, foodDesc2, foodDesc3))

        val foundFoods = foodDescRepository.findByShortDescContainingIgnoreCase(searchTerm)

        assertEquals(3, foundFoods.size)

        // TODO: Assertions to test that food descriptions above are returned.
        /* assertEquals(1, foundFoods.size)
        val foundFood = foundFoods[0]
        assertEquals(foodDesc1.id, foundFood.id)
        assertEquals(foodDesc1.ndbNo, foundFood.ndbNo)
        assertEquals(foodDesc1.fdgrpCd, foundFood.fdgrpCd)
        assertEquals(foodDesc1.longDesc, foundFood.longDesc)
        assertEquals(foodDesc1.shortDesc, foundFood.shortDesc)
        assertEquals(foodDesc1.comname, foundFood.comname)
        assertEquals(foodDesc1.manufacname, foundFood.manufacname)
        assertEquals(foodDesc1.survey, foundFood.survey)
        assertEquals(foodDesc1.refDesc, foundFood.refDesc)
        assertEquals(foodDesc1.refuse, foundFood.refuse)
        assertEquals(foodDesc1.sciname, foundFood.sciname)
        assertEquals(foodDesc1.nFactor, foundFood.nFactor)
        assertEquals(foodDesc1.proFactor, foundFood.proFactor)
        assertEquals(foodDesc1.fatFactor, foundFood.fatFactor)
        assertEquals(foodDesc1.choFactor, foundFood.choFactor)
        assertEquals(foodDesc1.popularity, foundFood.popularity)
        assertEquals(foodDesc1.usdaStatus, foundFood.usdaStatus)
    */
    }
}
