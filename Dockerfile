# Multi-stage build for Spring Boot application
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src/ ./src/
RUN mvn package -DskipTests

# Create runtime image
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create a user for running the application
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set environment variables
ENV PORT=8000
EXPOSE $PORT

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]