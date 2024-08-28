# Use OpenJDK 17 base image
FROM openjdk:17

# Copy the jar file into the container
COPY target/jobboo-0.0.1-SNAPSHOT.jar /app.jar

# Set the default command to execute when launching the container
CMD ["java", "-jar", "/app.jar"]

# Expose the port the app runs on
EXPOSE 8080
