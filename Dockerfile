FROM openjdk:17.0.1-jdk-slim

EXPOSE 8080

ADD target/quickhandy.jar quickhandy.jar

ENTRYPOINT ["java","-jar","/quickhandy.jar"]

