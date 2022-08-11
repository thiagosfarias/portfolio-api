FROM maven as build
WORKDIR /portfolio-container
COPY . .
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11
ARG JAR_FILE=/portfolio-container/target/portfolio-api-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 8080
