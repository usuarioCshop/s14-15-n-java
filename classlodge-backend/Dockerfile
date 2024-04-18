# Usar una imagen base de Ubuntu para construir el proyecto
FROM ubuntu:latest AS build

# Instalar JDK y Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copiar el código fuente del proyecto al contenedor
COPY . .

# Usar Maven para construir el proyecto y generar el JAR
RUN mvn package -DskipTests


# Usar una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080


# Copiar el JAR desde el contenedor de construcción al contenedor de ejecución
COPY --from=build out/artifacts/classlogde_jar/classlodge.jar classlodge.jar


# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "classlodge.jar"]
