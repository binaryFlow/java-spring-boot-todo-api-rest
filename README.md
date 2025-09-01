# 📝 Todo API (Spring Boot)

A simple REST API built with **Spring Boot** to manage todos.  
This project is designed for learning and practicing **REST, Spring Boot, DTOs, and JPA**.

---

## 🚀 Features
- Create a new todo
- List all todos
- Get todo by ID
- Update todo by ID
- Filter todos by completed status
- Delete a todo

---

## ⚙️ Tech Stack
- Java 17+ (or 11 if you prefer)
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- PostgreSQL (Docker)

---

## ▶️ Getting Started

### 1. Clone the project
```bash
git clone https://github.com/your-username/todo-api.git
cd todo-api
```

### 2. Run the application
Using Maven:
```bash
./mvnw spring-boot:run
```

Or directly from your IDE (**IntelliJ / Eclipse**).

### 3. Access the API
Server will start at:
```
http://localhost:8080
```

---

## 📖 API Endpoints

### Index (API Info)
```
GET /
```
Response:
```json
{
  "name": "Todo API",
  "version": "1.0",
  "description": "A simple REST API to manage todos",
  "endpoints": [
    { "method": "GET", "path": "/api/v1/todos", "description": "List all todos" },
    { "method": "GET", "path": "/api/v1/todos/{id}", "description": "Get todo by ID" },
    { "method": "GET", "path": "/api/v1/todos/filterByDone/{done}", "description": "Filter todos by completed" },
    { "method": "POST", "path": "/api/v1/todos", "description": "Create a new todo" },
    { "method": "DELETE", "path": "/api/v1/todos/{id}", "description": "Delete a todo by ID" }
  ]
}
```

### List all todos
```
GET /api/v1/todos
```

### Get todo by ID
```
GET /api/v1/todos/{id}
```

### Update todo by ID
```
PUT /api/v1/todos/{id}
```

### Filter todos by completion status
```
GET /api/v1/todos/filterByDone/{done}
```
- `done = true` → completed todos  
- `done = false` → pending todos  

### Create a new todo
```
POST /api/v1/todos
```
Request Body:
```json
{
  "title": "Learn Spring Boot",
  "description": "Start with REST API",
  "completed": false
}
```

### Delete a todo
```
DELETE /api/v1/todos/{id}
```

---

## 🗄️ Database

The project uses **Docker and PostgreSQL** by default.  
You can access docker:
```
docker exec -it postgres-spring-boot basH
```
- JDBC URL: `jdbc:postgresql://localhost:5332/project`
- User: `binaryflow`
- Password: `password`

---

## 🧑‍💻 Author
Made with ❤️ while learning Spring Boot.  
