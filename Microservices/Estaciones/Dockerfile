FROM openjdk:20
EXPOSE 8080
ADD target/estacion-docker.jar estacion-docker.jar
ENTRYPOINT ["java", "-jar", "/estacion-docker.jar"]