# Usa una imagen base de OpenJDK
FROM openjdk:19-jdk-alpine


# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado en el contenedor
COPY target/Restobar-CavaDorada-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que correrá la aplicación
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
