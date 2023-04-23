FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/introduction-api-app.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]