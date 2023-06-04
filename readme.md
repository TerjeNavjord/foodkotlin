# FoodKotlin
This is a Spring Boot REST API written in Kotlin for returning data from a nutrition database based on USDA28 dataset stored in a MySQL database using PlanetScale.

There are simple tests for some of the files using JUnit, Mockito etc..

The API is hosted in a docker-container on a 256mb ram vm, and available to test (wait a few seconds if the vm runs out of ram): <br />
HATEOAS: <br /> 
http://food.ternav.com/
<br />
<br />
Additional endpoints:<br />
http://food.ternav.com/apple
to search the database for "apple" (replace to search for something else and get the id) 
<br /> http://food.ternav.com/03147/nutrients to get the nutrients for food with id "03147" (a specific baby food).
<br />

To deploy, PLANETSCALE_USERNAME and PLANETSCALE_PASSWORD must be added to the environment variables.