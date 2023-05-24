FROM amazoncorretto:17.0.7-al2023-headless
EXPOSE 8081
COPY . /src
WORKDIR /src
ARG JAR_FILE=target/raniot-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]