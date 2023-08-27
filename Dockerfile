FROM adoptopenjdk:11-jdk-hotspot as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN apt-get update && apt-get install dos2unix
RUN dos2unix mvnw
RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE=*.jar
COPY --from=build /app/target/${JAR_FILE} unidrive.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "unidrive.jar"]