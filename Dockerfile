FROM openjdk:8-jdk-alpine
ARG JAR_FILE=FPBoot-deploy/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
