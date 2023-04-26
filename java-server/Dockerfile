FROM maven:3.9.0-eclipse-temurin-17-alpine

ADD target/user-0.0.1-SNAPSHOT.jar user-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","user-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080