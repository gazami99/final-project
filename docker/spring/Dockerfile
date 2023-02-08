ENV SPRING_PROFILE "dev"
FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=FPBoot-deploy/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILE}","-jar","/app.jar"]
