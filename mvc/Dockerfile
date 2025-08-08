FROM maven:3.8.4-jdk-8 AS Build
# FROM busca: importa a imagem do maven e chama ele de build
COPY src /app/src
#copia nossa pasta /src as pastas para dentro da pasta app que existe dentro do containers /app/src
COPY pom.xml  /app
#copia nosso arquivo pom.xml para dentro da pasta app que existe dentro do containers /app/src
WORKDIR /app
#muda para o diretorio /app dentro do containers
RUN mvn clean install
#instala dependencias maven e build dessa app spring
FROM openjdk:8-jre-alpine
#instala o JDK e add dentro do containers
COPY --from=build /app/target/spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar /app/app.jar
#Faz a copia dos arquivos gerados na instalação (o build realizado) /app/target/spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar para dentro do containers /app/app.jar
WORKDIR /app
#entra no diretorio /app dentro do containers
EXPOSE 8080
#Exponhe a porta 8080
CMD ["java","-jar", "app.jar"]
#Finalizando iniciando o containers - CMD como se tivesse rodando no terminal o java jar e a app.jar
#apos vai no terminal do intellij e gera a imagem com comando docker build