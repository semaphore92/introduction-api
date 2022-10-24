FROM openjdk:11-jdk
COPY ./build/libs/introduction-api-SNAPSHOT.jar app.jar
ENTRYPOINT ["java" , "-jar", "app.jar"]