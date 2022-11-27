FROM openjdk:17.0.2-oracle
VOLUME /tmp
ARG JAR_FILE
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]