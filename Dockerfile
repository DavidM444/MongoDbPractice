FROM bellsoft/liberica-openjdk-alpine
LABEL maintainer="David Muñoz"
RUN mkdir -p /home/app
COPY ./target/mongoapp-0.0.1-SNAPSHOT.jar /home/app

EXPOSE 8081
ENTRYPOINT ["java","-jar","/home/app/mongoapp-0.0.1-SNAPSHOT.jar"]