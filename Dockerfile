FROM alpine:latest
EXPOSE 8080
ADD distribution/target/ems-api-jar-with-dependencies.jar ems-api.jar
ENTRYPOINT ["java","-jar","ems-api.jar"]