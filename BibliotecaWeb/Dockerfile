FROM openjdk:8
EXPOSE 8080
ADD target/web3Biblioteca.jar web3Biblioteca.jar
ENTRYPOINT ["java","-jar","web3Biblioteca.jar"]
#FROM maven:3.8.2-jdk-8
WORKDIR /BibliotecaWeb
COPY . .
#RUN mvn clean install
CMD mvn spring-boot:run

