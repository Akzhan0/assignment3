# Assignment 3 — Java JDBC + OOP Project

## About Project
This is a simple Java console project created for Assignment 3.  
The goal of the project is to show how to work with:
- Java OOP (inheritance, abstract classes, interfaces)
- PostgreSQL database
- JDBC with PreparedStatement
- Exception handling
- Layered architecture

The project is written step by step as a learning project.

---

## Technologies Used
- Java
- PostgreSQL
- JDBC (DriverManager)
- IntelliJ IDEA

---

## Database
Database name: `simpledb`

### Table `users`
Fields:
- id (SERIAL, primary key)
- name (VARCHAR)
- surname (VARCHAR)
- gender (VARCHAR)

Rules:
- Combination of `name + surname` must be unique

### Table `profiles`
Fields:
- id (SERIAL, primary key)
- user_id (foreign key → users.id)
- bio (VARCHAR)
- age (INT)

---

## Project Structure
- `utils` — database connection
- `repository` — JDBC CRUD logic
- `service` — validation and business logic
- `exception` — custom exceptions
- `model` — entity classes
- `oop` — OOP demonstration (abstract class, interfaces, polymorphism)
- `Main` — program entry point

---

## JDBC and CRUD
The project uses JDBC with:
- `DriverManager`
- `PreparedStatement`
- No `Statement`

CRUD operations demonstrated:
- Create user
- Read all users
- Get user by id
- Update user
- Delete user

---

## Exception Handling
Custom exceptions are used:
- InvalidInputException — wrong input data
- DuplicateResourceException — duplicate user
- ResourceNotFoundException — object not found
- DatabaseOperationException — database error

All exceptions are handled in `Main`.

---

## OOP Demonstration
OOP requirements are demonstrated in package `oop`:
- `BaseEntity` — abstract class
- `MovieItem` and `SeriesItem` — subclasses
- `Validatable` and `Scorable` — interfaces
- `Playlist` — composition (contains list of BaseEntity)
- Polymorphism shown using BaseEntity references

---

## How to Run
1. Start PostgreSQL
2. Make sure database `simpledb` exists
3. Run `Main.java`
4. Check console output

---

## What This Project Shows
- Working JDBC connection
- CRUD operations
- Validation and error handling
- Object-oriented programming principles
- Clean and simple project structure

---

## Author
AKZHAN
# Assignment 3 — Java JDBC + OOP Project

## About Project
This is a simple Java console project created for Assignment 3.  
The goal of the project is to show how to work with:
- Java OOP (inheritance, abstract classes, interfaces)
- PostgreSQL database
- JDBC with PreparedStatement
- Exception handling
- Layered architecture

The project is written step by step as a learning project.

---

## Technologies Used
- Java
- PostgreSQL
- JDBC (DriverManager)
- IntelliJ IDEA

---

## Database
Database name: `simpledb`

### Table `users`
Fields:
- id (SERIAL, primary key)
- name (VARCHAR)
- surname (VARCHAR)
- gender (VARCHAR)

Rules:
- Combination of `name + surname` must be unique

### Table `profiles`
Fields:
- id (SERIAL, primary key)
- user_id (foreign key → users.id)
- bio (VARCHAR)
- age (INT)

---

## Project Structure
- `utils` — database connection
- `repository` — JDBC CRUD logic
- `service` — validation and business logic
- `exception` — custom exceptions
- `model` — entity classes
- `oop` — OOP demonstration (abstract class, interfaces, polymorphism)
- `Main` — program entry point

---

## JDBC and CRUD
The project uses JDBC with:
- `DriverManager`
- `PreparedStatement`
- No `Statement`

CRUD operations demonstrated:
- Create user
- Read all users
- Get user by id
- Update user
- Delete user

---

## Exception Handling
Custom exceptions are used:
- InvalidInputException — wrong input data
- DuplicateResourceException — duplicate user
- ResourceNotFoundException — object not found
- DatabaseOperationException — database error

All exceptions are handled in `Main`.

---

## OOP Demonstration
OOP requirements are demonstrated in package `oop`:
- `BaseEntity` — abstract class
- `MovieItem` and `SeriesItem` — subclasses
- `Validatable` and `Scorable` — interfaces
- `Playlist` — composition (contains list of BaseEntity)
- Polymorphism shown using BaseEntity references

---

## How to Run
1. Start PostgreSQL
2. Make sure database `simpledb` exists
3. Run `Main.java`
4. Check console output

---

## What This Project Shows
- Working JDBC connection
- CRUD operations
- Validation and error handling
- Object-oriented programming principles
- Clean and simple project structure

---

---

## What I Learned
In this project I learned:
- how to connect Java to database
- how to use JDBC
- how to write CRUD operations
- how to use OOP in practice
- how to handle errors

---

## Author
AKZHAN

