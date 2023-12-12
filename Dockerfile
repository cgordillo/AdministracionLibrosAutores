# Fase de construcción
FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean install -DskipTests

# Fase de ejecución
FROM openjdk:17-jdk-slim
MAINTAINER Administracion Libros
ARG ENV
COPY --from=builder /app/target/*.jar /app/administracionlibros-1.0.1.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/administracionlibros-1.0.1.jar"]