#PARA QUE DOCKER EJECUTE TODO DESDE EL CLEAN, INSTALL, PACKAGES
#FROM maven:3.6.3-openjdk:17 as BUILDER
#ARG VERSION=0.0.1-SNAPSHOT
#WORKDIR /build/
#COPY pom.xml /build/
#COPY src /build/src

#RUN mvn clean package
#COPY target/chatbot-${VERSION}.jar target/chatbot-${VERSION}.jar
#FROM openjdk:17
#WORKDIR /app/

#COPY --from=BUILDER /build/target/chatbot-${VERSION}.jar /app/
#ENTRYPOINT ["java", "-jar", "target/chatbot-0.0.1-SNAPSHOT.jar"]

#DE MANERA NORMAL Y SENCILLA
# Se utiliza la imagen oficial de OpenJDK 17 como base
FROM openjdk:17
#PUERTO QUE SE VA A CORRER
EXPOSE 8081
# Se establece el directorio de trabajo dentro del contenedor
WORKDIR /app
# Se copia el archivo JAR de la aplicación en el contenedor
COPY target/chatbot-0.0.1-SNAPSHOT.jar target/chatbot-0.0.1-SNAPSHOT.jar
#EJECUTAR EL CMD O COMANDO PARA EL CHATBOT
ENTRYPOINT ["java", "-jar", "target/chatbot-0.0.1-SNAPSHOT.jar"]