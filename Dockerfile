
FROM openjdk:8
COPY . /usr/src/authornameservice
WORKDIR /usr/src/authornameservice
RUN mkdir dist
RUN javac -d dist -sourcepath src src/author/AuthorNameService.java
CMD java -cp dist author.AuthorNameService names.txt

