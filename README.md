# BankingApplication

`A simple banking application that allows users to perform transactions such as deposits and withdrawals.
Users register themselves and then log in using basic authentication.
Users can view the current bank balance and transaction details.`

---
## Requirements

- Java 11
- Spring Boot
- Maven
- H2 Database

---

## IDE 
>IntelliJ Idea || STS || Eclipse

---

## Framework

For this Banking Application, we are using Spring Boot framework of Java.

---

## Dependencies

In this project we have used following dependencies :-

- Spring web
- H2 database
- Lombok
- Spring Data JPA
- Spring Security

---

## Execution

- Clone the repository on you local
- Execute 'BankingAppApplication.java' file
- To access register yourself, login and perform the transaction :- 
  - Register a new user:
    - URL : POST - /api/authenticate/register
    - Request Body : User registration details
  - Login:
    - URL : POST - /api/authenticate/login
    - Request Body : User login credentials
    - Response Body : JWT token for authentication
  - Get current user's account balance:
    - URL : GET - /api/authenticate
  - Perform a deposit:
    - URL : POST - /api/transactions/deposit
    - Request Body : Deposit details (amount)
  - Perform a withdrawal:
    - URL : POST - /api/transactions/withdraw
    - Request Body : Withdrawal details (amount)
