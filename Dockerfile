# Use Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Use OpenJDK to run the jar
FROM openjdk:17
COPY --from=build /app/target/jobboo-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
EXPOSE 8080
