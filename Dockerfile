FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=target/*.war
COPY ${JAR_FILE_PATH} app.war
ENTRYPOINT ["java", "-jar", "app.war"]
