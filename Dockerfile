# ---- STAGE 1: Build the application ----
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy all project files
COPY . .

# ---- STAGE 2: Run the application ----
FROM eclipse-temurin:17-jdk

# Set environment variables
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Create app directory
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar


# Start the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
