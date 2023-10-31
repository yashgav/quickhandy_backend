FROM eclipse-temurin:17-jdk-apline

VOLUME /tmp

COPY target/*.jar quickhandy.jar

ENTRYPOINT ["java","-jar","/quickhandy.jar"]

EXPOSE 8080
