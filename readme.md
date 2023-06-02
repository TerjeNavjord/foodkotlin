# FoodKotlin
This is a Spring Boot REST API written in Kotlin for returning data from a nutrition database based on USDA28 dataset stored in a MySQL database using PlanetScale.

The API is available to test: 
https://green-cherry-4026.fly.dev/
<br>

https://green-cherry-4026.fly.dev/foods/apple
to search the database for "apple" and 
<br /> https://green-cherry-4026.fly.dev/foods/03147/nutrients to get the nutrients for food with id "03147" (a specific baby food).
<br />

To use, PLANETSCALE_USERNAME and PLANETSCALE_PASSWORD musth be added to the environment variables.