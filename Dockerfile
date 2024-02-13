FROM amazoncorretto:17-alpine-jdk

COPY target/challenge-1-back-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","/app.war"]