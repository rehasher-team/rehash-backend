# Build stage
FROM gradle:8.5-jdk21 AS builder

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test

# Run stage

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

RUN chmod 755 ./entrypoint.sh

ENTRYPOINT ["entrypoint.sh"]
