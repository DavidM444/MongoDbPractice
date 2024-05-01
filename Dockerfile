FROM adoptopenjdk:17-jre-hotspot-alpine3.14
LABEL maintainer="David Muñoz"
ARG JAR_FILE=target/*.jar
COPY ./target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]