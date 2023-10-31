FROM maven:3.8.5-openjdk-17 AS build

RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

VOLUME /tmp

COPY target/quickhandy-0.0.1-SNAPSHOT.jar quickhandy.jar

ENTRYPOINT ["java","-jar","/quickhandy.jar"]

EXPOSE 8080
