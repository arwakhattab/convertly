# 🧮 Convertly – Unit Converter REST API

A Spring Boot–based REST API for converting between various units of measurement, including **Temperature, Length, Weight, and Time**. This project was built for Task 2 of Konecta's full stack internship training program.

---

## 📌 Features
- **Convert Units** – Temperature, Length, Weight, and Time.
- **View Supported Categories** – Get a list of all available conversion categories.
- **View Supported Units** – Get available units for each category.
- **Step-by-Step Formula** – See the formula used for the conversion.
- **Health Check Endpoint** – Confirm the API is up and running.
- **Validation** – Ensures requests contain valid categories, units, and values.

---

## 📂 Project Structure
```
src/
 ├── main/java/com/konecta/internship/convertly
 │   ├── controller      # REST API endpoints
 │   ├── service         # Business logic for conversions
 │   ├── model           # Request & response DTOs
 │   ├── enums           # Unit categories and available units
 │   ├── exception       # Custom exceptions
 │   └── ConvertlyApplication.java
 └── resources/
     ├── application.properties
     └── ...
```

---

## 🚀 API Endpoints

### 1. **Convert Units**
**POST** `/convert`  
**Request Body:**
```json
{
  "category": "temperature",
  "fromUnit": "celsius",
  "toUnit": "fahrenheit",
  "value": 100
}
```

**Response:**
```json
{
  "input": 100.0,
  "result": 212.0,
  "formula": "(100°C x 9/5) + 32 = 212°F",
  "status": "success"
}
```
---

### 2. **List Categories**
**GET** `/categories`  
Response:
```json
["temperature", "length", "weight", "time"]
```

---

### 3. **List Units for a Category**
**GET** `/units?category=temperature`  
Returns the supported units for the given category.

Example request:
```
GET /units?category=temperature
```

Example response:
```json
["celsius", "fahrenheit", "kelvin"]
```

---

### 4. **Sample Payload**
**GET** `/sample-payload`  
Returns a sample request body to help developers test the conversion endpoint.

Example response:
```json
{
  "category": "temperature",
  "fromUnit": "celsius",
  "toUnit": "fahrenheit",
  "value": 100
}
```

---

### 5. **Health Check**
**GET** `/health`  
Response:
```json
{ "status": "Unit Converter API is up and running" }
```

---

## 🛠 Tech Stack
- **Java 21**
- **Spring Boot**
- **Jakarta Validation**
- **Swagger / OpenAPI** (for API documentation)

---

## 📦 Running the Project

### Prerequisites
- Java 21 installed (`java -version`)

### Steps
```bash
# Clone the repository
git clone https://github.com/arwakhattab/convertly.git
cd convertly

# Run the application
./mvnw spring-boot:run
```

The API will start at:  
```
http://localhost:8080
```
