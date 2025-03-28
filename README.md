# Spring Boot Hit Counter


This repository contains the Spring Boot version of the Hit Counter application, converted from the original Python Flask application.

## Contents

This application is a simple REST API service that counts the number of hits to a URL. It demonstrates a basic Spring Boot application structure with:

- RESTful API endpoints
- Service layer
- Model objects
- Unit tests
- OpenAPI/Swagger documentation
- Docker containerization

## Getting Started

### Prerequisites

- JDK 21
- Maven 3.8+
- Docker (optional)

### Running the Application

#### Using Maven

```bash
mvn spring-boot:run
```

#### Using Docker

```bash
# Build the Docker image
docker build -t hitcounter:latest .

# Run the container
docker run -p 8000:8000 hitcounter:latest
```

### Accessing the API

- API Documentation: http://localhost:8000/
- API Endpoint: http://localhost:8000/hits

### Running Tests

```bash
mvn test
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /hits | Get the current hit count |
| PUT | /hits | Increment the hit counter |



## License

Copyright (c) IBM Corporation. All rights reserved.

Licensed under the Apache License. See [LICENSE](LICENSE)

---

## <h3 align="center"> © IBM Corporation 2025. All rights reserved. <h3/>