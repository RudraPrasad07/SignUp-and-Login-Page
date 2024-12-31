# <div align="center">User Authentication and Registration </div>

## Description
*An application for secure user authentication and registration, built with Spring Boot and Spring Security. It provides features like user signup, login, and token-based authentication using JWT for seamless and secure access to protected resources.*

## Features
- **User Registration:** Allows users to sign up with validation checks for unique email and phone number, and password strength.
- **User Login:** Authenticates users with encrypted passwords and generates JWT tokens for session management.
- **Password Encryption:** Uses BCrypt to securely store user passwords.
- **JWT Integration:** Issues JSON Web Tokens to authenticated users for secure API access.
- **Data Validation:** Ensures data integrity and compliance with validation rules for user inputs.
- **Error Handling:** Comprehensive error responses for scenarios like invalid login credentials, duplicate entries, or invalid input.
- **Spring Security:** Secures application endpoints and provides robust request validation.

## Tech Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Security:** Spring Security, JWT
- **Database:** MySQL
- **Build Tool:** Maven
- **ORM:** Hibernate (JPA)
- **Dependency Management:** Lombok

## Getting Started

### 1) Prerequisites
1. **Java:** Ensure JDK 11 or later is installed.
2. **Maven:** Install Maven to build the project. Download it from the [Apache Maven website](https://maven.apache.org/download.cgi).
3. **MySQL:** Set up MySQL and create a database for the application.
4. **IDE:** Use a Java IDE like IntelliJ IDEA, Eclipse, or VSCode.

### 2) Setup
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/YourGitHubUsername/UserAuthApp.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd UserAuthApp
   ```
3. **Configure Database:**
   Update `src/main/resources/application.properties` with your MySQL database details:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
4. **Build the Project:**
   ```bash
   mvn clean install
   ```
5. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```
6. **Access API Endpoints:** Use tools like Postman or cURL to test the endpoints.

## Running the Application
### Key Endpoints
#### **LoginController**
- **POST /details/login:** Authenticates the user and generates a JWT token upon successful login.

#### **UserController**
- **POST /user/save:** Registers a new user after validation, encrypts the password, and returns a JWT token.

## Example API Request
- **Endpoint:** POST `/user/save`
- **Body:**
  ```json
  {
      "userName": "JohnDoe",
      "email": "john.doe@example.com",
      "name": "John",
      "lastName": "Doe",
      "phoneNumber": "1234567890",
      "password": "password123",
      "confirmPassword": "password123"
  }
  ```

### Response:
- **Success:**
  ```json
  {
      "status": 201,
      "message": "User Saved Successfully In The Database",
      "data": "<JWT Token>",
      "timestamp": "2024-12-31T10:00:00"
  }
  ```
- **Error:**
  ```json
  {
      "status": 400,
      "message": "Email already exists...",
      "data": null,
      "timestamp": "2024-12-31T10:00:00"
  }
  ```

## Testing
Run tests using Maven:
```bash
mvn test
```

## Contributing
Feel free to contribute by submitting issues or pull requests to enhance functionality or resolve bugs.

<br>
<div align="center">

***Thank You for exploring this project! 🙌***

</div>
