FROM eclipse-temurin:17-jdk-apline
VOLUME /tmp
EXPOSE 8080
COPY target/*.jar  app.jar

ENTRYPOINT ["java","-jar","/app.jar"]