# Stage 1: Build the application
FROM gradle:7.3.3-jdk11 AS BUILD
WORKDIR /restaurante-app
COPY src /restaurante-app/src/
COPY build.gradle /restaurante-app/build.gradle
RUN gradle clean build --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=BUILD /restaurante-app/build/libs/restaurante-app-1.0.jar /app/restaurante-app-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restaurante-app-1.0.jar"]

