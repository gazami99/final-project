FROM adoptopenjdk/openjdk11:latest
ENV SPRING_PROFILE "dev"
ARG JAR_FILE=FPBoot-deploy/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILE}","-jar","/app.jar"]
