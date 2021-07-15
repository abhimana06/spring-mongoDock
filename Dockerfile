FROM openjdk:16
ADD target/spring-mongo.jar spring-mongo.jar
ENTRYPOINT ["java","-jar","spring-mongo.jar"]