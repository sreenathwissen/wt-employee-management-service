# define base docker image
#FROM openjdk:17
#ADD target/EmployeeAPI2-0.0.1-SNAPSHOT.jar employee-api-docker.jar
#ENTRYPOINT ["java","-jar","employee-api-docker.jar"]
#
##ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} app.jar
##ENV API_KEY "None"

#From openjdk:17
#COPY ./target/employee-jdbc-0.0.1-SNAPSHOT.jar employee-jdbc-0.0.1-SNAPSHOT.jar
#CMD ["java","-jar","employee-jdbc-0.0.1-SNAPSHOT.jar"]

From openjdk:17
COPY target/EmployeeAPI2-0.0.1-SNAPSHOT.jar employee-api-docker.jar
CMD ["java","-jar","employee-api-docker.jar"]