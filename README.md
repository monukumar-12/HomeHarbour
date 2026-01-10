# HomeHarbour – Airbnb-Like Backend Application (Spring Boot)

## Project Overview

**HomeHarbour** is a full-fledged backend application inspired by Airbnb, designed to manage hotel/room listings, user bookings, inventory availability, and secure online payments. The project is built using **Spring Boot** and follows clean layered architecture with **Controller → Service → Repository** separation. It demonstrates real-world backend concepts such as authentication & authorization, transactional booking flow, inventory management, exception handling, and third-party payment gateway integration.

This project focuses entirely on the **backend** and exposes RESTful APIs that can be consumed by any frontend (Web / Mobile).

---

## Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **Spring Security (JWT-based authentication)**
* **Stripe Payment Gateway**
* **MySQL / PostgreSQL** (any relational DB)
* **Maven**
* **REST APIs (JSON)**
* **ModelMapper / Custom Mapper**

---

## Architecture & Package Structure

The project follows a **modular and scalable architecture**.

### 1. Controller Layer (`controller`)

Handles incoming HTTP requests and exposes REST APIs.

* `HotelController` – Manage hotel CRUD operations
* `HotelBrowseController` – Search & filter hotels
* `HotelBookingController` – Booking-related APIs
* `RoomAdminController` – Room & inventory management (admin)

Controllers validate requests, delegate logic to services, and return standardized API responses.

---

### 2. Service Layer (`service`)

Contains core business logic. Each service has an interface and implementation.

* `HotelService` / `HotelServiceImplementation`
* `RoomService` / `RoomServiceImplementation`
* `BookingService` / `BookingServiceImplementation`
* `InventoryService` / `InventoryServiceImplementation`

Responsibilities:

* Booking availability checks
* Inventory locking & release
* Price calculation
* Payment verification
* Transaction management

---

### 3. Repository Layer (`repository`)

Uses **Spring Data JPA** to interact with the database.

* `HotelRepository`
* `RoomRepository`
* `BookingRepository`
* `GuestRepository`
* `InventoryRepository`

Provides CRUD operations and custom queries using JPQL / method naming conventions.

---

### 4. Entity Layer (`entity`)

Defines database tables using JPA annotations.

Key entities:

* `User` – Application users (Admin / Guest)
* `Hotel` – Hotel details
* `Room` – Room type, price, capacity
* `Inventory` – Date-wise room availability
* `Booking` – Booking records
* `Guest` – Guest details
* `Payment` – Payment transaction data

Includes enums such as:

* `BookingStatus` (PENDING, CONFIRMED, CANCELLED)
* `PaymentStatus` (INITIATED, SUCCESS, FAILED)

---

### 5. DTO Layer (`dto`)

Used to decouple API contracts from database entities.

Examples:

* `HotelDto`
* `RoomDto`
* `BookingDto`
* `HotelSearchRequest`
* `BookingRequest`

Ensures clean data transfer and prevents over-exposing entity structure.

---

### 6. Exception Handling (`exception` & `advices`)

Centralized exception handling using `@ControllerAdvice`.

* `ResourceNotFoundException`
* `GlobalExceptionHandler`
* `ApiError`
* `ApiResponse`

Provides consistent error responses across the application.

---

### 7. Security Layer (Spring Security + JWT)

* JWT-based authentication
* Role-based authorization (ADMIN / USER)
* Secure endpoints
* Stateless session management

Ensures secure access to booking, admin, and payment APIs.

---

## Core Functionalities

### 1. User Management

* User registration & login
* Role-based access control
* Secure JWT authentication

### 2. Hotel & Room Management

* Add/update/delete hotels
* Room creation and pricing
* Room capacity & amenities handling

### 3. Search & Browse

* Search hotels by location
* Filter by date, price, availability
* Optimized availability check using inventory table

### 4. Booking System

* Real-time availability check
* Booking creation & confirmation
* Booking status lifecycle
* Transactional booking flow

### 5. Inventory Management

* Date-wise room availability
* Prevents over-booking
* Inventory locking during booking

### 6. Payment Integration (Stripe)

* Stripe payment intent creation
* Secure payment confirmation
* Payment status tracking
* Booking confirmation after successful payment

### 7. Error Handling & Validation

* Centralized exception handling
* Clean API error responses
* Request validation

---

## Key Highlights

* Clean layered architecture
* Interface-based service design
* Industry-standard backend practices
* Secure payment flow
* Scalable & production-ready design

---

## Use Cases

* Airbnb-like booking backend
* Hotel reservation systems
* Learning enterprise-level Spring Boot development
* Resume-ready backend project

---

## Future Enhancements

* Reviews & ratings
* Cancellation & refund flow
* Dynamic pricing
* Admin dashboard APIs
* Caching with Redis

---

## Conclusion

HomeHarbour demonstrates a **complete real-world backend system** with authentication, booking, inventory management, and payment processing. It closely mirrors production-grade applications like Airbnb and showcases strong backend engineering skills using Spring Boot and JPA.
