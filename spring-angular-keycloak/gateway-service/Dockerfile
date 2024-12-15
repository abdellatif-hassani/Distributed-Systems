FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]