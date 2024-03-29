# Build the application
FROM gradle:8.6.0-jdk17-alpine AS build
WORKDIR /aldeamo-technical-test
COPY build.gradle .
COPY settings.gradle .
COPY gradle/ ./gradle/
RUN gradle dependencies --no-daemon
COPY src ./src
RUN gradle build --no-daemon

# Create the final image
FROM openjdk:17-alpine
WORKDIR /aldeamo-technical-test
COPY --from=build /aldeamo-technical-test/build/libs/aldeamo-0.0.1-SNAPSHOT.jar ./aldeamo.jar
EXPOSE 8000
CMD ["java", "-jar", "aldeamo.jar"]