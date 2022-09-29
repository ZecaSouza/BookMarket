FROM openjdk:17-jdk-slim
MAINTAINER Zeca Souza
ARG JAR_FILE=target/*.jar
RUN bash -c 'touch /app.jar'
COPY build/libs/*jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]