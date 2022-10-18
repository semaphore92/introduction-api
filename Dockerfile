FROM openjdk:11-jdk

ARG JAR_FILE_PATH

COPY ${JAR_FILE_PATH} app.jar

ENTRYPOINT ["java" , "-jar", "app.jar"]