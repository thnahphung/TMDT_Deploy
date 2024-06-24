FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/Api-springboot-0.0.1-SNAPSHOT.jar App-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/App-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080