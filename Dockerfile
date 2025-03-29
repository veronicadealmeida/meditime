FROM ubuntu:latest AS build

RUN apt-get update && apt-get install openjdk-21-jdk maven -y

COPY . .

RUN mvn clean install

FROM openjdk:21-jdk-slim
EXPOSE 8086

COPY --from=build /target/time-1.jar /app/time.jar

ENTRYPOINT ["java", "-jar", "/app/time.jar" ]