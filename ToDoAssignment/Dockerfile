# Always the Dockerfile starts with FROM
FROM eclipse-temurin:17
 
# Maintainer label (optional but good for info)
LABEL maintainer="kranthi@gmail.com"
 
# Working directory inside the container
WORKDIR /app
 
# Copy the JAR from target to /app folder as spring2.jar
COPY target/todo-0.0.1-SNAPSHOT.jar todo.jar
 
# Entry point to run the application
ENTRYPOINT ["java", "-jar", "todo.jar"]
 
 