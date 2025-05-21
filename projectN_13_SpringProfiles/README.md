# projectN\_13\_SpringProfiles

A Spring Boot application demonstrating the use of environment-specific profiles and logging configurations using Logback.

## Features

* RESTful API for user management.
* Spring Profiles (`dev`, `test`, `prod`) to handle different environments.
* Logback-based logging configuration with profile-specific settings.
* File-based logging in production.

---

## Technologies Used

* Java 17+
* Spring Boot
* Spring Web
* Spring Boot Actuator
* SLF4J + Logback (default Spring Boot logging)

---

## Getting Started

### Prerequisites

* Java JDK 17 or higher
* Maven
* IDE (e.g., IntelliJ IDEA)

### Clone the Repository

```bash
git clone https://github.com/your-username/projectN_13_SpringProfiles.git
cd projectN_13_SpringProfiles
```

### Set Active Profile

Edit `src/main/resources/application.properties` to choose the profile:

```properties
spring.profiles.active=dev
```

Or set it via command line:

```bash
-Dspring.profiles.active=prod
```

### Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### Get All Users

`GET /users`
Response:

```json
[
  {
    "id": 1,
    "name": "Alice"
  },
  {
    "id": 2,
    "name": "Bob"
  }
]
```

### Add New User

`POST /users`
Request:

```json
{
  "name": "John Doe"
}
```

Response:

```json
{
  "id": 3,
  "name": "John Doe"
}
```

### Delete User by ID

`DELETE /users/{id}`
Response:

```
User deleted.
```

Or

```
User not found.
```

---

## Profile Configurations

### Dev (`application-dev.properties`)

* Port: 8081
* Logging Level: DEBUG (console)

### Test (`application-test.properties`)

* Port: 8082
* Logging Level: INFO (console)

### Prod (`application-prod.properties`)

* Port: 8083
* Logging Level: WARN/ERROR (logs to `logs/app-prod.log`)

---

## Logback Configuration

Defined in `logback-spring.xml`:

* `dev`, `test`: Logs to console.
* `prod`: Logs to `logs/app-prod.log` file with only WARN and ERROR levels.

---

## Example cURL Request

```bash
curl -X POST http://localhost:8081/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice"}'
```

---

## Project Structure

```
projectN_13_SpringProfiles/
└── src/
    └── main/
        ├── java/
        │   └── com/example/projectN_13_SpringProfiles/
        │       ├── model/User.java
        │       ├── controller/UserController.java
        │       └── LoggingDemoApplication.java
        └── resources/
            ├── application.properties
            ├── application-dev.properties
            ├── application-test.properties
            ├── application-prod.properties
            └── logback-spring.xml
```

---

## License

This project is open-source and available under the MIT License.
