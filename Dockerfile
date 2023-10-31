FROM adoptopenjdk:17-jre-hotspot

VOLUME /tmp

COPY target/*.jar quickhandy.jar

ENTRYPOINT ["java","-jar","/quickhandy.jar"]

EXPOSE 8080
