FROM openjdk:17

ARG JAR_URL=target/*.jar

COPY ${JAR_URL} spring-boot-demo.jar

ENTRYPOINT ["java", "-jar", "/spring-boot-demo.jar"]

EXPOSE 8900