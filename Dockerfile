FROM maven:3.6.3-jdk-11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]