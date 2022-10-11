FROM openjdk:8
EXPOSE 8080
ADD target/ems-api-jar-with-dependencies.jar ems-api.jar
ENTRYPOINT["java","-jar","ems-api.jar"]