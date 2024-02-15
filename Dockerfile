FROM openjdk:8-jdk-alpine
MAINTAINER cuongnv99
COPY target/automation-1.0-SNAPSHOT.jar automation-test.jar
ENTRYPOINT ["java","-jar","automation-test.jar"]
