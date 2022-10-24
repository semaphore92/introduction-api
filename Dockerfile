FROM openjdk:11-jdk

COPY target/ app.jar

ENTRYPOINT ["java" , "-jar", "app.jar"]