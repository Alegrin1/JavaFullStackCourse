# Library Management System API

A RESTful API built with Spring Boot, MySQL, and Hibernate to manage a library's collection of books.

## Features

* Add, retrieve, update, and delete books.
* Use Hibernate for ORM and Spring Data JPA for data access.
* Validate inputs and handle exceptions.

---

## 🛠️ Technologies Used

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

---

## 🚀 Getting Started

### Prerequisites

* Java JDK 17 or higher
* Maven
* MySQL
* IDE (e.g., IntelliJ IDEA, Eclipse)

### 1. Clone the Repository

```bash
git clone https://github.com/Alegrin1/JavaFullStackCourse/new/main/projectN_12_BuildingRESTfulAPIs.git
cd library-management-api
```

### 2. Set Up MySQL Database

* Start MySQL server.
* Create a database:

```sql
CREATE DATABASE library_management;
```

### 3. Configure Application Properties

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 4. Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will run on `http://localhost:8080`

---

## 📘 API Endpoints

### Add a Book

`POST /books`

```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedDate": "2018-01-06"
}
```

### Get All Books

`GET /books`

### Get a Book by ID

`GET /books/{id}`

### Update a Book

`PUT /books/{id}`

```json
{
  "title": "Effective Java 3rd Edition",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedDate": "2018-01-06"
}
```

### Delete a Book

`DELETE /books/{id}`

---

## 🧪 Testing

You can test the endpoints using:

* **Postman**
* **cURL**

#### Example cURL Request:

```bash
curl -X POST http://localhost:8080/books \
  -H "Content-Type: application/json" \
  -d '{
        "title": "Clean Code",
        "author": "Robert C. Martin",
        "isbn": "9780132350884",
        "publishedDate": "2008-08-01"
      }'
```

---

## 🧩 Project Structure

```
src/
 └── main/
     ├── java/
     │    └── com/example/projectN_12_BuildingRESTfulAPIs/
     │         ├── model/Book.java
     │         ├── repository/BookRepository.java
     │         ├── controller/BookController.java
     │         └── LibraryApplication.java
     └── resources/
          └── application.properties
```

---

## 📄 License

This project is open-source and available under the MIT License.
