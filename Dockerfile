FROM maven:3-eclipse-temurin-17-alpine AS build

# Build Stage
WORKDIR /opt/app

COPY ./ /opt/app

RUN mvn clean install

# Docker build Stage
FROM eclipse-temurin:17-jdk-alpine

COPY --from=build /opt/app/target/*.jar jenkins-docker-automation.jar

ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "jenkins-docker-automation.jar"]