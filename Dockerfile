#FROM adoptopenjdk:17-jre-hotspot
FROM ibm-semeru-runtimes:open-17-jre-focal

LABEL authors="Terje"



COPY target/FoodKotlin-0.0.1-SNAPSHOT.jar  /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]

EXPOSE 8080
EXPOSE 8081

#ENTRYPOINT ["top", "-b"]