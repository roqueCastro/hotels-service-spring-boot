#Iniciar con la imagen base que contiene JAVA runtime
FROM openjdk:17-jdk-slim as build

#Se agrega el jar del microservicio al contenedor
COPY target/hotels-0.0.1-SNAPSHOT.jar hotels-0.0.1-SNAPSHOT.jar

#Se ejecuta el microservicio
ENTRYPOINT [ "java", "-jar", "/hotels-0.0.1-SNAPSHOT.jar" ]