FROM openjdk:17-jdk-alpine
LABEL mantainer="Miquel Aleixandre"
COPY target/duffbeer-1.0.0-SNAPSHOT.jar duffbeer-1.0.0-SNAPSHOT.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","duffbeer-1.0.0-SNAPSHOT.jar"]