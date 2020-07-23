FROM openjdk:8
COPY ./target/desafiotecnico.jar desafiotecnico.jar
CMD ["java","-jar","desafiotecnico.jar"]