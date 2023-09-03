
#  Task Manager

Task Manager is a CRUD back-end application that shows how spring boot can be implemented.

## 🛠 Minimum Requirements
Java 8+

Maven 3

## Installation

1. Clone the repository:
```bash
git clone https://github.com/leoconti/task-manager.git
```

2. Install dependencies with Maven
```bash
mvn clean install
```

## Usage

1. Start the application
2. You can access the endpoints on http://localhost:8080/swagger-ui/index.html#/
3. If you prefer, there is an Insomnia file to use in the helper folder.

## Endpoints

```bash
GET
/task/{id}

PUT
/task/{id}

DELETE
/task/{id}

GET
/task

POST
/task
```

## Database

H2 database in-memory