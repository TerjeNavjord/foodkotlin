import com.ternav.foodkotlin.model.FoodDesc
import com.ternav.foodkotlin.model.NutrientData
import com.ternav.foodkotlin.model.NutrientDefs
import com.ternav.foodkotlin.repository.FoodDescRepository
import com.ternav.foodkotlin.repository.NutrientDataRepository
import com.ternav.foodkotlin.repository.NutrientDefsRepository
import com.ternav.foodkotlin.service.FoodService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockitoExtension::class)
class FoodServiceTest {
    @Mock
    private lateinit var foodDescRepository: FoodDescRepository

    @Mock
    private lateinit var nutrientDataRepository: NutrientDataRepository

    @Mock
    private lateinit var nutrientDefsRepository: NutrientDefsRepository

    @InjectMocks
    private lateinit var foodService: FoodService

    @Test
    fun testSearchFoodByName() {
        val foodName = "apple"
        val foodDesc1 = FoodDesc(
            id = 1,
            ndbNo = "12345",
            fdgrpCd = "Fruits",
            longDesc = "Apple",
            shortDesc = "APPL",
            comname = "Apple",
            manufacname = "",
            survey = "",
            refDesc = "",
            refuse = 0,
            sciname = "Malus domestica",
            nFactor = 1.0f,
            proFactor = 1.0f,
            fatFactor = 1.0f,
            choFactor = 1.0f,
            popularity = null,
            usdaStatus = "active"
        )

        val foodDesc2 = FoodDesc(
            id = 2,
            ndbNo = "67890",
            fdgrpCd = "Fruits",
            longDesc = "Green Apple",
            shortDesc = "GRAP",
            comname = "Green Apple",
            manufacname = "",
            survey = "",
            refDesc = "",
            refuse = 0,
            sciname = "Malus domestica",
            nFactor = 1.0f,
            proFactor = 1.0f,
            fatFactor = 1.0f,
            choFactor = 1.0f,
            popularity = null,
            usdaStatus = "active"
        )

        val foods = listOf(foodDesc1, foodDesc2)

        `when`(foodDescRepository.findByShortDescContainingIgnoreCase(foodName))
            .thenReturn(foods)

        val result = foodService.searchFoodByName(foodName)

        assertEquals(2, result.size)
        // Assert other expectations if needed
    }

    @Test
    fun testGetFoodNutrients() {
        val foodId = "12345"
        val nutrientData1 = NutrientData(
            id = 1,
            ndbNo = foodId,
            nutrNo = "1001",
            nutrVal = 10.0f,
            numDataPts = 1,
            stdError = null,
            srcCd = "",
            derivCd = "",
            refNdbNo = "",
            addNutrMark = "",
            numStudies = null,
            min = null,
            max = null,
            df = null,
            lowEb = null,
            upEb = null,
            statCmt = null,
            cc = null,
            usdaStatus = "active"
        )

        val nutrientData2 = NutrientData(
            id = 2,
            ndbNo = foodId,
            nutrNo = "1002",
            nutrVal = 5.0f,
            numDataPts = 1,
            stdError = null,
            srcCd = "",
            derivCd = "",
            refNdbNo = "",
            addNutrMark = "",
            numStudies = null,
            min = null,
            max = null,
            df = null,
            lowEb = null,
            upEb = null,
            statCmt = null,
            cc = null,
            usdaStatus = "active"
        )
        val nutrientDataList = listOf(nutrientData1, nutrientData2)
        val nutrientDef1 = NutrientDefs(
            id = 1,
            nutrNo = "1001",
            units = "g",
            tagName = "",
            nutrDesc = "Protein",
            numDec = "",
            srOrder = 1,
            isDefault = null,
            usdaStatus = "active"
        )

        val nutrientDef2 = NutrientDefs(
            id = 2,
            nutrNo = "1002",
            units = "g",
            tagName = "",
            nutrDesc = "Carbohydrate",
            numDec = "",
            srOrder = 2,
            isDefault = null,
            usdaStatus = "active"
        )
        val nutrientDefMap = mapOf(
            nutrientData1.nutrNo to nutrientDef1,
            nutrientData2.nutrNo to nutrientDef2
        )

        `when`(nutrientDataRepository.findByNdbNo(foodId))
            .thenReturn(nutrientDataList)

        `when`(nutrientDefsRepository.findAllByNutrNoIn(nutrientDataList.map { it.nutrNo }))
            .thenReturn(listOf(nutrientDef1, nutrientDef2))

        val result = foodService.getFoodNutrients(foodId)

        assertEquals(2, result.size)
        // Assert other expectations?
    }

}
