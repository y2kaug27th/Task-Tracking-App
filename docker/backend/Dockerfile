FROM maven:3.9.9-amazoncorretto-21 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /build/target/tasks-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
ENV DB_URL=jdbc:postgresql://db:5432/postgres
CMD ["java", "-jar", "-Dspring.datasource.url=${DB_URL}", "tasks-0.0.1-SNAPSHOT.jar"]