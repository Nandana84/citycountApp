# City Count Application - Backend (Spring Boot)

This is the backend REST API for the **City Count Application**, built with **Spring Boot**. It provides an endpoint to return the number of cities that start with a given letter. The service can use an external API or local data using `RestTemplate`.

## 🛠️ Tech Stack

- Java 17+ (or your preferred version)
- Spring Boot 3+
- Spring Web
- RestTemplate (to call external APIs or fetch data)
- Optional: Spring Validation, Lombok

## 📦 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/Nandana84/citycountApp.git
   cd cityCountApp/


Build the application
./mvn clean install

Run the application
./mvn spring-boot:run

The server will be running at:
http://localhost:8080


Sample Request:
http://localhost:8080/api/citycount?startsWith=z

Response would be integer showing count of cities starting with the input letter
