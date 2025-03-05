# Gagebu Backend

Gagebu Backend is the server-side component of a personal finance management application, built using **Java Spring Boot**. It provides RESTful APIs for managing financial transactions. While currently running locally, the final deployment is planned for **AWS EC2** (previously deployed but paused due to cost concerns). The project follows a structured approach with **controller**, **service**, **entity**, **DTO**, and **repository** layers, and supports complex queries using **Specification**. Unit tests are implemented using Spring Boot's built-in testing capabilities.

## 📚 Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)![AWS EC2](https://img.shields.io/badge/AWS_EC2-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white)

## 💡 Features

### **RESTful API Endpoints**

- **POST**:
  - `/transactions/addTransaction`: Add a new transaction.
- **GET**:
  - `/transactions/getAllTransactions`: Retrieve all transactions with optional filtering (`sortBy`, `direction`, `date`, `category`, `amount`, `currency`, `transactionType`) and sorting.
  - `/transactions/{id}`: Retrieve a transaction by its ID.
  - `/transactions/category-wise-amount`: Get the total amount spent by category (with optional `date` filtering).
- **PATCH**:
  - `/transactions/updateTransaction`: Update an existing transaction.
- **DELETE**:
  - `/transactions/deleteTransaction`: Delete a transaction.

### **Project Structure**

- **Controller**: Handles incoming HTTP requests.
- **Service**: Implements business logic.
- **Entity**: Defines the data model.
- **DTO**: Data Transfer Objects for request/response handling.
- **Repository**: Manages database operations, including complex queries using **Specification**.

### **Testing**

- Unit tests are implemented using **Spring Boot's testing framework**.

## Key Learnings

- Built a RESTful API using Java Spring Boot.
- Implemented complex query handling using Specification.
- Structured the project into controller, service, entity, DTO, and repository layers for maintainability.
- Gained experience in writing unit tests using Spring Boot's testing framework.
- Explored deployment on AWS EC2 (currently paused due to cost concerns).

## Future Plans

- Deploy the application on AWS EC2 once cost-effective solutions are identified.
- Add more features such as user authentication, budget tracking, and reporting.
