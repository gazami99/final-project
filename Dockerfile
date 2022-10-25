FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=target/*.war
COPY FPBoot-deploy/target/*.war app.war
ENTRYPOINT ["java", "-jar", "app.war"]
