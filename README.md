<h1 align="center">Fitness Tracker</h1>
<p align="center">A secure backend platform for tracking body measurements and health analytics</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/MariaDB-003545?style=flat-square&logo=mariadb&logoColor=white">
  <img src="https://img.shields.io/badge/JWT-000000?style=flat-square&logo=jsonwebtokens&logoColor=white">
  <img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white">
</p>

---

## 📖 About

Fitness Tracker is a Spring Boot–based REST API platform that allows users to log body measurements and receive dynamically computed health analytics — such as BMI and body ratios — without storing redundant computed data in the database. It's designed with a clean, layered architecture and secured using JWT-based authentication.

## ✨ Features

- 🔐 Secure JWT-based authentication and authorization
- 🔒 Password encryption using BCrypt
- 📊 Dynamic calculation of BMI, body ratios, and other health metrics (computed on the fly, not stored redundantly)
- 🗄️ Optimized entity relationships using JPA/Hibernate with MariaDB
- 🐳 Fully containerized with Docker for consistent deployment
- 🧪 REST APIs designed, tested, and validated using Postman

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Spring Boot |
| Security | Spring Security, JWT, BCrypt |
| Database | MariaDB |
| ORM | JPA / Hibernate |
| Containerization | Docker |
| API Testing | Postman |
| Version Control | Git & GitHub |

## 🏗️ Architecture

The application follows a layered architecture:

```
Controller Layer   →  Handles REST API endpoints
Service Layer       →  Business logic (BMI, ratio calculations, etc.)
Repository Layer    →  Data access via JPA/Hibernate
Entity Layer         →  MariaDB-mapped domain models
Security Layer       →  JWT filter chain & Spring Security config
```

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven
- MariaDB running locally or via Docker
- Docker (optional, for containerized run)

### Installation

```bash
# Clone the repository
git clone https://github.com/SubinSJohn/Fitnesstracker.git
cd Fitnesstracker

# Configure application.properties with your MariaDB credentials

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

### Running with Docker

```bash
docker build -t fitness-tracker .
docker run -p 8080:8080 fitness-tracker
```

## 📮 API Testing

All endpoints were tested using Postman. Example endpoints include:
- `POST /api/auth/register` — register a new user
- `POST /api/auth/login` — authenticate and receive JWT token
- `POST /api/measurements` — log a new body measurement
- `GET /api/metrics/{userId}` — retrieve computed health metrics

## 📌 Status

✅ Core backend and authentication complete
🔜 Planned: frontend dashboard, historical trend graphs

## 👤 Author

**Subin S John**
[LinkedIn](https://linkedin.com/in/subinsjohn) • [GitHub](https://github.com/SubinSJohn)
