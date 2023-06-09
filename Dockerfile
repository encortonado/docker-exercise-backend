FROM openjdk:17-jdk

VOLUME /tmp

COPY target/docker-exercise-backend-0.0.1.jar app.jar

EXPOSE 9980

ENTRYPOINT ["java","-jar","/app.jar"]
