# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy Gradle wrapper and project files
COPY . .

# Build the application
RUN ./gradlew build -x test --no-daemon

# Expose the port your app runs on (default 8083)
EXPOSE 8083

# Run the JAR file
CMD ["java", "-jar", "build/libs/quickconvo-0.0.1-SNAPSHOT.jar"]