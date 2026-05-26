# BFHL API

A Spring Boot REST API for the Bajaj Finserv Health Campus Hiring qualifier.

## Tech Stack
- Java 17
- Spring Boot 3.3.0
- Maven

## API Endpoint

**POST** `/bfhl`

### Request
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

### Response
```json
{
  "is_success": true,
  "user_id": "pushpraj_singhal_05052005",
  "email": "pushprajsinghal230787@acropolis.in",
  "roll_number": "0827IT231107",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## Running Locally

```bash
mvn clean package
java -jar target/bfhl-api-0.0.1-SNAPSHOT.jar
```
