# syntax=docker/dockerfile:1.10.0
FROM maven:3.9.9-amazoncorretto-17-alpine AS mav-dependency-resolve
WORKDIR /workspace
COPY pom.xml pom.xml
RUN --mount=type=cache,id=repository,target=/root/.m2/repository mvn dependency:resolve

FROM mav-dependency-resolve AS mvn-test
COPY src src
RUN --mount=type=cache,id=repository,target=/root/.m2/repository mvn clean test

FROM mav-dependency-resolve AS mvn-package
COPY src src
RUN --mount=type=cache,id=repository,target=/root/.m2/repository mvn clean package -DskipTests

FROM openjdk:17-ea-17-slim-buster AS build-image
EXPOSE 8080
RUN addgroup --gid 1001 kanghouchao && \
    adduser --disabled-login --gid 1001  kanghouchao
USER kanghouchao:kanghouchao
WORKDIR /home/kanghouchao
COPY --from=mvn-package /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-server", "-jar", "app.jar"]