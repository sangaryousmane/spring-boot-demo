FROM openjdk:17

ARG JAR_URL=target/*jar

COPY ${JAR_URL} springboot-demo.jar

ENTRYPOINT ["java", "-jar", "/springboot-demo.jar"]

EXPOSE 8900