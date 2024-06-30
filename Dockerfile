FROM amazoncorretto:17.0.9

ARG JAVA_APP=build/libs/demo-0.0.1-SNAPSHOT.jar

COPY ${JAVA_APP} docker_java.jar

ENTRYPOINT ["java","-jar","/docker_java.jar","--spring.profiles.active=prod"]