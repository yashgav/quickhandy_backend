FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY target/quickhandy.jar  app.jar

ENTRYPOINT ["java","-jar","/app.jar"]