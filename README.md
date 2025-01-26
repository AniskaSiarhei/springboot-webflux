# Reactive Employee Management System

▌Description

This is a web application called "Reactive Employee Management System," developed in Java using Spring Boot, Spring WebFlux, and Spring Data MongoDB. The application provides a REST API for managing employee data in a reactive style.

▌Features

The application provides the following features:

•  Create Employee: Adds a new employee to the system.
•  Get Employee: Retrieves information about an employee by their ID.
•  Get All Employees: Retrieves a list of all employees.
•  Update Employee: Updates the information of an existing employee.
•  Delete Employee: Deletes an employee from the system by their ID.

All operations are performed asynchronously and in a non-blocking manner, ensuring high performance and responsiveness.

▌Technologies

The following technologies were used in the project:

•  Java 17: The primary programming language.
•  Spring Boot: A framework for rapid web application development.
•  Spring WebFlux: A framework for building reactive web applications.
•  Spring Data MongoDB: For interaction with the MongoDB database.
•  MongoDB: A NoSQL database for storing application data.
•  Lombok: A library to reduce boilerplate code.
•  Reactor: A library for working with reactive data streams.
•  Maven: A tool for project and dependency management.
•  JUnit 5
•  WebTestClient

▌How to Run

1. Clone the repository:
  
```
bash
    git clone <your-repository-link>
```

2. Set up MongoDB:
  •  Install MongoDB and ensure it is running.
  •  If necessary, modify the MongoDB URI in the application.properties file:
```
properties
    spring.data.mongodb.uri=mongodb://localhost:27017/ems
```
3. Build the project:
```
bash
    mvn clean install
```
4. Run the application:
```
bash
    mvn spring-boot:run
```
5. Test the API: Use a REST client such as Postman to test the API endpoints.

▌REST API Endpoints

▌1. Create Employee
•  URL: /api/employees
•  Method: POST
•  Request Body:
```
json
  {
   "firstName": "John",
   "lastName": "Doe",
   "email": "john.doe@example.com"
  }
```
*   **Response:**
```
json
  {
   "id": "unique-id",
   "firstName": "John",
   "lastName": "Doe",
   "email": "john.doe@example.com"
  }
```
•  Status Code: 201 Created

▌2. Get Employee
•  URL: /api/employees/{id}
•  Method: GET
•  Path Variable: id (employee ID)
•  Response:
```
json
   {
    "id": "unique-id",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
   }
```
•  Status Code: 200 OK

▌3. Get All Employees
•  URL: /api/employees
•  Method: GET
• Response:
```
json
  [
    {
     "id": "unique-id-1",
     "firstName": "John",
     "lastName": "Doe",
     "email": "john.doe@example.com"
     },
     {
     "id": "unique-id-2",
      "firstName": "Jane",
      "lastName": "Smith",
      "email": "jane.smith@example.com"
     }
  ]
```
•  Status Code: 200 OK

▌4. Update Employee
•  URL: /api/employees/{id}
•  Method: PUT
•  Path Variable: id (employee ID)
• Request Body:
```
json
  {
   "firstName": "Updated John",
   "lastName": "Updated Doe",
   "email": "updated.john.doe@example.com"
  }
```
•  Response:
```
json
  {
   "id": "unique-id",
   "firstName": "Updated John",
   "lastName": "Updated Doe",
   "email": "updated.john.doe@example.com"
   }
```
•  Status Code: 200 OK

▌5. Delete Employee
•  URL: /api/employees/{id}
•  Method: DELETE
•  Path Variable: id (employee ID)
•  Response: _empty response_
•  Status Code: 204 No Content

Testing
•   Integration tests are located in src/test/java/com/example/springboot/controller/EmployeeControllerIntegrationTest.java
•   To run the integration tests, use the following Maven command:  
    ```
    ./mvnw test
    ```   

