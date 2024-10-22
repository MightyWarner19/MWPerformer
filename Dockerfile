FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /opt

# Environment variable
ENV PORT=8080

# Expose the application port (adjust this based on your Spring Boot app's port)
EXPOSE 8080

# Copy the JAR file from the build stage to the runtime stage
COPY target/*.jar /opt/app.jar

# Run the Spring Boot app with JSON format entrypoint
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /opt/app.jar"]
