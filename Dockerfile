FROM amazoncorretto:21-alpine

WORKDIR /usr/app

COPY ./target/*.jar ./app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]
