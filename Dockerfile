FROM maven:3.3.9-jdk-8

RUN mkdir -p /opt/app
WORKDIR /opt/app

# install dependencies
COPY pom.xml /opt/app/
RUN mvn install

# rest of the project
COPY src /opt/app/src
RUN mvn package

# local port
EXPOSE 8080

# run service
CMD ["mvn", "exec:java"]
