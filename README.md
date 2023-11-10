# JavaFX CRUD with PostgreSQL database

A JavaFX CRUD application providing simple registration form that interacts with a PostgreSQL database. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on a database table.

## Features

![1](https://github.com/jjwaldon/registration-form-crud/assets/147337604/94777c53-1d73-4601-9f64-5301fefe59f5)

- **Create:** Add new records to the database.
- **Read:** Display existing records in a table.
- **Update:** Modify information for existing records.
- **Delete:** Remove records from the database.

## Technologies Used

- JavaFX: A Java library used for building desktop applications.
- PostgreSQL: A powerful open-source relational database system.
- JDBC: Java Database Connectivity for connecting Java applications to databases.

## Getting Started

### Prerequisites

- JDK (Java Development Kit) installed.
- PostgreSQL database server installed and running.

### Setting up the Database

Import the database schema using the provided `database_schema.sql` file into PostgreSQL server

### Configuring Database Connection

Update the connection details in the `DatabaseConnector` class:

```java
connector = DriverManager.getConnection("jdbc:postgresql://localhost/university","YOUR_USERNAME","YOUR_PASSWORD");
```

### Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/jjwaldon/registration-form-crud.git
   ```

2. Build and run the `AppView.java` class.

## Project Structure

  - `AppView.java`: View logic of the application.
  - `AppController.java`: Controller class for the JavaFX application.
  - `UniModel.java`: Model for the CRUD operations
  - `DatabaseConnector.java`: Class for establishing a connection to the PostgreSQL database.
  - `database_schema.sql`: SQL file containing the database schema.

  
