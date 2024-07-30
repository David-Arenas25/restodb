# Usar una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo build.gradle, settings.gradle y el wrapper de Gradle
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Descargar las dependencias de Gradle
RUN gradlew build

# Copiar el resto del código de la aplicación
COPY src ./src

# Compilar la aplicación
RUN ./gradlew build

# Establecer el comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "build/libs/tu-aplicacion.jar"]
