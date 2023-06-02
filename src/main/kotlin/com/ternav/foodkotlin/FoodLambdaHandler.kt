package com.ternav.foodkotlin

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.ternav.foodkotlin.controller.FoodController
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class FoodLambdaHandler : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(FoodKotlinApplication::class.java)

    private val foodController: FoodController = applicationContext.getBean(FoodController::class.java)

    override fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        val pathParameters = input.pathParameters
        val response = APIGatewayProxyResponseEvent()

        // Handle different API paths and methods
        if (input.resource == "/foods/{foodName}" && input.httpMethod == "GET") {
            val foodName = pathParameters["foodName"]!!
            val foodList = foodController.searchFood(foodName)
            response.statusCode = 200
            response.body = foodList.toString()
        } else if (input.resource == "/foods/{foodId}/nutrients" && input.httpMethod == "GET") {
            val foodId = pathParameters["foodId"]!!
            val nutrientList = foodController.getFoodNutrients(foodId)
            response.statusCode = 200
            response.body = nutrientList.toString()
        } else {
            response.statusCode = 404
        }

        return response
    }
}

