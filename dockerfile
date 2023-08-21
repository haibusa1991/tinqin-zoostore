FROM openjdk:17
LABEL authors="p.simeonov"
EXPOSE 8080
COPY rest/target/tinqin-zoostore.jar tinqin-zoostore.jar

ENTRYPOINT ["java", "-jar", "/tinqin-zoostore.jar"]