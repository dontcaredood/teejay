FROM openjdk:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} TeeJay.jar
ENTRYPOINT ["java","-jar","/TeeJay.jar"]