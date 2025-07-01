#  Student Management System - Spring Boot + JWT Security

This is a secure RESTful Student Management System built using **Spring Boot**, **JWT (JSON Web Token)** for authentication, and **MySQL** as the database.

---

# Features

-  JWT-based login and authentication
-  CRUD operations on student data
-  Protected API endpoints
-  Spring Boot layered architecture
-  MySQL database integration

---

## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Security
- JWT (io.jsonwebtoken)
- MySQL
- Lombok
- Postman (for API testing)

---

##  Project Structure
src
└── main
├── java
│ └── com.example.sampledemoproject
│ ├── Application
│ │ ├── controllers
│ │ ├── dto
│ │ │ ├── request
│ │ │ └── response
│ │ └── service
│ └── Configuration
└── resources
└── application.properties

yaml
Copy
Edit
## JWT Authentication Flow
1. **Login** using `/auth/login` with username & password
2. Receive a **JWT token**
3. Include the token in request headers to access protected endpoints:

 
![image](https://github.com/user-attachments/assets/1b6dea70-2439-4c59-a3c6-e265ed2d76df)


##  JWT Token
![image](https://github.com/user-attachments/assets/bffda9fb-30d6-4eae-a2b1-c0eeec848e30)

##  POST New Student
![image](https://github.com/user-attachments/assets/44c86a42-fb5d-48ca-8ad7-a9677356a0a8)


##  GET Student by ID (with @RequestParam)
![image](https://github.com/user-attachments/assets/7d976674-c943-49d8-ad91-689005f6ec7b)


## Notes
Token lifetime is set to 10 hours

/auth/login and /auth/refresh are publicly accessible

All /student/** endpoints are protected




