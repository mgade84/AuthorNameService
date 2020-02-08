# Author Name Service
Little REST service for parsing author names.
The service parses one or more names in a string separated by semicolon and returns JSON in the format:

```javascript
{
    "firstNames": "John",
    "lastName": "Doe"
}
```

or a list of the above.

Service can be run with either Maven or Docker

## Build and run with Maven

>   mvn clean compile exec:java

## Build and run with Docker

>   docker build --tag=authornameservice .

>   docker run -p 8080:8080 -t -i authornameservice:latest

## Using the service

Parsing single author name

>   curl -X POST -H"Content-Type: application/json" -d 'John Doe' http://localhost:8080/author

Parsing multiple author name

>   curl -X POST -H"Content-Type: application/json" -d 'Hans-Christian Jensen;Doe, John;Peter H. Kristensen' http://localhost:8080/multiauthor

