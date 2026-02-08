# Freelance Java Backend Task - Item Management REST API

## Project Overview

This is a Spring Boot REST API application created as part of a sample task for a Freelance Java Developer opportunity.

The application provides REST endpoints to manage a collection of items (similar to products in an e-commerce application).  
It supports adding a new item and fetching an item by its ID.

This project uses an in-memory data store (`ArrayList`), so no database is required.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Validation
- ModelMapper
- Lombok
- Maven
- Docker
- Render (Deployment)

---

## Project Structure

```
src/main/java/com/example/backendTask

controller/
    ItemController.java

service/
    ItemService.java
    ItemServiceImpl.java

DTO/
    ItemRequestDTO.java
    ItemResponseDTO.java

Model/
    Item.java

exceptions/
    APIException.java
    ResourceNotFoundException.java

config/
    ModelMapperConfig.java
```

---

## Layers Explanation

### Controller Layer

Handles incoming HTTP requests and returns responses.

### Service Layer

Contains business logic and manages the in-memory item list.

### DTO Layer

Used to separate request and response data from the internal model.

### Model Layer

Represents the actual Item object stored in memory.

### Exception Layer

Handles custom exceptions such as item not found or duplicate item name.

### Configuration Layer

Contains ModelMapper bean configuration.

---

## In-Memory Data Storage

This project uses an `ArrayList` to store items temporarily during runtime.

No database is used.

---

## API Endpoints

### Add a New Item

- **Method:** POST  
- **Endpoint:** `/api/items`

**Sample Request Body:**

```json
{
  "name": "Laptop",
  "description": "Dell i5 Laptop",
  "price": 55000,
  "quantity": 2
}
```

---

### Get Item by ID

- **Method:** GET  
- **Endpoint:** `/api/items/getitem/{id}`  

**Example:**

```
/api/items/getitem/1
```

---

## Input Validation

Validation is implemented using Spring Validation annotations in `ItemRequestDTO`.

Example validations:

- name should not be blank
- description should not be blank
- price must be greater than 0
- quantity must be at least 1

---

## ModelMapper Usage

ModelMapper is used to map between:

- `ItemRequestDTO` to `Item`
- `Item` to `ItemResponseDTO`

This reduces manual mapping code and keeps the service layer clean.

---

## How to Run Locally

### Step 1: Clone Repository

```bash
git clone https://github.com/Cheluri-AshokReddy/freelancejavabackendtask.git
```

### Step 2: Go to Project Folder

```bash
cd freelancejavabackendtask
```

### Step 3: Run the Application

```bash
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

## Deployment

The project is deployed on Render using Docker.

Live URL:

```
https://freelancejavabackendtask.onrender.com
```

---

## How to Use APIs on Render (Live Deployment)

### Base URL

```
https://freelancejavabackendtask.onrender.com
```

---

### Add a New Item (Render)

- **Method:** POST  
- **Endpoint:**

```
https://freelancejavabackendtask.onrender.com/api/items
```

**Sample Request Body:**

```json
{
  "name": "Smart Watch",
  "description": "Apple Watch Series 9",
  "price": 45000,
  "quantity": 7
}
```

---

### Get Item by ID (Render)

- **Method:** GET  
- **Endpoint:**

```
https://freelancejavabackendtask.onrender.com/api/items/getitem/{id}
```

**Example:**

```
https://freelancejavabackendtask.onrender.com/api/items/getitem/1
```

---

## Task Requirements Covered

- Item model created with required fields
- In-memory data storage implemented using ArrayList
- REST API endpoints implemented (Add item, Get item by ID)
- Input validation added
- Documentation provided in README
- Hosted on Render with live URL

---

## Author

**Ashok Kumar Reddy Cheluri**  
GitHub: https://github.com/Cheluri-AshokReddy/freelancejavabackendtask
