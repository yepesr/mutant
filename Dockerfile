# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8-jdk-alpine

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./



RUN ./mvnw dependency:go-offline

COPY config ./config
COPY src ./src

COPY src ./src
CMD ["./mvnw", "spring-boot:run"]