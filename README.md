# Spring boot Hazelcast
## Installation
* To check the Hazelcast cache solution working properly, we should run two instance of project with the following sections:
* Before running the application, the following commands must be executed in the terminal from the project root directory:
  1. build project and run main instance of project:
    ```
    mvn clean install
    mvn spring-boot:run
    ```
  2. open new command line, then run the second instance of project:
    ```
    mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=2023"
    ```

## Getting Started
* we can have a share cache storage space between instances because of hazelcast mechanism, but each instance of the project has its own H2 embedded database!
* To make sure about this story we should just invoke following APIs:

1. call `getAllEmployees` of main instance for caching employees data in hazelcast:
   ```
   curl -X 'GET' \
     'http://localhost:2022/api/v1/employee' \
     -H 'accept: */*'
   ```
2. call `saveEmployees` of main instance for put new record in cache storage:
   ```
   curl -X 'POST' \
   'http://localhost:2022/api/v1/employee/all' \
   -H 'accept: */*' \
   -H 'Content-Type: application/json' \
   -d '[{
     "name": "John Doe"
    }]'
   ```
3. call `getAllEmployees` of second instance:
   ```
   curl -X 'GET' \
     'http://localhost:2023/api/v1/employee' \
     -H 'accept: */*'
   ```
* So if the result of the 3rd section returns 5 records the caching mechanism works properly!

