# 🎬 Movie Ticket Booking System

A Spring Boot based backend application for booking movie tickets.
Users can view shows, select seats, and book tickets.

---

## 🚀 Features

- Create Movies
- Create Theatres
- Create Shows
- Auto-generate Seats for Shows
- Book Multiple Seats
- Prevent Double Booking
- REST APIs with JSON responses

---

## 🏗 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL / H2
- Maven
- REST APIs

---

## 📂 Project Structure

```
src/main/java/com/example/moviebooking
│
├── controller
│   ├── MovieController.java
│   ├── ShowController.java
│   └── BookingController.java
│
├── service
│   ├── MovieService.java
│   ├── ShowService.java
│   └── BookingService.java
│
├── repository
│   ├── MovieRepository.java
│   ├── ShowRepository.java
│   ├── SeatRepository.java
│   └── BookingRepository.java
│
├── entity
│   ├── Movie.java
│   ├── Theatre.java
│   ├── Show.java
│   ├── Seat.java
│   └── Booking.java
│
└── dto
    └── BookSeatRequest.java
```

---

## 🧩 Entities

### Movie
- id
- title
- duration
- language

### Theatre
- id
- name
- location

### Show
- id
- movie
- theatre
- showDate
- showTime

### Seat
- id
- seatNumber
- booked
- price
- show

### Booking
- id
- userId
- show
- seats
- totalAmount

---

## 📌 API Endpoints

### Create Movie
POST `/movies`

### Create Show
POST `/shows`

### Book Seats
POST `/booking`

Example Request:

```json
{
  "showId": 1,
  "seatIds": [10, 11],
  "userId": "123"
}
```

---

## ⚙️ How To Run

1. Clone the repository:
```
git clone https://github.com/babug19/movie-ticket-system.git
```

2. Navigate to project:
```
cd movie-ticket-system
```

3. Configure database in `application.properties`

4. Run:
```
mvn spring-boot:run
```

---

## 🔐 Future Improvements

- Seat locking (Pessimistic Locking)
- Payment Integration
- JWT Authentication
- Admin Dashboard
- Docker Support
- CI/CD Pipeline

---

## 👨‍💻 Author

Your Name
