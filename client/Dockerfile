# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the Maven target directory to the container
COPY target/client-1.0-SNAPSHOT.jar app.jar

# Specify the command to run the JAR file
CMD ["java", "-jar", "app.jar"]
