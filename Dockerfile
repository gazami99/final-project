FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=FPBoot-deploy/target/*.war
COPY ${JAR_FILE_PATH} app.war
ENTRYPOINT ["java", "-war", "app.war"]
