# 🚀 IMF Gadget API - Phoenix: IMF Gadget API Development Challenge

### 🛠 Built with:
![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?style=for-the-badge)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-orange?style=for-the-badge)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge)
![Docker](https://img.shields.io/badge/Docker-Container-blue?style=for-the-badge)
![JWT](https://img.shields.io/badge/JWT-Auth-yellow?style=for-the-badge)

## 📝 Project Overview
The **IMF Gadget API** is a secure inventory management system for tracking high-tech spy gadgets.  
This API allows users to:
- 📌 Manage gadget inventory
- 🔐 Secure API access using **JWT authentication**
- 🚀 Deploy using **Docker**
- ✅ Filter gadgets by status
- 💥 Trigger **self-destruct** sequences

---

## 🔗 API Documentation
📜 [View API Documentation](https://documenter.getpostman.com/view/35351114/2sAYk7R3fD)

---

## 🔑 Authentication & Authorization
This API uses **JWT Authentication** for secure access.  
1️⃣ **Generate Token:** Use `/auth/login` to get a JWT token.  
2️⃣ **Use Token:** Pass it in the `Authorization` header as `Bearer <token>` in API requests.  

---

## 📌 API Endpoints

### 🛠 Gadget Inventory Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| **GET** | `/gadgets` | Fetch all gadgets with random success probability |
| **GET** | `/gadgets?status={status}` | Get gadgets filtered by status |
| **POST** | `/gadgets` | Add a new gadget (auto-generates a unique codename) |
| **PATCH** | `/gadgets/{id}` | Update an existing gadget |
| **DELETE** | `/gadgets/{id}` | Mark a gadget as "Decommissioned" instead of deleting |

### 💥 Self-Destruct Mechanism
| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/gadgets/{id}/self-destruct` | Triggers self-destruct sequence with a confirmation code |

### 🔑 Authentication
| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/auth/login` | Get JWT token for API access |

---

## 🏗 Running the Project with Docker
Ensure **Docker** and **Docker Compose** are installed. Then run:

```
docker-compose up
```

### 🛠️ Build and Run the Application
This will:
- Build and run the application
- Start a PostgreSQL database container
- Expose the API on port **8080**

To stop the containers:
```
docker-compose down
```

### ✨ Bonus Features Implemented
- ✅ JWT Authentication for securing the API
- ✅ Deployed on a cloud platform
- ✅ Filter gadgets by status using GET /gadgets?status={status}

